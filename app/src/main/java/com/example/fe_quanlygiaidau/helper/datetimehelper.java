package com.example.fe_quanlygiaidau.helper;

import androidx.core.net.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;


public class datetimehelper {
    private static String Pattern = "dd/MM/yyyy";
    public static Date toDate(String st) throws ParseException, java.text.ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(st);
    }

    public static String toString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(date);
    }
}
