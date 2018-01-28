package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  5. Longest Palindromic Substring
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abc"));
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
                if (chaList.get(0) == s.charAt(i)){
                    chaList.add(s.charAt(i));
                    findEqual = true;
                    length = chaList.size();
                }else {
                    chaList.add(s.charAt(i));
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
