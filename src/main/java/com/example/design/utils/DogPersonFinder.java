package com.example.design.utils;

import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 寻找狗人
 *
 * @author jiaxianyang
 * @date 2024/9/25 10:07
 */
public class DogPersonFinder {

    public static void main(String[] args) throws IOException {
//        152	b4c03975d4658e71d3380e3849886b33	-1
        //获取狗人
        Set<String> dogPersonEncryptedErpTexts = Sets.newHashSet(Lists.newArrayList("b4c03975d4658e71d3380e3849886b33",
                "06bad17853be32ddbe5d96f3e6a91e35","4cc0bec9a3f56d28ced1c8d69b49c526"));
        Set<String> goodPersonEncryptedErpTexts = Sets.newHashSet(Lists.newArrayList("a7206d042b68194bd1c00e9cc6fd9f2a",
                "7cc4e478526d5209dd47cf90d72d9ffb"));
        Long rowId = Long.valueOf(152);
        searchDogPerson(dogPersonEncryptedErpTexts, goodPersonEncryptedErpTexts, rowId);
        System.out.println("三者对比=============== end");
        Set<String> dogPersonEncryptedUserTexts = Sets.newHashSet(Lists.newArrayList("f1ec0f7e3f40bcddf93a62a7b110041b",
                "06bad17853be32ddbe5d96f3e6a91e35"));
        Set<String> goodPersonEncryptedUserTexts = Sets.newHashSet(Lists.newArrayList("a7206d042b68194bd1c00e9cc6fd9f2a",
                "7cc4e478526d5209dd47cf90d72d9ffb"));
        //method 2 直接通过名字比对
        searchDogPersonByUser(dogPersonEncryptedUserTexts, goodPersonEncryptedUserTexts);
        System.out.println("单独对比=============== end");
        analysisApproval();
    }

    private static void analysisApproval() throws IOException {
        List<ApprovalRecord> approvalRecords = readExcelToApprovalRecord("/Users/jiaxianyang/self_code/design/src/main/resources/Record.xlsx");
        List<Person> peoples = readExcel("/Users/jiaxianyang/self_code/design/src/main/resources/手机号.xlsx");
        Map<String, Person> presonMap = new HashMap<>();
        peoples.forEach(person -> presonMap.put(getMD5Hash(person.getErp()), person));
        Map<String, Result> resultMap = new HashMap<>();
        approvalRecords.forEach(approvalRecord -> {
            Person person = presonMap.get(approvalRecord.getCreateUser());
            if (person == null) {
                return;
            }
            if (resultMap.containsKey(approvalRecord.getRowId())) {
                Result result = resultMap.get(approvalRecord.getRowId());
                if (approvalRecord.getStatus().equals("0")) {
                    result.getYesPerson().add(person.getErp());
                } else {
                    result.getNoPerson().add(person.getErp());
                }
            } else {
                Result result = new Result();
                result.setName(approvalRecord.getRowCreateName());
                result.setRowId(approvalRecord.getRowId());
                resultMap.put(approvalRecord.getRowId(), result);
                if (approvalRecord.getStatus().equals("0")) {
                    result.getYesPerson().add(person.getErp());
                } else {
                    result.getNoPerson().add(person.getErp());
                }
            }
        });

        // 按照键的长度从大到小排序
        List<Map.Entry<String, Result>> sortedEntries = new ArrayList<>(resultMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> new BigDecimal(entry2.getKey()).compareTo(new BigDecimal(entry1.getKey())));

        // 将排序后的结果放入一个新的 LinkedHashMap 以保持顺序
        Map<String, Result> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Result> entry : sortedEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        // 提取排序后的 Result 列表
        List<Result> sortedResults = new ArrayList<>();
        for (Map.Entry<String, Result> entry : sortedEntries) {
            sortedResults.add(entry.getValue());
        }

        System.out.println("============================ 分析报表=====================");
        System.out.println(JsonUtil.toJsonString(sortedResults));
    }

