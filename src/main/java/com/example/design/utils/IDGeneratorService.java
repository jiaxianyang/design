//package com.example.design.utils;
//
//import com.daling.dh.ucenter.common.utils.CommonLock;
//import com.daling.dh.ucenter.ucenterstore.service.UcenterMasterDbService;
//import com.daling.framework.metrics.utils.DMetrics;
//import com.google.common.collect.Lists;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//@Service
//public class IDGeneratorService {
//
//    private static final Integer MAX_PER_SIZE = 100000;
//    private static final String PREFIX = "dh_ucenter_id_generator_";
//    private static final String LOCK_PREFIX = "dh_ucenter_lock_id_generator_";
//    private static final String METRICS_NAME = "dh_ucenter_id_generator_uniq_key";
//
//    @Resource
//    RedisTemplate<String,String> redisTemplate;
//    @Resource
//    UcenterMasterDbService ucenterMasterDbService;
//
//
//    private static String genTableUniqKey(String uniqKey) {
//        return StringUtils.join(PREFIX, uniqKey);
//    }
//
//    private static String genLockKey(String uniqKey) {
//        return StringUtils.join(LOCK_PREFIX, uniqKey);
//    }
//
//    private Long idGenerator(String uniqKey) {
//        // 从缓存拿数
//        String tableUniqKey = genTableUniqKey(uniqKey);
//        String nextIdStr = redisTemplate.opsForList().rightPop(tableUniqKey);
//        //记录监控指标
//        DMetrics.recordRedis(nextIdStr, METRICS_NAME);
//        if (StringUtils.isNotBlank(nextIdStr)) {
//            return Long.parseLong(nextIdStr);
//        }
//        try (CommonLock lock = new CommonLock(genLockKey(uniqKey), 1, TimeUnit.SECONDS)) {
//            if (lock.tryLock(100 * 100, TimeUnit.MICROSECONDS)) {
//                nextIdStr = loadNextId(uniqKey, tableUniqKey);
//            }
//        } catch (Exception e) {
//            log.error("error", e)
//        }
//        return StringUtils.isBlank(nextIdStr) ? null : Long.parseLong(nextIdStr);
//    }
//
//    private String loadNextId(String uniqKey, String tableUniqKey) {
//        String cachNextId = redisTemplate.boundListOps(tableUniqKey).rightPop();
//        //记录监控指标
//        DMetrics.recordRedis(cachNextId, METRICS_NAME);
//        if (StringUtils.isNotBlank(cachNextId)) {
//            return cachNextId;
//        } else {
//            Long sequence = ucenterMasterDbService.genSequence(uniqKey);
//            List<String> list = Lists.newArrayList();
//            for (int index = 0; index < MAX_PER_SIZE; index++) {
//                list.add(String.valueOf(sequence * MAX_PER_SIZE + index));
//            }
//            redisTemplate.opsForList().leftPushAll(tableUniqKey, list);
//            cachNextId = redisTemplate.opsForList().rightPop(tableUniqKey);
//            //记录监控指标
//            DMetrics.recordRedis(cachNextId, METRICS_NAME);
//            return cachNextId;
//        }
//    }
//
//    public final Long generateUserId() {
//        return idGenerator("t_user");
//    }
//
//    public final Long generateShopId() {
//        return idGenerator("t_shop");
//    }
//
//}
