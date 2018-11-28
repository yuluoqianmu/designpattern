package com.buka.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPConvert {

    /**
     * 判断是否为ipv4地址
     *
     */
    private static boolean isIPv4Address(String ipv4Addr) {
        String lower = "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])"; // 0-255的数字
        String regex = lower + "(\\." + lower + "){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipv4Addr);
        return matcher.matches();
    }

    public static int ipToInt(String ip) {

        if (!isIPv4Address(ip))
            throw new RuntimeException("ip地址错误！");

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(ip);

        int result = 0;
        int counter = 0;
        while(matcher.find()) {
            int value = Integer.parseInt(matcher.group());
            result = (value << 8 * (3 - counter++)) | result;
        }


        return result;
    }


    public static String intToIP(int ipNum) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        boolean needPoint = false;

        for (int i=0; i<4; i++) {
            if (needPoint)
                sb.append(".");
            needPoint = true;
            int offset = 8 * (3 - i);

            num = (ipNum >> offset) & 0xff;
            sb.append(num);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(intToIP(-1062690937));
    }

}
