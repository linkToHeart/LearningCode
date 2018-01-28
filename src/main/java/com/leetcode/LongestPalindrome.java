package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  5. Longest Palindromic Substring
 *  思路：两个指针，第一个指针指向第j个，第二个指针指向第j+1个，判断第j+1个字符是否等于第i个字符，
 *  不管相不相等都要先存在List<Character>里面，但是如果遍历到相等的字符，则需要更新length长度和findEqual
 *  是否有【相等字符标志位】，如果检查【相等字符标志位】是true，并且长度超过之前的存的长度，则更新长度temp和字符refult
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        int temp = 0;
        String result = "";
        if(s.length() == 1){
            return s;
        }
        for (int j=0; j<len-1; j++){
            boolean findEqual = false;
            List<Character> chaList = new ArrayList<Character>();
            chaList.add(s.charAt(j));
            int length = 0;
            for(int i=j+1; i<len; i++){
                chaList.add(s.charAt(i));
                if (chaList.get(0) == s.charAt(i)){
                    findEqual = true;
                    length = chaList.size();
                }
            }
            if (findEqual && length > temp){
                temp = length;
                StringBuffer str = new StringBuffer();
                for (Character cha: chaList){
                    str.append(cha);
                }
                result = str.toString().substring(0, temp);
            }
        }
        return result;
    }
}
