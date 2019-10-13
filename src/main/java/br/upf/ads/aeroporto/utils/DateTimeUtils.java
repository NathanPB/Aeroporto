package br.upf.ads.aeroporto.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("d/M/Y - K:m");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d/M/Y");

    public static String formatCurrentDateTime() {
        return formatDateTime(new Date());
    }

    public static String formatDateTime(Date date) {
        return DATETIME_FORMAT.format(date);
    }

    public static String formatCurrentDate() {
        return formatDate(new Date());
    }

    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}
