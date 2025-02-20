package com.example.design.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Description: <br>
 *
 * @author mahongyan18
 * @date 2023/6/13 18:44
 */
public class Monitor618 {

    public static final String cookie = "shshshfpa=b6ff1d3d-b747-8f0c-ee4f-066c6e4b7f0a-1709116442; shshshfpx=b6ff1d3d-b747-8f0c-ee4f-066c6e4b7f0a-1709116442; jd.erp.lang=zh_CN; jdd69fo72b8lfeoe=G7NGGC5FUA55NZO662BT2TXYRG5ZHAWOKTYJXLOB7ESUCNIVM7HLTZASC25EQTN2MRXVSEWN3U7UI33N4QGXKOMWUE; mba_muid=17061878106901815878187; forum_erp=jiaxianyang; __jdu=1714378734247782949526; visitkey=5624532229655695068; retina=1; cid=9; webp=1; __wga=1717141318004.1717141318004.1717141318004.1717141318004.1.1; sc_width=1728; unpl=JF8EAMtnNSttURxXA0wDSEcYQ14AW14LSR8LbzBSBl8IHFMMGAMfGxN7XlVdWBRKEB9uYRRUXFNJXQ4fBisSEXtdVV9dCEkVC2dvNVdYUEpSBxsAdRN-SjNVMFxmSnkCAWZrVTNZJVVrGmwafBElXGRuXgh7FjNvYQVRX15CUgceAR4UFkJeXFtVDEgQM25XBVxaaHtkBR8AHxYWTlVXX20JexUDbmYAXFVbQ1E1UGwaXxBNXVFcWwFNFQZsYgNSVFtDUQ0fARwiEktdUlhtCw; __jdv=137579179%7Ckong%7Ct_1001133999_24907313_0_0_0_0_0_0_0_0_0_0_0_0_0_0%7Cjingfen%7C8f27f0bd992e4223991ffc3af6820582%7C1717727935963; 3AB9D23F7A4B3CSS=jdd0363K7GUCXNIG44ZLNRPQZ53LRDJ52FRRJ4XUWLRZZZIDKTQ2A6KQZUMGZIOCGDYFC4IUHQPKFQAJPFNPVYSZLCBR7AUAAAAMP6CID4OQAAAAADD3FHKLFB4WKQMX; shshshfpb=BApXcxqiY8-pA6NjQfYUnkGKzYAHjHwUeBelBtovo9xJ1MhV0OoC2; joyya=1717727935.1717727937.44.1pk44vv; RT=\"z=1&dm=jd.com&si=bdul9m33aa6&ss=lx49pj0z&sl=1&tt=gd&ld=18e&ul=arg&hd=aro\"; sso.jd.com=BJ.29FDDDF9AA6DBF3B1F8A8F1E70ABE462.0520240608105324; ssa.ticket=BJ.D520B560D6CDD19F3665FE62B389C282.1020240608105324S; 3AB9D23F7A4B3C9B=63K7GUCXNIG44ZLNRPQZ53LRDJ52FRRJ4XUWLRZZZIDKTQ2A6KQZUMGZIOCGDYFC4IUHQPKFQAJPFNPVYSZLCBR7AU; focus-token=ee.7d2304fec9e0f60263ed683d897a3db1; focus-team-id=00046419; focus-client=WEB; psverp2=s%3Ajiaxianyang%3B1717932125.GWPcuu7%2F896jM3U266%2BStAegHf3e4PFESpI0Yui8wXw; logbook_u=jiaxianyang; token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IkVNRks1Smk4RlNGeTVuMldCLU5jIiwiZXhwIjoxNzE4NTc2NTAyLCJpYXQiOjE3MTc5NzE3MDJ9.X_h2pCR4thZf5Z5oIIGBeoKhu29-PEnHfz4ksKI1ML0; __jda=230157721.1714378734247782949526.1714378734.1717935158.1717977774.161; __jdc=230157721; ssa.origin-api=2b16bf126a49e58d7aaf7d6b8a0030b348944ce9d16bb4e1b9dc06cb0754c20843c549670345373625054c1384ab232e3b71f1641a444d435723279b5ce0397c0cf348c93dc8622095e4cdc53f6aa375802aeb8e2fb8bf0b86e8f276e520954c9780380ba669b7acb4eb14f8388e9c4aef4bf4482a2a9b87ef3a24d1eda2b6d9; ssa.origin-gateway=66fd8fd459a60a025a1896a88dc48163cd832c44c7a5f1865bf015ac048f3d7e73132ccbb1fecb3263d67dfca6e6776b20badb9817f3cd3aa0852f95674114ebd7519dece699316921c9812d897995f070757de861dce9625b3b5b3dbc0bea3beefb68ea5ed83d39ec070b4beb13d53378b00b81ff8fdf4859e25688fa602a8d; ssa.global.ticket=ae43387c8139adc5f1e3b6cec99839e8e7bcffc22af8dec233bc3aab67cd4a7c; __jdb=230157721.11.1714378734247782949526|161.1717977774";

