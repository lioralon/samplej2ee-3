package com.zplcod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {

	public final static void callLifeCycleInBeanFactory() {
		// @1 load configuration file and start container;
		Resource res = new ClassPathResource("config/bean.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		// @2 register myBeanPostProcessor;
		ConfigurableBeanFactory configBf = (ConfigurableBeanFactory) bf;
 
		configBf.addBeanPostProcessor(new MyBeanPostProcessor());
		// @3 register myInstantationAwareBeanPostProcessor
		configBf.addBeanPostProcessor(new MyInstantationAwareBeanPostProcessor());

		// @4 first time to get bean will trigger life cycle manangement;
		Car car1 = (Car) bf.getBean("car");
		car1.introduce();
		car1.setColor("red");

		// @5 check whether same instance;
		Car car2 = (Car) bf.getBean("car");
		System.out.println("car1==car2:" + (car1 == car2));

		// @6 shutdown container
		((XmlBeanFactory) bf).destroySingletons();

	}
}
