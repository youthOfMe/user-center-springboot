package com.niuma.usercenter;


import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class TestDigestUtils {

    @Test
    void testMD5() {
        String encodekey = DigestUtils.md5DigestAsHex("456".getBytes());
        System.out.println(encodekey);
    }
}
