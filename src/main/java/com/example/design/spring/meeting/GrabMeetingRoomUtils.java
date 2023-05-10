package com.example.design.spring.meeting;


import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * GrabMeetingRoomUtils简介
 * <p>
 * 抢会议室
 *
 * @author jiaxianyang
 * @date 2022-11-16 18:51
 */
@Slf4j
@Component
public class GrabMeetingRoomUtils {

    private ThreadPoolExecutor parallelThreadPool;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @PostConstruct
    public void init() {
        parallelThreadPool = new ThreadPoolExecutor(5
                , 5
                , 100
                , TimeUnit.SECONDS
                , new SynchronousQueue<>()
                , new ThreadFactoryBuilder().setNameFormat("parallelThreadPoolTask-%s").build()
                , new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @PreDestroy
    public void preDestroy() {
        /**
         * 关闭线程池
         */
        parallelThreadPool.shutdown();
        log.info("parallelThreadPool already destroyed ======================");
    }

//    @Scheduled(fixedRate = 30)
    public void scheduledGrabMeetingRoom() {
        LocalDateTime afterLocalTime = LocalDateTime.parse("2022-11-18 08:59:10", dtf);
        LocalDateTime beforeLocalTime = LocalDateTime.parse("2022-11-18 09:01:10", dtf);
        LocalDateTime now = LocalDateTime.now();
        if (!(now.isAfter(afterLocalTime) && now.isBefore(beforeLocalTime))) {
            System.out.println("还未开始");
            return;
        }
        System.out.println("开始了===================================");
        GrabMeetingParam param1 = GrabMeetingParam.createHongYanInstance("2022-11-21", 930, 1030);
        GrabMeetingParam param2 = GrabMeetingParam.createWanQiuInstance("2022-11-21", 1600, 1700);
        GrabMeetingParam param3 = GrabMeetingParam.createWanQiuInstance("2022-11-21", 1700, 1800);
        List<GrabMeetingParam> grabMeetingParams = Lists.newArrayList(param1, param2, param3);
        List<CompletableFuture<String>> completableFutures = grabMeetingParams.stream()
                .map(grabMeetingParam -> CompletableFuture.supplyAsync(() -> {

                    try {
                        return grabMeetingRoom(grabMeetingParam);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "";
                }, parallelThreadPool)).collect(Collectors.toList());

        List<String> returnStrList = completableFutures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(JsonUtil.toJsonString(returnStrList));
    }

    public static void main(String[] args) {
        GrabMeetingParam param1 = GrabMeetingParam.createHongYanInstance("2022-11-18", 930, 1030);
        GrabMeetingParam param2 = GrabMeetingParam.createWanQiuInstance("2022-11-18", 1600, 1700);
        GrabMeetingParam param3 = GrabMeetingParam.createWanQiuInstance("2022-11-18", 1700, 1800);
        List<GrabMeetingParam> grabMeetingParams = Lists.newArrayList(param1, param2, param3);
        List<CompletableFuture<String>> completableFutures = grabMeetingParams.stream()
                .map(grabMeetingParam -> CompletableFuture.supplyAsync(() -> {

                    try {
                        return grabMeetingRoom(grabMeetingParam);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "";
                })).collect(Collectors.toList());
        List<String> returnStrList = completableFutures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(JsonUtil.toJsonString(returnStrList));
    }


    public static String grabMeetingRoom(GrabMeetingParam param) throws IOException {
        long start = System.currentTimeMillis();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
//        RequestBody body = RequestBody.create(mediaType, "{\"meetingName\":\"清朝\",\"meetingCode\":\"2001008342\",\"workplaceCode\":\"1001000725\",\"districtCode\":\"13\",\"meetingEstimateDate\":\"2022-11-18\",\"meetingEstimateStime\":1230,\"meetingEstimateEtime\":1330,\"bookJoyMeeting\":0,\"joyMeetingParam\":{\"meeting\":{\"password\":\"\"}},\"meetingSubject\":\"贾先阳预约了清朝\",\"lang\":\"zh\"}");
        RequestBody body = RequestBody.create(mediaType, JsonUtil.toJsonString(param));
        Request request = new Request.Builder()
                .url("https://jmrs.jd.com/meetingOrder/create")
                .method("POST", body)
                .addHeader("Host", "jmrs.jd.com")
                .addHeader("Cookie", "jd.erp.lang=zh_CN; focus-lang=zh_CN; token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IkVNRks1Smk4RlNGeTVuMldCLU5jIiwiaWF0IjoxNjY4Mjc0ODM2LCJleHAiOjE2Njg4Nzk2MzZ9.RsHjNl1RX56UdiDmELm8vLPRnFr3447tNbV0T29eDmA; __jdv=142635827|direct|-|none|-|1668405382040; __jdu=16684053820401167570963; __jda=234025733.16684053820401167570963.1668405382.1668589666.1668645718.8; __jdc=234025733; sso.jd.com=BJ.A18048E3209106F9054879B5A81187951920221117145807; focus-token=fbfac3682b61c6aada28712b6cb887b3; focus-team-id=00046419; RT=\"z=1&dm=jd.com&si=y6vxv4zqvlg&ss=lakco747&sl=0&tt=0&ld=2pi&nu=d41d8cd98f00b204e9800998ecf8427e&cl=gpuff\"")
                .addHeader("jms-email", "jiaxianyang%40jd.com")
                .addHeader("jms-real-name", "%E8%B4%BE%E5%85%88%E9%98%B3")
                .addHeader("jms-entry-type", "ssoHk")
                .addHeader("jms-lang", "zh")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.128 Electron/12.1.2 Safari/537.36 jdme-desktop-election-tab-browser")
                .addHeader("jms-user-name", "jiaxianyang")
                .addHeader("content-language", "en")
                .addHeader("access-control-allow-origin", "*")
                .addHeader("accept", "application/json, text/plain, */*")
                .addHeader("jms-tenant-code-list", "null")
                .addHeader("content-type", "application/json;charset=UTF-8")
                .addHeader("jms-tenant-code", "CN.JD.GROUP")
                .addHeader("origin", "https://jmrs.jd.com")
                .addHeader("sec-fetch-site", "same-origin")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("referer", "https://jmrs.jd.com/saas/sso")
                .addHeader("accept-language", "zh-CN")
                .build();
        Response response = client.newCall(request).execute();

        String result = response.body().string();
        System.out.println("结果：" + result);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        return result;
    }
}
