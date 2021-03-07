package com.restful.api.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class URL {

    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultDate){
        try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(textDate, df);
        }catch (Exception e){
            return defaultDate;
        }
    }
}
