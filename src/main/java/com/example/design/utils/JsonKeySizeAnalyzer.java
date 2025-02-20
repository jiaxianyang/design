import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JsonKeySizeAnalyzer {

    private static Map<String, Long> keySizeMap = new HashMap<>();

    private static long calculateSize(JsonNode node) {
        long size = 0;

        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                long fieldSize = field.getKey().getBytes(StandardCharsets.UTF_8).length + 2 // Key size with quotes
                        + 1 // Colon
                        + calculateSize(field.getValue());
                keySizeMap.put(field.getKey(), keySizeMap.getOrDefault(field.getKey(), 0L) + fieldSize);
                size += fieldSize + 1; // Comma
            }
            size += 2; // Opening and closing braces
        } else if (node.isArray()) {
            for (JsonNode item : node) {
                size += calculateSize(item) + 1; // Comma
            }
            size += 2; // Opening and closing brackets
        } else if (node.isTextual()) {
            size += node.asText().getBytes(StandardCharsets.UTF_8).length + 2; // String size with quotes
        } else if (node.isNumber()) {
            size += node.asText().getBytes(StandardCharsets.UTF_8).length; // Number size as string
        } else if (node.isBoolean()) {
            size += node.asText().length(); // Boolean size as string
        } else if (node.isNull()) {
            size += 4; // Null size as "null"
        }

        return size;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File("/Users/jiaxianyang/self_code/design/src/main/java/com/example/design/utils/taskAssign_selectOption_mergeCalCondition_652_2251.json"));
            long totalSize = calculateSize(rootNode);

            System.out.println("key 值总大小" + totalSize + " bytes");

            // Sort the keys by size in descending order
            List<Map.Entry<String, Long>> sortedKeys = new ArrayList<>(keySizeMap.entrySet());
            sortedKeys.sort((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()));

            // Print the top 10 keys with their size and percentage
            System.out.println("Top 10 largest keys by size:");
            for (int i = 0; i < Math.min(10, sortedKeys.size()); i++) {
                Map.Entry<String, Long> entry = sortedKeys.get(i);
                double percentage = (entry.getValue() * 100.0) / totalSize;
                System.out.printf("Key: %s, Size: %d bytes, Percentage: %.2f%%%n", entry.getKey(), entry.getValue(), percentage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
