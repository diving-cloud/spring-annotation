package com.atguigu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author hezongkui <hezongkui@kuaishou.com>
 * Created on 2022-03-14
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        User user1 = new User();
        user1.setName("李四");
        User user2 = (User) BeanUtils.cloneBean(user1);
        System.out.println(user2.getName());

        //User 转 map
        Map<String, String> describe = BeanUtils.describe(user1);
        System.out.println(describe);

        //Map 转 User
        Map<String, String> beanMap = new HashMap();
        beanMap.put("name", "张三");
        User user3 = new User();
        BeanUtils.populate(user3, beanMap);
        System.out.println(user3.getName());
    }

}