package com.tunyl.demo;

import java.text.DateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        System.out.println(zone.getRules());

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());


        Instant instant = clock.instant();
        System.out.println(instant);

        LocalTime of = LocalTime.of(23, 59, 59);
        System.out.println(of);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

        LocalTime localTime = LocalTime.parse("13:37",dateTimeFormatter);
        System.out.println(localTime);
    }
}
