package com.leetcode;

/**
 * 第9题：回文数
 * 思路：可以把数字的后一半翻转过来，对比前半部分和后半部分是否相等。
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        /**小于0的数都不满足条件，末尾为0的数除了0以为都不能满足条件*/
        if(x < 0 || (0 == x%10 && 0 !=x )) {
            return false;
        }
        int i = x;
        int reverNum = 0;
        /**因为每次都是原数除以10，翻转数乘以10，当原数小于翻转数即翻转已经到一半了，结束翻转*/
        while(i > reverNum){
            reverNum = reverNum*10 + i%10;
            i = i/10;
        }
        /**最后判断翻转过后的数字是否与前半部分相等，由于存在整数为基数个数字的情况，
         * 比如121，最后reverNum=12的时候，2是要去掉再与前半部分作判断的*/
        return i == reverNum || i == reverNum / 10;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
