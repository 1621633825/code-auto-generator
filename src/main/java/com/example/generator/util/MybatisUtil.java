package com.example.generator.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MybatisUtil {
    // 获取bean的属性 根据属性拼接 resultMap
    // 并将驼峰修改为'_'
    public static String getResultMap(Class<?> cls) {
        StringBuilder str = new StringBuilder();
        str = new StringBuilder("<resultMap id=\"" + cls.getSimpleName().substring(0, 1).toLowerCase() + cls.getSimpleName().substring(1) + "ResultMap\" type=\"" + cls.getName() + "\"> \r\n");
        // 每一行字符串
        String linestr = "";
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if(!"serialVersionUID".equals(field.getName())) {
                linestr = "  <result column=\"" + getUpCaseReplace(field.getName()) + "\" property=\"" + field.getName() + "\" />";
                linestr += "\r\n";
                str.append(linestr);
            }
        }
        str.append("</resultMap>");
        return str.toString();
    }

    public static String getAllField(Class<?> cls) {
        StringBuilder str = new StringBuilder();
        // 每一行字符串
        String linestr = "";
        Field[] declaredFields = cls.getDeclaredFields();
        int i = 0;
        for (Field field : declaredFields) {
            if(!"serialVersionUID".equals(field.getName())) {
                linestr = getUpCaseReplace(field.getName()) + ", ";
                if (i % 4 == 0 && i != 0){
                    linestr += "\r\n";
                }
                str.append(linestr);
                i++;
            }
        }
        return str.substring(0,str.length()-2);
    }

    /**
     * 将字符串中的驼峰写法替换成'_'
     *
     * @param str str
     * @return string
     */
    private static String getUpCaseReplace(String str) {
        List<String> listChar = getUpCaseList(str);
        //先将字原属性加上"_"和原属性的首字母大写
        for (String s : listChar) {
            str = str.replace(s, "_" + s.toUpperCase());
        }
        //将字段全部装换为大写
        return str.toUpperCase();
    }

    /**
     * @Description: 输出字符串中的大写字母
     * @param str str
     */
    private static List<String> getUpCaseList(String str) {
        List<String> listChar = new ArrayList<>();
        // 转为char数组
        char[] ch = str.toCharArray();
        // 得到大写字母
        for (char c : ch) {
            if (c >= 'A' && c <= 'Z') {
                listChar.add(String.valueOf(c));
            }
        }
        return listChar;
    }

    public static void main(String[] args) {
        // 需要生成resultMap的实体类
//        System.err.println(getResultMap(Newtable.class));
        //所有属性
        System.out.println("------------------------------------------------------------------------");
//        System.out.println(getAllField(Newtable.class));
        System.out.println("------------------------------------------------------------------------");
    }
}
