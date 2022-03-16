package com.atguigu.test.HutoolTest;

import org.junit.Test;

import cn.hutool.system.JavaRuntimeInfo;

/**
 * @author hezongkui <hezongkui@kuaishou.com>
 * Created on 2022-03-16
 */
public class HutoolTest {

    @Test
    public void testTool() {
        System.out.println(new JavaRuntimeInfo());
    }
}
