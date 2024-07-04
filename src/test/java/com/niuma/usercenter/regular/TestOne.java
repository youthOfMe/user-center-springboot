package com.niuma.usercenter.regular;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestOne {

    @Test
    void testPhone() {
        // 随意选择一个电话号
        String tel = "19988998801";
        int len = tel.length();
        if (len != 11) System.out.println("长度不对劲");
        for (int i = 0; i < len; i++) {
            // 获取每个电话号数字
            char cur = tel.charAt(i);
            if (cur <= '0' || cur >= '9') {
                System.out.println("输入错误");
                break;
            }
        }
    }

    @Test
    void testRegular() {
        // 使用正则表达式判断字符串是否符合规则
        String tel = "19988998801";
        System.out.println(tel.matches("\\d{11}"));
    }

    @Test
    void testRegualr1() {
        // 模糊匹配查询
        System.out.println("123".matches("\\d\\d\\d"));
        System.out.println("a_bc".matches("\\w\\w\\w\\w"));
        System.out.println("a_b$".matches("\\w\\w\\w\\w"));
    }

    @Test
    void testRegular2() {
        // 匹配符
        System.out.println("12".matches("\\d{2}"));
        System.out.println("12".matches("\\d{3}"));
        System.out.println("a12".matches("\\w{1,3}"));
        System.out.println("a123".matches("\\w{1,3}"));
    }

    @Test
    void testRegular3() {
        // 限定范围匹配
        // 直接将匹配向写在中括号中
        System.out.println("a34".matches("[abc][345][345]"));
        // 使用-表示 多少到多少
        System.out.println("a34".matches("[a-c][3-5][3-5]"));
        // 可以与重复匹配字符搭配使用
        System.out.println("a34".matches("[a-c][3-5]+"));
    }

    @Test
    void testRegular4() {
        // 规则匹配
        System.out.println("I love you".matches("I love (you|dog)"));
        System.out.println("I love dog".matches("I love (you|dog)"));
        // 不能大写
        System.out.println("I love dog".matches("I love (you|Dog)"));
        // 必须进行加括号, 不然就是you和dog二选一
        System.out.println("dog".matches("I love you|dog"));
    }

    @Test
    void testRegular5() {
        Pattern pattern = Pattern.compile("(\\d{3})-(\\d{4})-(\\d{3})");
        Matcher matcher = pattern.matcher("110-1340-500");
        if (matcher.matches()) {
            // 获取第一个匹配组
            String g1 = matcher.group(1);
            // 获取第二个匹配组
            String g2 = matcher.group(2);
            // 获取第三个匹配组
            String g3 = matcher.group(3);
            System.out.println(g1);
            System.out.println(g2);
            System.out.println(g3);
        } else {
            System.out.println("匹配失败");
        }
    }

    // 贪恋匹配
    @Test
    void testRegular6() {
        Pattern pattern = Pattern.compile("(\\d+)(0*)");
        Matcher matcher = pattern.matcher("123000");
        if (matcher.matches()) {
            System.out.println("group1 => " + matcher.group(1));
            System.out.println("group2 => " + matcher.group(2));
        }
    }

    // 非贪婪匹配
    @Test
    void testRegular7() {
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("123000");
        if (matcher.matches()) {
            System.out.println("group1 => " + matcher.group(1));
            System.out.println("group2 => " + matcher.group(2));
        }
    }

    // 搜索和替换
    @Test
    void testRegular8() {
        String[] stringOnes = "a b c".split("\\s");
        for (int i = 0; i < stringOnes.length; i++) {
            System.out.println(stringOnes[i] + " 123");
        }
        System.out.println("----------------------------------");
        for (String s : "a b  c".split("[\\s]+")) {
            System.out.println(s + " 666");
        }
        System.out.println("----------------------------------");
        for (String s : "a b :: c".split("[\\,\\:\\s]+")) {
            System.out.println(s + " 666");
        }
    }

    @Test
    void testRegular9() {
        Pattern pattern = Pattern.compile("\\wo\\w");
        Matcher matcher = pattern.matcher("i dog fox wo od hhh opp ppo and");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 字符串正则替换
    @Test
    void testRegular10() {
        String s = "the quick brown fox jumps over the lazy dog";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }

    // 命名组捕获
    @Test
    void testRegular11() {
        String s = "the quick brown fox jumps over the lazy dog";
        String r = s.replaceAll("\\s(?<four>[a-z]{4})\\s", " <b>${four}</b> ");
        System.out.println(r);
    }

    // 数字捕获组1
    @Test
    void testRegular12() {
        String input = "Hello, world! How, are you?";
        Pattern pattern = Pattern.compile("(\\w+),\\s+(\\w+)!");
        Matcher matcher = pattern.matcher(input);
        String output = matcher.replaceAll("$2, $1");
        System.out.println(output);
    }
}
