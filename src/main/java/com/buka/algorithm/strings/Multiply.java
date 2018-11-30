package com.buka.algorithm.strings;

/**
 * 字符串相乘
 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

 示例 1:

 输入: num1 = "2", num2 = "3"
 输出: "6"
 示例 2:

 输入: num1 = "123", num2 = "456"
 输出: "56088"
 说明：

 num1 和 num2 的长度小于110。
 num1 和 num2 只包含数字 0-9。
 num1 和 num2 均不以零开头，除非是数字 0 本身。
 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] res = new int[len1 + len2];
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();

        for (int i=0; i<char1.length; i++)
            char1[i] -= '0';

        for (int i=0; i<char2.length; i++)
            char2[i] -= '0';

        for (int i=0; i<len2; i++) {
            int carry = 0;
            for (int j=0; j<len1; j++) {
                res[i+j] = res[i+j] + char2[len2-1-i] * char1[len1 -1 -j] + carry;
                carry = res[i+j] / 10;
                res[i+j] %= 10;
            }
            //处理进位
            int k = i + len1;
            while (carry > 0) {
                res[k] += carry;
                carry = res[k] / 10;
                res[k] %= 10;
                k++;
            }
        }

        StringBuffer sb = new StringBuffer();
        int i = len1 + len2 - 1;
        while(i>=0 && res[i]==0)
            i--;
        while(i>=0){
            sb.append(res[i]);
            i--;
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }


}
