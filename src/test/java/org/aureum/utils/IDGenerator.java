package org.aureum.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IDGenerator {
    public static String convertDateTimeToStringID() {
        LocalDateTime now = LocalDateTime.now();

//        Format the date and time as a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return now.format(formatter);
    }
}
