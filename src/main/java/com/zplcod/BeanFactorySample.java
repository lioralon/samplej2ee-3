package com.zplcod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactorySample {

	public static final void call() throws Exception, ClassNotFoundException {

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("classpath:config/bean.xml");
		System.out.println(res.getFile().getPath());
		BeanFactory bf = new XmlBeanFactory(res);
		System.out.println("init beanfactory");

		Car car = bf.getBean("car", Car.class);
		System.out.println(car.getSpeed());
		System.out.println("car bean is ready to use");
	}

}