    public static void main(String[] args) throws Exception {
        // 粘贴ump的cookie进行替换
        // 替换统计时间
        String startTime = "2024-06-09 09:00:00";
        String endTime = "2024-06-10 09:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = sdf.parse(startTime).getTime() + "";
        String end = sdf.parse(endTime).getTime() + "";

        System.out.println("CPU 与 内存");
        queryCpuMem(start, end, cookie);
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("重点接口ump--简报格式");
        queryUmp(RenderTypeEnum.SIMPLE, start, end, cookie);
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("重点接口ump--完整格式");
        queryUmp(RenderTypeEnum.COMPLETE, start, end, cookie);
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("DB监控指标");


        queryOrderMysql(start, end);
    }

    /**
     * 生成mdc配置
     *
     * @return
     */
    private static List<MdcConfVo> genMdcConf() {
        List<MdcConfVo> mdcConfVoList = new ArrayList<>();
        mdcConfVoList.add(new MdcConfVo("wms6-basic-service", "wms6-outbound-interact", "交互"));
        mdcConfVoList.add(new MdcConfVo("wms6-outbound", "wms6-order", "单据"));
        mdcConfVoList.add(new MdcConfVo("wms6-outbound", "wms6-plan", "计划"));
        mdcConfVoList.add(new MdcConfVo("wms6-outbound", "wms6-task-assign", "任务分配"));
        mdcConfVoList.add(new MdcConfVo("wms6-outbound", "wms6-pick", "拣货"));
        mdcConfVoList.add(new MdcConfVo("wms6-outbound", "wms6-outbound", "复核"));
        mdcConfVoList.add(new MdcConfVo("wms6-common-service", "wms6-print", "打印"));
        mdcConfVoList.add(new MdcConfVo("wms6-common-service", "wms6-reporting", "报表"));
        mdcConfVoList.add(new MdcConfVo("wms6-basic-service", "wms6-outbound-notify", "回传"));

        return mdcConfVoList;

    }

    private static void queryCpuMem(String start, String end, String cookie) {
        //  http://taishan.jd.com/mdc/machine?sysName=wms6-common-service&appName=wms6-print
        // 替换mdc的sysName，appName

        final List<MdcConfVo> mdcConfVoList = genMdcConf();
        for (MdcConfVo mdcConfVo : mdcConfVoList) {
            queryCpuMem(cookie, mdcConfVo, start, end);
        }
    }

