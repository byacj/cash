package com.korea.credit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sungjun
 * @since 9/9/24
 */
public class FriendsUtils {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static LocalDateTime stringToLocalDateTime(String str) {
        return LocalDateTime.parse(str, formatter);
    }
}
