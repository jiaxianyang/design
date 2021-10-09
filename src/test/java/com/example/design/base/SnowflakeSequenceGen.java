package com.example.design.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * SnowflakeSequenceGen 雪花算法生产id
 */
public class SnowflakeSequenceGen {
    private static final Logger LOGGER = LoggerFactory.getLogger(SnowflakeSequenceGen.class);

    /**
     * 设置一个时间初始值  不可以随意调整， 必须是固定值2021-08-14 01:04:23对应的时间戳， 调整会导致id重复   2^41 - 1  差不多可以用69年
     */
    public final static long BASE_TIMESTAMP = 1628874263273L;

    /**
     * 5位的机器id
     */
    public static final long WORKER_ID_BITS = 5L;

    /**
     * 5位的机房id
     */
    public static final long DATACENTER_ID_BITS = 5L;

    /**
     * 这个是二进制运算，就是5 bit最多只能有31个数字，也就是说机器id最多只能是32以内
     */
    private final static long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    /**
     * 这个是一个意思，就是5 bit最多只能有31个数字，机房id最多只能是32以内
     */
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);

    /**
     * 内存序列使用的位长,每毫秒内产生的id数 2 的 12次方 1ms内在内存中最多可以生成4096个序列
     */
    public final static long SEQUENCE_BITS = 12L;

    /**
     * 时间戳位移数
     */
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    /**
     * 机房号位移数
     */
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    /**
     * 库房号位移数
     */
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;

    /**
     * 每毫秒最大值 4095 生成范围【0，4095】
     */
    private final static long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    /**
     * 因为二进制里第一个 bit 为如果是 1，那么都是负数，但是我们生成的 id 都是正数，所以第一个 bit 统一都是 0。
     * 机器ID  2进制5位  32位减掉1位 31个
     */
    private final long workerId;

    /**
     * 机房ID 2进制5位  32位减掉1位 31个
     */
    private final long datacenterId;

    /**
     * 代表一毫秒内生成的多个id的最新序号  12位 （0 - 4096 -1） = 4096 个
     */
    private long sequence = 0L;

    /**
     * 记录产生时间毫秒数，判断是否是同1毫秒
     */
    private long lastTimestamp = -1L;

    /**
     * 构造函数
     * 可以将5位的机器id和机房id合并，那么就workId的范围就扩大到[0, 1023]
     *
     * @param workerId     机器id
     * @param datacenterId 机房id
     */
    public SnowflakeSequenceGen(long workerId, long datacenterId) {
        // 检查机房id和机器id是否超过31 不能小于0
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    /**
     * 这个是核心方法，通过调用gen()方法，让当前这台机器上的snowflake算法程序生成一个全局唯一的id,synchronized保证串行获取
     */
    public synchronized long gen() {
        // 这儿就是获取当前时间戳，单位是毫秒
        long timestamp = timeGen();
        while (timestamp < lastTimestamp) {
            LOGGER.warn("timeAlarm timestamp < lastTimestamp, {} < {}", timestamp, lastTimestamp);
            //优化点，如果当前时间戳小于上次生成id的时间睡5微秒后重新获取当前时间戳（睡的目的：防止cpu自旋，浪费cpu性能）
            sleepSafeMis(5);
            timestamp = timeGen();
        }

        // 下面是说假设在同一个毫秒内，又发送了一个请求生成一个id，这个时候就得把seqence序号给递增1，最多就是4096
        if (lastTimestamp == timestamp) {

            // 这个意思是说一个毫秒内最多只能有4096个数字，无论你传递多少进来，
            //这个位运算保证始终就是在4096这个范围内，避免你自己传递个sequence超过了4096这个范围 类似相加
            sequence = (sequence + 1) & SEQUENCE_MASK;
            //当某一毫秒的时间，产生的id数 超过4095，系统会进入等待，直到下一毫秒，系统继续产生ID
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }

        } else {
            //进入下一毫秒，从0开始
            sequence = 0;
        }
        // 这儿记录一下最近一次生成id的时间戳，单位是毫秒
        lastTimestamp = timestamp;
        // 这儿就是最核心的二进制位运算操作，生成一个64bit的id
        // 先将当前时间戳左移，放到41 bit那儿；将机房id左移放到5 bit那儿；将机器id左移放到5 bit那儿；将序号放最后12 bit
        // 最后拼接起来成一个64 bit的二进制数字，转换成10进制就是个long型
        return ((timestamp - BASE_TIMESTAMP) << TIMESTAMP_LEFT_SHIFT) |
                (datacenterId << DATACENTER_ID_SHIFT) |
                (workerId << WORKER_ID_SHIFT) | sequence;
    }

    /**
     * 当某一毫秒的时间，产生的id数 超过4095，系统会进入等待，直到下一毫秒，系统继续产生ID
     *
     * @param lastTimestamp 上一次生成id的时间
     * @return 时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 休眠微秒
     *
     * @param mis 微秒数
     */
    private static void sleepSafeMis(long mis) {
        try {
            TimeUnit.MICROSECONDS.sleep(mis);
        } catch (InterruptedException e) {
            LOGGER.error("sleep error ", e);
        }
    }

    //获取当前时间戳
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前毫秒内最大值
     *
     * @return ID
     */
    public long maxValue() {
        long timestamp = timeGen();
        return ((timestamp - BASE_TIMESTAMP << TIMESTAMP_LEFT_SHIFT))
                | (MAX_DATACENTER_ID << DATACENTER_ID_SHIFT) | (MAX_WORKER_ID << WORKER_ID_SHIFT) | (SEQUENCE_MASK);
    }

    /**
     * 获取当前毫秒内最小值
     *
     * @return ID
     */
    public long minValue() {
        long timestamp = timeGen();
        return ((timestamp - BASE_TIMESTAMP << TIMESTAMP_LEFT_SHIFT))
                | (1 << SEQUENCE_BITS);
    }

    /**
     * 测试10毫秒能生成多少个id,取平均值算出1毫秒可以生成4096个id
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SnowflakeSequenceGen snowflakeSequenceGen = new SnowflakeSequenceGen(1, 1);
        for (int i = 0; i < 10; i++) {
            int count = 0;
            long curTime = snowflakeSequenceGen.timeGen();
            while (snowflakeSequenceGen.timeGen() - curTime < 10) {
                snowflakeSequenceGen.gen();
                count++;
            }
            System.out.println(count);
        }
        //生成的id示例
        System.out.println(snowflakeSequenceGen.gen());
    }
}
