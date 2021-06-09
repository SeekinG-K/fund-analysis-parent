package com.scale.invest.api.uitl;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private final static String bracketRegex = "\\((.*?)\\)";

    public static String getBracketInnerValue(String targetValue) {
        Pattern compile = Pattern.compile(bracketRegex);

        if (!StringUtils.isEmpty(bracketRegex)) {
            Matcher matcher = compile.matcher(targetValue);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    public static String getBracketInnerValueSplit(String targetValue) {
        return targetValue.substring(targetValue.indexOf("(")+1,targetValue.lastIndexOf(")"));
    }

}