    private static void queryCpuMem(String cookie, MdcConfVo mdcConfVo, String start, String end) {
        Map<String, List<String>> map = queryMdcGroup(cookie, mdcConfVo.getAppCode());
        // System.out.println(mdcConfVo.getAppCode());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//             System.out.println(entry.getKey());

            // 分组编码
            mdcConfVo.setGroupCode(entry.getKey());
            queryCpuMem(cookie, mdcConfVo, start, end, entry.getValue());
        }
        System.out.println();
    }


    private static void queryOrderMysql(String start, String end) throws Exception {
        // 可替换为指定的 数据库url，appName从http://monitor.easyops.jdl.com/ 看
//        queryMysql(start, end, "mysql-cn-north-1-a399cc7ac9074f58.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-7ffeffdf9ea14adb.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-746cb0fcc8b34437.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-f7e63ce263c94b37.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-1092aa89d56e4225.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-c63f5928ae5a4155.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-9f51fde9567f40db.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-a5b6e5490b4b4231.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-e1b59f919c7c4775.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-930f0394b903439e.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-b507c1a9906b4277.rds.jdcloud.com", "wms6-order");
//        queryMysql(start, end, "mysql-cn-north-1-aca08e35b5954455.rds.jdcloud.com", "wms6-order");


        // read db urls from file
        Arrays.stream(
                ("mysql-cn-north-1-7473da2911fc48ad.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-e1b59f919c7c4775.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-1092aa89d56e4225.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-d7b910fd14f44f25.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-f0571f845ae3441a.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-24449fe280f448da.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-a3f6e45c3b7e4e9a.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-3111ef9d8a56456a.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-0ce4376f7e5743e3.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-a5b6e5490b4b4231.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-40af07fad19a4bab.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-d774d03b5d154dc1.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-6af51172dbdf4f66.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-3255bd360c804bba.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-9afd42bc792e4321.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-8633fb0a31044f14.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-fc32de9d6b414d03.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-9271e381c5a94ad6.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-aca08e35b5954455.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-76a79822590a4f76.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-4b5f28263d4e4071.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-82930eea8a2749f7.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-a399cc7ac9074f58.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-44501c4d72594a22.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-b507c1a9906b4277.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-ae85b266d4bf4e0a.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-e8f8314528824f92.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-f7e63ce263c94b37.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-818f134d6a9c4ee3.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-146d32f501ca46b5.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-0e6ea60e554d4bde.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-a7080cd617bd4a17.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-9f51fde9567f40db.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-dd30520cc5cc4a97.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-cf9aed82a57646cb.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-4c3b5662b5a7484d.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-8ef5fc712758498a.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-642a3dde2ef94561.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-a6facc8517644b98.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-930f0394b903439e.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-7ffeffdf9ea14adb.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-9f3255fd4fdc4b55.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-c63f5928ae5a4155.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-54dc61ad5a2b4587.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-d11260ea1c624288.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-746cb0fcc8b34437.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-103308902d614330.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-63756953642844ab.rds.jdcloud.com\n" +
                        "mysql-cn-north-1-2bdd39d6d9d84688.rds.jdcloud.com")
                        .split("\n")).forEach(url -> {

            try {
                queryMysql(start, end, url, "wms6-order");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    // mysql 最大的cpu，磁盘io，qps，tps，运行时连接数
    private static void queryMysql(String min, String max, String mysqlUrl, String appName) throws Exception {

        System.out.println();
        System.out.print(mysqlUrl);
        // cpu
        queryMysql(min, max, mysqlUrl, appName, "rds.instance.cpu.util");
        // 磁盘使用率
        queryMysql(min, max, mysqlUrl, appName, "rds.instance.disk.usage");
        // QPS
        queryMysql(min, max, mysqlUrl, appName, "rds.database.throughput.qps");
        // TPS
        queryMysql(min, max, mysqlUrl, appName, "rds.database.throughput.tps");
        // 运行时连接数
        queryMysql(min, max, mysqlUrl, appName, "rds.database.connect.running");
    }

    /**
     * 获取ump配置
     *
     * @return
     */
    private static List<UmpConfVo> genUmpConf() {
        List<UmpConfVo> umpConfVoList = new ArrayList<>();

        umpConfVoList.add(new UmpConfVo("交互接单", "wms6-outbound-interact_prod_provider_CustomerOrderReceiveAppService_receiveOrder"));
        umpConfVoList.add(new UmpConfVo("出库接单", "wms6-order_prod_provider_ShipmentOrderAppService_receivedOrderInfo"));
        umpConfVoList.add(new UmpConfVo("分批计算出库单SKU拣货储位位置任务", "wms6-plan_prod_outboundPlan_autoBatchLocate_execute"));
        umpConfVoList.add(new UmpConfVo("获取生产许可", "wms6-order_prod_provider_OutboundShipmentOrderAppService_obtainProductionLicense"));
        umpConfVoList.add(new UmpConfVo("查询待组集合单生产单", "wms6-task-assign_prod_request_task_assign_orderQuery_queryWaitTaskAssignOrderInfo"));
        umpConfVoList.add(new UmpConfVo("按生产单列表组建集合单", "wms6-task-assign_prod_request_task_assign_taskAssignOperation_doTaskAssign"));
        umpConfVoList.add(new UmpConfVo("按条件组建集合单", "wms6-task-assign_prod_request_task_assign_taskAssignOperation_doTaskAssignForAll"));
        umpConfVoList.add(new UmpConfVo("系统推荐拣货任务", "jdos_wms6-pick_prod_request_picking_task_autoFetchPickingTask"));
        umpConfVoList.add(new UmpConfVo("拣货下架", "jdos_wms6-pick_prod_request_picking_underCarriage"));
        umpConfVoList.add(new UmpConfVo("领取复核任务", "jdos_wms6-outbound_hb_request_outbound_batchCheck_claimCheckTask"));
        umpConfVoList.add(new UmpConfVo("复核单据货品数量", "jdos_wms6-outbound_hb_request_outbound_boxingCheck_confirmChecked"));
        umpConfVoList.add(new UmpConfVo("批量复核", "jdos_wms6-outbound_hb_request_outbound_batchCheck_checkBySo"));
        umpConfVoList.add(new UmpConfVo("打包", "jdos_wms6-outbound_hb_request_outbound_pack_commit"));
        umpConfVoList.add(new UmpConfVo("发货", "jdos_wms6-outbound_hb_request_outbound_shipping_deliver_shippingBySo"));
        return umpConfVoList;
    }


    private static void queryUmp(RenderTypeEnum renderType, String start, String end, String cookie) {
        // 替换统计的umpKey
        for (UmpConfVo umpConfVo : genUmpConf()) {
            queryUmpKey(renderType, start, end, umpConfVo, cookie);
        }
    }

    // 请求量最大时的 请求量,tp99,可用率
    private static void queryUmpKey(RenderTypeEnum renderType, String startTime, String endTime, UmpConfVo umpConfVo, String cookie) {
        try {
            // 构建请求URL和参数
            String urlStr = "http://api-proxy.taishan.jd.com/api/ump/v1/ump/method/ts";
            String granularity = "oneMinute";
            String quickTime = "";
            String intelligent = "0";
            String realtime = "false";

            String requestUrl = urlStr + "?"
                    + "keys=" + umpConfVo.getUmpKey()
                    + "&start_time=" + startTime
                    + "&end_time=" + endTime
                    + "&granularity=" + granularity
                    + "&quickTime=" + quickTime
                    + "&intelligent=" + intelligent
                    + "&realtime=" + realtime;

            // 发送请求获取数据
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Cookie", cookie);
            connection.setRequestProperty("erp", "org.wms.outbound.o1");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            // 解析JSON数据
            JSONObject jsonObject = JSONObject.parseObject(response.toString());
            JSONObject responseData = jsonObject.getJSONObject("response_data");
            JSONObject monitorData = responseData.getJSONObject("monitorData");
            JSONArray receivedOrderInfo = monitorData.getJSONArray(umpConfVo.getUmpKey());

            // 获取totalCount最大的数据项
            int maxTotalCount = -1;
            JSONObject targetData = null;
            for (int i = 0; i < receivedOrderInfo.size(); i++) {
                JSONObject data = receivedOrderInfo.getJSONObject(i);
                int totalCount = Integer.parseInt(data.getString("totalCount"));
                if (totalCount > maxTotalCount) {
                    maxTotalCount = totalCount;
                    targetData = data;
                }
            }

            // 解析数据
            String availRate = targetData.getString("availRate");
            String tp99 = targetData.getString("tp99");
            String dataTimeStr = targetData.getString("dataTime");
            String totalCountStr = targetData.getString("totalCount");

            // 将字符串类型的时间转换成Date类型，并且转换成北京时间
            long dataTimeLong = Long.parseLong(dataTimeStr);
            Date dataTime = new Date(dataTimeLong);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataTimeBeijing = sdf.format(dataTime);

            if (RenderTypeEnum.SIMPLE == renderType) {
                final Map<String, String> renderConf = renderType.getRenderConf();
                if (renderConf.containsKey(umpConfVo.getBusinessName())) {
                    // 简报指标
                    String renderRet =
                            (renderConf.get(umpConfVo.getBusinessName()))
                                    + "\t" + dataTimeBeijing
                                    + "\t" + "峰值流量" + totalCountStr + "/分"
                                    + "\ttp99峰值 " + tp99 + " ms"
                                    + "\t可用率" + availRate + "%";
                    System.out.println(renderRet);
                }
            } else {
                // 简报指标
                String renderRet =
                        umpConfVo.getBusinessName()
                                + "\t" + dataTimeBeijing
                                + "\t峰值流量" + totalCountStr + "/分"
                                + "\ttp99峰值 " + tp99 + " ms"
                                + "\t可用率" + availRate + "%";
                System.out.println(renderRet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void queryMysql(String min, String max, String link, String appName, String indicator) throws Exception {

        URL url = new URL("http://monitor.easyops.jdl.com/api/datasources/proxy/20/_msearch?max_concurrent_shard_requests=5");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
        con.setRequestProperty("Connection", "keep-alive");
        con.setRequestProperty("Cookie", cookie);
        con.setRequestProperty("Origin", "http://monitor.easyops.jdl.com");
        con.setRequestProperty("Referer", "http://monitor.easyops.jdl.com/d/kJULFK13/mysqljian-kong?orgId=1&var-appName=" + appName + "&var-appDeployPlatform=All&var-resourceId=All&var-internalAddress=" + link + "&kiosk=tv&from=" + min + "&to=" + max);
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
        con.setRequestProperty("accept", "application/json, text/plain, */*");
        con.setRequestProperty("content-type", "application/json");
        con.setRequestProperty("x-grafana-org-id", "1");
        con.setDoOutput(true);
        String jsonInputString = "{\"search_type\":\"query_then_fetch\",\"ignore_unavailable\":true,\"index\":\"delta-monitor-*\"}\n{\"size\":0,\"query\":{\"bool\":{\"filter\":[{\"range\":{\"@timestamp\":{\"gte\":" + min + ",\"lte\":" + max + ",\"format\":\"epoch_millis\"}}},{\"query_string\":{\"analyze_wildcard\":true,\"query\":\"labels.internalAddress:(\\\"" + link + "\\\") AND labels.appName:" + appName + "\"}}]}},\"aggs\":{\"3\":{\"terms\":{\"field\":\"labels.internalAddress\",\"size\":500,\"order\":{\"_key\":\"desc\"},\"min_doc_count\":" + "1" + "},\"aggs\":{\"2\":{\"date_histogram\":{\"interval\":\"2m\",\"field\":\"@timestamp\",\"min_doc_count\":0,\"extended_bounds\":{\"min\":" + min + ",\"max\":" + max + "},\"format\":\"epoch_millis\"},\"aggs\":{\"1\":{\"max\":{\"field\":\"" + indicator + "\"}}}}}}}}\n";

        try (OutputStream stream = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            stream.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            JSONObject jsonObject = JSON.parseObject(response.toString());

            JSONArray responsesArray = jsonObject.getJSONArray("responses");
            JSONObject firstResponseObject = responsesArray.getJSONObject(0);

            JSONObject aggregationsObject = firstResponseObject.getJSONObject("aggregations");
            JSONObject bucket3Object = aggregationsObject.getJSONObject("3");

            JSONArray bucketsArray = bucket3Object.getJSONArray("buckets");
            JSONObject firstBucketObject = bucketsArray.getJSONObject(0);

            JSONObject bucket2Object = firstBucketObject.getJSONObject("2");
            JSONArray innerBucketsArray = bucket2Object.getJSONArray("buckets");

            ArrayList<JSONObject> list = new ArrayList<>();

            for (int i = 0; i < innerBucketsArray.size(); i++) {
                JSONObject innerBucketObject = innerBucketsArray.getJSONObject(i);
                JSONObject innerBucket1Object = innerBucketObject.getJSONObject("1");
                Double value = innerBucket1Object.getDouble("value");

                if (value != null) {
                    String keyAsString = innerBucketObject.getString("key_as_string");

                    JSONObject valueObject = new JSONObject();
                    valueObject.put("value", new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    valueObject.put("key_as_string", keyAsString);

                    list.add(valueObject);
                }
            }

            list.sort((o1, o2) -> {
                double v1 = o1.getDoubleValue("value");
                double v2 = o2.getDoubleValue("value");
                return Double.compare(v2, v1);
            });

            if (list.size() > 0) {
                JSONObject topValueObject = list.get(0);
                double value = topValueObject.getDoubleValue("value");
                String keyAsString = topValueObject.getString("key_as_string");

                Date date = new Date(Long.parseLong(keyAsString));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);

//                if(indicator.contains("cpu")) {
//                    System.out.println("CPU\t" + formattedDate + "\t" + value + "%");
//                }
//                if (indicator.contains("disk")) {
//                    System.out.println("磁盘使用率\t" + formattedDate + "\t" + value + "%");
//                }
//                if (indicator.contains("qps")) {
//                    System.out.println("QPS\t"+formattedDate + "\t" +  String.format("%.2f", value / 1000.0) + "K");
//                }
//                if (indicator.contains("tps") ) {
//                    System.out.println("TPS\t" + formattedDate + "\t" + value);
//                }
//                if (indicator.contains("running")) {
//                    System.out.println("连接数\t" + formattedDate + "\t" + value);
//                }


                if (indicator.contains("cpu")) {
                    System.out.print("\t" + formattedDate + "（" + value + "%）");
                }
                if (indicator.contains("disk")) {
                    System.out.print("\t" + formattedDate + "（" + value + "%）");
                }
                if (indicator.contains("qps")) {
                    System.out.print("\t" + formattedDate + "（" + String.format("%.2f", value / 1000.0) + "K）");
                }
                if (indicator.contains("tps")) {
                    System.out.print("\t" + formattedDate + "（" + value + ")");
                }
                if (indicator.contains("running")) {
                    System.out.print("\t" + formattedDate + "(" + value + ")");
                }
            } else {
                System.out.println("\t\t");
            }

        }
    }


    private static void queryCpuMem(String cookie, MdcConfVo mdcConfVo, String start, String end, List<String> groups) {
        final List<String> tagList = Arrays.asList("min_cpu_usage_percent", "min_mem_usage_percent");

        StringBuilder resultBuilder = new StringBuilder(mdcConfVo.getAppName() + ":【" + mdcConfVo.getGroupCode() + "】\t");
        for (String tag : tagList) {
            List<Result> resultList = new ArrayList<>();
            for (String group : groups) {
                Result result = queryCpuMem(cookie, mdcConfVo.getSysCode(), mdcConfVo.getAppCode(), group, start, end, tag);
                if (result != null) {
                    resultList.add(result);
                }
            }
            if (resultList.isEmpty()) {
                continue;
            }
            Result result = resultList.stream().max(Comparator.comparingDouble(a -> a.data)).get();
            if (tag.contains("cpu")) {
                resultBuilder.append(" CPU < " + String.format("%.2f%%", result.data));
            } else {
                resultBuilder.append(" 内存 < " + String.format("%.2f%%", result.data));
            }
        }

        System.out.println(resultBuilder);
    }

    /**
     * 生成分组key
     *
     * @param groupName
     * @return
     */
    private static String genGroupKey(String appName, String groupName) {
//        // 解决报表分组JX集群分组码无jx标识问题
//        String groupNameFixed = groupName;
//        if ("wms6-reporting".equals(appName)) {
//            if (!groupName.contains("ka")) {
//                groupNameFixed = "jx-" + groupName;
//            } else {
//                groupNameFixed = "ka1-" + groupName;
//            }
//        }
//        boolean rt = groupNameFixed.contains("rt");
//        if (rt) {
//            return groupNameFixed
//                    .split("-")[0] + "-rt";
//        }
        return groupName;
    }

    private static Map<String, List<String>> queryMdcGroup(String cookie, String appName) {
        Map<String, List<String>> groupAliasMap = new HashMap<>();
        try {
            URL url = new URL("http://api-proxy3.taishan.jd.com/api/components/v1/query/componentId?app=" + appName + "&platform=jdos&componentType=jdos&psv_cacheMaxAge=1&psv_cacheSwr=172800");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Cookie", cookie);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject json = JSON.parseObject(response.toString());
            if (json.getBoolean("isSuccess")) {
                JSONArray seriesArr = json.getJSONArray("responseData");
                for (int i = 0; i < seriesArr.size(); i++) {
                    JSONObject object = seriesArr.getJSONObject(i);
                    String groupName = object.getString("groupName");
                    if (groupName.contains("UAT") || groupName.contains("uat") || groupName.contains("gray")) {
                        continue;
                    }

//                    // 临时忽略复核空分组
//                    if ("wms6-outbound".equals(appName) && ("ka1-hb-high-zyx".equals(groupName) || "ka1-hb-high-yf".equals(groupName))) {
//                        continue;
//                    }

                    String groupKey = genGroupKey(appName, groupName);
                    if (groupAliasMap.containsKey(groupKey)) {
                        groupAliasMap.get(groupKey).add(groupName);
                    } else {
                        ArrayList<String> groups = new ArrayList<>(Collections.singletonList(groupName));
                        Collections.sort(groups);
                        groupAliasMap.put(groupKey, groups);
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return groupAliasMap;
    }

    private static Result queryCpuMem(String cookie, String sysName, String appName, String group, String start, String end, String tag) {
        try {
            URL url = new URL("http://api-proxy.taishan.jd.com/api/mdc3/v2/metrics/query_series_by_app_info?data_type=0&step=60&metric_name=" + tag + "&agg=max&by=&system=" + sysName + "&app=" + appName + "&platform=jdos&group=" + group + "&start_time=" + start + "&end_time=" + end);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Cookie", cookie);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String response = in.readLine();
            JSONObject json = JSON.parseObject(response);
            if (json.getString("code").equals("10000")) {
                JSONArray metricRespList = json.getJSONObject("data").getJSONArray("metricRespList");
                if (metricRespList.isEmpty()) {
                    return null;
                }
                JSONArray seriesArr = metricRespList.getJSONObject(0).getJSONArray("series");
                double maxValue = -1;
                long maxTime = -1;
                for (int i = 0; i < seriesArr.size(); i++) {
                    JSONObject seriesObj = seriesArr.getJSONObject(i);
                    double value = seriesObj.getDoubleValue("value");
                    if (value > maxValue) {
                        maxValue = value;
                        maxTime = seriesObj.getLongValue("timestamp");
                    }
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(maxTime * 1000);

                return new Result(sdf.format(date), maxValue);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class Result {
        String time;
        double data;

        Result(String time, double data) {
            this.time = time;
            this.data = data;
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class MdcConfVo {
    /**
     * 系统编码
     */
    private String sysCode;
    /**
     * 应用编码
     */
    private String appCode;
    /**
     * 系统名称
     */
    private String appName;
    /**
     * 分组编码
     */
    private String groupCode;

    public MdcConfVo(String sysCode, String appCode, String appName) {
        this.sysCode = sysCode;
        this.appCode = appCode;
        this.appName = appName;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class UmpConfVo {
    /**
     * 业务名
     */
    private String businessName;
    /**
     * umpKey
     */
    private String umpKey;
}

enum RenderTypeEnum {
    /** 简报 */
    SIMPLE{
        @Override
        Map<String, String> getRenderConf() {
            // 简报取值配置
            final Map<String, String> renderConf = new HashMap<>();
            renderConf.put("出库接单", "接单");
            renderConf.put("分批计算出库单SKU拣货储位位置任务", "定位");
            renderConf.put("按生产单列表组建集合单", "组建集合单");
            renderConf.put("拣货下架", "拣货下架");
            renderConf.put("复核单据货品数量", "复核");
            renderConf.put("打包", "打包");
            renderConf.put("发货", "发货");
            return renderConf;
        }
    },
    /** 完整 */
    COMPLETE{
        @Override
        Map<String, String> getRenderConf() {
            return new HashMap<>();
        }
    };

    /***
     * 获取渲染配置
     * @return
     */
    abstract Map<String, String> getRenderConf();
}