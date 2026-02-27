package pers.boyuan.common.util;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 时间工具类
 *
 * @author ZhangBoyuan
 * @date 2023-03-01
 */
public class DateUtil {

    /**
     * 根据时间范围构造时间分片，不足一月天数按一月天数范围
     *
     * @param beginTime 时间范围-起始
     * @param endTime   时间范围-终止
     * @return key-每月一日00:00:00 -> value-每月最后一日23:59:59
     */
    public static Map<LocalDateTime, LocalDateTime> buildTimeSlicing(LocalDateTime beginTime, LocalDateTime endTime) {
        Map<LocalDateTime, LocalDateTime> result = new LinkedHashMap<>();
        if (beginTime.isAfter(endTime)) {
            return Collections.emptyMap();
        }

        while (true) {
            result.put(getFirstDayOfMonth(beginTime), getLastDayOfMonth(beginTime));

            if (beginTime.getYear() == endTime.getYear() && beginTime.getMonth().getValue() == endTime.getMonth().getValue()) {
                return result;
            }

            beginTime = beginTime.plusMonths(1);
        }
    }

    /**
     * 获取参数所在月份第一日00:00:00
     *
     * @param param 参数
     */
    public static LocalDateTime getFirstDayOfMonth(LocalDateTime param) {
        return param.with(TemporalAdjusters.firstDayOfMonth()).toLocalDate().atStartOfDay();
    }

    /**
     * 获取参数所在月份最后一日23:59:59
     *
     * @param param 基础参数
     */
    public static LocalDateTime getLastDayOfMonth(LocalDateTime param) {
        return param.with(TemporalAdjusters.firstDayOfNextMonth()).toLocalDate().atStartOfDay().minusSeconds(1);
    }

}
