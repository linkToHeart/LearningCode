package com.leetcode;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 * 思路：
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<Character>();
        int i = 0, j = 0, result = 0, len = s.length();
        while(i<len && j<len){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                result = Math.max(result, j-i);
            }else{
                set.remove(s.charAt(i++));
            }

        }
        return result;
    }

    public static Integer zhangdesao(String s){
        List<String> list = new LinkedList<String>();
        Integer temp=0;
        Integer j=0;
        if (s.length() == 1) {
            return 1;
        }

        for (int i=1;i<s.length();i++) {

            String substring = s.substring(temp,i);
            char c = s.charAt(i);
            if (substring.contains(c + "")) {
                if (substring.length() > j) {
                    j=substring.length();
                }
//                list.add(substring);
                int i1 = substring.indexOf(c + "");
                temp += i1+1;
            } else {
                if (substring.length() > j) {
                    j=substring.length();
                }
//                list.add(substring);
            }
        }
        if (temp < s.length()) {

            String substring = s.substring(temp,s.length());
            if (substring.length() > j) {
                j=substring.length();
            }
//            list.add(substring);
        }

        /*String str="";
        for (String entry : list) {
            Integer value = entry.length();
            if (value > j) {
                j=value;
                str=entry;
            }
        }*/
        return j;
    }

    public static void main(String[] args) {
        System.out.println(zhangdesao("a"));
    }
}
