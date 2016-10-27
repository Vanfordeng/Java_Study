package com.study_java8;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Doctor on 2016/10/27.
 * junit是一个测试工具。对于软件测试而言分为两种测试
 * 1.黑盒
 * 2.白盒
 * 用例测试工程师（use case）
 * junit就是一个use case测试工具，但是junit本身使用并不麻烦。
 */
public class Java_Basic_Junit {
    public static void main(String[] args) {
        Assert.assertFalse(false);
    }

    @Test
    public void Test(){
        Assert.assertTrue(false);
    }
}