    private static void searchDogPersonByUser(Set<String> dogPersonEncryptedUserTexts, Set<String> goodPersonEncryptedUserTexts) throws IOException {
        List<Person> peoples = readExcel("/Users/jiaxianyang/self_code/design/src/main/resources/手机号.xlsx");
        List<String> dogPersonErps = Lists.newArrayList();
        List<String> goodPersonErps = Lists.newArrayList();
        peoples.forEach(person -> {
            if (dogPersonEncryptedUserTexts.contains(getMD5Hash(person.getErp()))) {
                dogPersonErps.add(person.getErp());
            } else if (goodPersonEncryptedUserTexts.contains(getMD5Hash(person.getErp()))) {
                goodPersonErps.add(person.getErp());
            }
        });
        System.out.println("dog persons is :" + dogPersonErps);
        System.out.println("good persons is :" + goodPersonErps);
    }

    private static void searchDogPerson(Set<String> dogPersonEncryptedTexts, Set<String> goodPersonEncryptedTexts, Long rowId) throws IOException {
        List<Person> peoples = readExcel("/Users/jiaxianyang/self_code/design/src/main/resources/手机号.xlsx");
        List<String> dogPersonErps = Lists.newArrayList();
        List<String> goodPersonErps = Lists.newArrayList();
        for (Person person : peoples) {
            String uniqueKey = loadEntryUniqueKey(rowId, person.getErp(), person.getMobilePhone());
            if (dogPersonEncryptedTexts.contains(uniqueKey)) {
                dogPersonErps.add(person.getErp());
            } else if (goodPersonEncryptedTexts.contains(uniqueKey)) {
                goodPersonErps.add(person.getErp());
            }
        }
        System.out.println("dog persons is :" + dogPersonErps);
        System.out.println("good persons is :" + goodPersonErps);
    }

    private static String loadEntryUniqueKey(Long rowId, String erp, String mobilePhone) {
        Long documentId = 9L;
        String unique = documentId + "_" + rowId + "_" + erp + "_" + mobilePhone;
        return getMD5Hash(unique);
    }

    public static String getMD5Hash(String input) {
        try {
            // 创建一个 MD5 算法的 MessageDigest 实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 计算哈希值
            byte[] hashBytes = md.digest(input.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Person> readExcel(String filePath) throws IOException {
        List<Person> people = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            for (Row row : sheet) {

                Cell nameCell = row.getCell(2); // A column
                Cell mobilePhoneCell = row.getCell(3);  // C column

                if (nameCell != null && mobilePhoneCell != null) {
                    String name = nameCell.getStringCellValue();
                    String mobilePhone = getCellValueAsString(mobilePhoneCell);

                    people.add(new Person(name, mobilePhone));
                }
            }
        }

        return people;
    }

    public static List<ApprovalRecord> readExcelToApprovalRecord(String filePath) throws IOException {
        List<ApprovalRecord> approvalRecords = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            for (Row row : sheet) {

                Cell erp = row.getCell(0); // A column
                Cell createUser = row.getCell(1);  // C column
                Cell status = row.getCell(2);  // C column
                Cell rowID = row.getCell(3);  // C column
                Cell rowCreateName = row.getCell(4);  // C column

                if (erp != null && createUser != null && status != null && rowID != null && rowCreateName != null) {
                    String erpStr = getCellValueAsString(erp);
                    String createUserStr = getCellValueAsString(createUser);
                    String statusStr = getCellValueAsString(status);
                    String rowIDStr = getCellValueAsString(rowID);
                    String rowCreateNameStr = getCellValueAsString(rowCreateName);
                    ApprovalRecord approvalRecord = new ApprovalRecord();
                    approvalRecord.setErp(erpStr);
                    approvalRecord.setStatus(statusStr);
                    approvalRecord.setRowId(rowIDStr);
                    approvalRecord.setCreateUser(createUserStr);
                    approvalRecord.setRowCreateName(rowCreateNameStr);
                    approvalRecords.add(approvalRecord);
                }
            }
        }

        return approvalRecords;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // 处理数值型单元格，将其转换为字符串
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    // 使用 BigDecimal 可以避免科学计数法问题
                    return BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String erp;
    private String mobilePhone;
}
@Data
class ApprovalRecord {
    private String rowId;
    private String erp;
    private String status;

    private String createUser;
    private String updateUser;
    private Date createTime;
    private Date updateTime;
    private String remark;
    private Integer yn;
    private String rowCreateName;
}

@Data
class Result {
    private String rowId;
    private String name;
    private Set<String> yesPerson = new HashSet<>();
    private Set<String> noPerson = new HashSet<>();
}
