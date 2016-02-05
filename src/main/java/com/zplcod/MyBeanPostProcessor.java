package com.zplcod;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (beanName.equals("car")) {
			Car car = (Car) bean;
			if (car.getColor() == null
					|| car.getColor().length() <= 0) {
				System.out
						.println("call BeanPostProcessor.postProcessBeforeInitialization before initialization(),set color to default blank");
				car.setColor("blank");

			}
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (beanName.equals("car")) {
			Car car = (Car) bean;
			System.out
					.println("call BeanPostProcessor.postProcessAfterInitialization after initilization() set to default 120, exception or over 120 will set to 120");
			int speed = 0;
			try {
				speed = Integer.parseInt(car.getSpeed());
				if (speed > 120) {
					speed = 120;
				}

			} catch (NumberFormatException e) {
				speed = 120;
				e.printStackTrace();

			}
			car.setSpeed(String.valueOf(speed));
		}

		return bean;
	}

}
