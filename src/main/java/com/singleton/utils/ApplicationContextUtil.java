package com.singleton.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/17.
 */
final public class ApplicationContextUtil {
    private static ApplicationContext ourInstance = null;

    public static ApplicationContext getInstance() {
        return ourInstance;
    }

    private ApplicationContextUtil() {
    }

    static {
        ourInstance = new ClassPathXmlApplicationContext("soundsystem/applicationContext.xml");
    }
}
