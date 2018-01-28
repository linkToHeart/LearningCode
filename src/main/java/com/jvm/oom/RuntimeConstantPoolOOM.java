package com.jvm.oom;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
        String str1 = new StringBuffer("abc").append("123").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("qwe").append("789").toString();
        System.out.println(str2.intern() == str2);
    }
}
