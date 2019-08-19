package com.sgroup.socialapp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

    public static List<String> findEmail(String text) {

        List<String> emailList= new ArrayList<>();
        Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(text);

        while (m.find()) {
            emailList.add(m.group());
        }

        return emailList;

    }

}
