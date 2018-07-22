package com.leetcode;

/**
 * 第6题：Z字形变换
 * 思路：观察字母排序可知，行数即为字符串个数，最后按顺序再拼接一起。首先创建有序的字符串数组，
 * 根据原字符串的顺序可知，小于行数的则正向赋值，到最后一个字符串数组后就逆向赋值，到第一个字
 * 符串数组后又开始正向赋值，以此类推。
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }

    public static String convert(String s, int numRows) {
        //创建新字符串数组，由行数决定
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i=0; i<sb.length; i++){
            sb[i] = new StringBuilder();
        }
        //是否正向拼接的标志位
        int incr = 1;
        //新字符串数组的下标
        int index = 0;
        for (int i=0; i<s.length(); i++){
            sb[index].append(s.charAt(i));
            if(index == 0){
                incr = 1;
            }
            if (index == numRows-1){
                incr = -1;
            }
            index+=incr;
        }
        //最后将字符串数组按顺序拼接起来得到最终结果
        String re = "";
        for (int i=0; i<sb.length; i++){
            re += sb[i];
        }
        return re;
    }
}
