package com.example.design.utils;

import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FileReaderUtils {

    public static final String filePath = "";
    public static final Set<String> result2 = Sets.newConcurrentHashSet();
    public static final Map<String, AtomicInteger> result = Maps.newConcurrentMap();


    public  static final ThreadPoolExecutor dealPool = new ThreadPoolExecutor(3, 3, 30, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(500), new ThreadFactoryBuilder().setNameFormat("readData-%s").build()
            , new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> filePaths = Lists.newArrayList("出库单据_扩展属性_10_01__10_15_20211230160953.text",
                "出库单据_扩展属性_11月_20211230123741.text", "出库单据_扩展属性_近30天_20211230123611.text");

//        ,
//        "3.text",
//                "2.text"
        CountDownLatch countDownLatch = new CountDownLatch(filePaths.size());
        filePaths.forEach(filePath -> dealPool.submit(() -> {
            try {
                readFile(countDownLatch, filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        countDownLatch.await();
        System.out.println(result);
        result.forEach((key, count) -> {
            System.out.println(key  + ", count: " + count);
        });
        System.out.println(result2);
    }

    private static void readFile(CountDownLatch countDownLatch, String filePath) throws IOException { Reader reader = null;
        BufferedReader br = null;
        try {
            reader = new InputStreamReader(FileUtils.class.getClassLoader().getResourceAsStream(filePath), "UTF-8");
            br = new BufferedReader(reader);
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                Map<String, Object> map = null;
                try {
                    map = JsonUtil.parseObject(line, Map.class);
                } catch (Exception e) {
                    continue;
                }
                map.forEach((key, value) -> {
                    if (result.containsKey(key)) {
                        result.get(key).incrementAndGet();
                    } else {
                        result.putIfAbsent(key, new AtomicInteger(0));
                        result.get(key).incrementAndGet();
                    }
                    result2.add(key);
                });
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (br != null) {
                br.close();
            }
            countDownLatch.countDown();
        }
    }
}
