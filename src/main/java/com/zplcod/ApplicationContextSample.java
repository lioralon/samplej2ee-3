package com.zplcod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Clancy on 2016/2/5.
 */
public class ApplicationContextSample {
    public static final void call() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/bean.xml");
        Car car1 = (Car) ctx.getBean("car");

    }

}
