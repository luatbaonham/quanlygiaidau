package com.example.fe_quanlygiaidau.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class datetimehelper {
    // Format ngày: yyyy-MM-dd
    public static Date parseDate(String dateStr) throws java.text.ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateStr);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    // Format giờ: HH:mm:ss
    public static Date parseTime(String timeStr) throws java.text.ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.parse(timeStr);
    }

    public static String formatTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(time);
    }
}
