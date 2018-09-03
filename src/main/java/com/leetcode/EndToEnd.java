package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给一串字符串duck klo asd opkl，判断这串字符串经过排序后是否能首尾相接，
 * 例如经过排序后asd duck klo opkl，返回true。若只有一个字符串则返回true
 */
public class EndToEnd {

    public static void main(String[] args) {
        ArrayList<String> newList = new ArrayList<String>();
        newList.add("duck");
        newList.add("klo");
        newList.add("asd");
        newList.add("opkl");
        System.out.println(check(newList));
    }

    private static boolean check(ArrayList<String> words) {
        if (words.size() == 1) {
            return true;
        }
        Map<String, String> strMap = new HashMap<String, String>();
        /**i是用来计算重复的字符串字数*/
        int i = 0;
        for (String str : words) {
            String firStr = str.substring(0,1);
            String lastStr = str.substring(str.length()-1, str.length());
            if (!strMap.containsKey(firStr)) {
                strMap.put(firStr,firStr);
            }else {
                i++;
            }
            if(!strMap.containsKey(lastStr)) {
                strMap.put(lastStr,lastStr);
            }else {
                i++;
            }

        }
        if (words.size() - 1 == i){
            return true;
        }
        return false;
    }
}
