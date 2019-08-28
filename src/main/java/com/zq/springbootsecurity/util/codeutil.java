package com.zq.springbootsecurity.util;

import java.util.Random;

public class codeutil {
    Random ne=new Random();//实例化一个random的对象ne
    int x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
    public int getCode()
    {
        return x;
    }
}
