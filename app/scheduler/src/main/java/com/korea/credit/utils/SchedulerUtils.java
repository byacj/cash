package com.korea.credit.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sungjun
 * @since 9/9/24
 */
public class SchedulerUtils {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static String localDateTimeToStr(LocalDateTime localDateTime) {
        return localDateTime.format(formatter);
    }
}
