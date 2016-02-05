package com.zplcod;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantationAwareBeanPostProcessor extends
		InstantiationAwareBeanPostProcessorAdapter {

	// @1 before new instance call;
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass,
			String beanName) throws BeansException {
		if ("car".equals(beanName)) {
			System.out
					.println("InstantationAware BeanPostProcessor.postProcessBeforeInstantiation");

		}
		return null;
	}

	// @2 after new instance call
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName)
			throws BeansException {
		if ("car".equals(beanName)) {
			System.out
					.println("Instantation AwareBeanPostProcessor.postProcessAfterInstantiation");

		}
		return true;
	}

	// @3 set some properties call
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs,
			PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		if ("car".equals(beanName)) {
			System.out
					.println("Instantation  AwareBeanPostProcessor.postProcessPropertyValues");

		}
		return pvs;
	}



}
