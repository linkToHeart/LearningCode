package com.leetcode;

/**
 * 第8题：字符串转整数
 * 思路：把字符串中每个字符取出来判断即可，注意数字范围可以取Integer.MIN_VALUE和Integer.MAX_VALUE来判断。
 */
public class MyAtoi {

    public int myAtoi(String str) {
        String temp = str.trim();
        if(temp == null || temp.length() < 1) {
            return 0;
        }
        /**正负标志位*/
        int isPosi = 1;
        int i = 0;
        if(temp.charAt(0) == '-') {
            isPosi = -1;
            i++;
        }
        if(temp.charAt(0) == '+') {
            i++;
        }
        /**用double而不是int来计算，因为double取值范围比int大，直接用int可能会溢出*/
        double result = 0;
        /**当遍历到不是数字的字符则退出循环*/
        while(i<temp.length() && temp.charAt(i)>='0' && temp.charAt(i)<='9') {
            result = result*10 + temp.charAt(i) - '0';
            i++;
        }
        result = result*isPosi;
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
