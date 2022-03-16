package com.atguigu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;

import cn.hutool.http.HtmlUtil;

/**
 * @author hezongkui <hezongkui@kuaishou.com>
 * Created on 2022-03-14
 */
public class ArrayTest {
    @Test
    public void testArrays() {
        //合并数组
        String[] array1 = new String[] {"value1", "value2"};
        String[] array2 = new String[] {"value3", "value4"};
        String[] array3 = ArrayUtils.addAll(array1, array2);
        System.out.println("array3:" + ArrayUtils.toString(array3));

        //clone 数组
        String[] array4 = ArrayUtils.clone(array3);
        System.out.println("array4:" + ArrayUtils.toString(array4));

        //数组是否相同
        boolean b = EqualsBuilder.reflectionEquals(array3, array4);
        System.out.println(b);

        //反转数组
        ArrayUtils.reverse(array4);
        System.out.println("array4反转后：" + ArrayUtils.toString(array4));

        //二维数组转 map
        Map<String, String> arrayMap = (HashMap) ArrayUtils.toMap(new String[][] {
                {"key1", "value1"}, {"key2", "value2"}
        });
        for (String s : arrayMap.keySet()) {
            System.out.println(arrayMap.get(s));
        }


    }



}
