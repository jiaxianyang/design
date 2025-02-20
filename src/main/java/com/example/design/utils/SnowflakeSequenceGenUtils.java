package com.example.design.utils;

import java.util.concurrent.TimeUnit;

/**
 * 雪花算法工具类
 *
 * @author jiaxianyang
 * @date 2024/10/19 11:07
 */
public class SnowflakeSequenceGenUtils {

    /**
     * 避免被实例化
     */
    private SnowflakeSequenceGenUtils() {
    }

    /**
     * 用于计算雪花ID中时间戳部分的位移因子。
     */
    private static final long TIMESTAMP_SHIFT_FACTOR = 1L << (SnowflakeSequenceGen.WORKER_ID_BITS + SnowflakeSequenceGen.DATACENTER_ID_BITS + SnowflakeSequenceGen.SEQUENCE_BITS);

    /**
     * 计算自给定雪花ID生成器的ID以来的天数。
     *
     * @param snowflakeSequenceGenId 雪花ID生成器的ID。
     * @return 自给定ID以来的天数。
     */
    public static long calculateDaysSinceId(Long snowflakeSequenceGenId) {
        long minWaitTaskAssignTime = extractTimestampMsFromId(snowflakeSequenceGenId);
        return TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - minWaitTaskAssignTime);
    }

    /**
     * 从雪花ID中提取时间戳。
     *
     * @param snowflakeSequenceGenId 雪花序列生成器的ID
     * @return 对应的时间戳
     */
    public static long extractTimestampMsFromId(Long snowflakeSequenceGenId) {
        if (snowflakeSequenceGenId == null) {
            return SnowflakeSequenceGen.BASE_TIMESTAMP;
        }
        return snowflakeSequenceGenId / TIMESTAMP_SHIFT_FACTOR + SnowflakeSequenceGen.BASE_TIMESTAMP;
    }

    public static void main(String[] args) {
        System.out.println(extractTimestampMsFromId(1683307671224061952L));
//        1845804626922827776, 1848340407251988480
//        1849322789329190912

        long minWaitTaskAssignTime = extractTimestampMsFromId(1845804626922827776L);
        long minWaitTaskAssignTimeM = extractTimestampMsFromId(1848340407251988480L);
        long minWaitTaskAssignTimeK = extractTimestampMsFromId(1849322789329190912L);
        long minWaitTaskAssignTime3 = extractTimestampMsFromId(1848329078562656256L);
        System.out.println(TimeUnit.MILLISECONDS.toDays(minWaitTaskAssignTimeM - minWaitTaskAssignTime));
        System.out.println(TimeUnit.MILLISECONDS.toDays(minWaitTaskAssignTimeK - minWaitTaskAssignTime));
        System.out.println(TimeUnit.MILLISECONDS.toDays(minWaitTaskAssignTime3 - minWaitTaskAssignTime));
    }

}
