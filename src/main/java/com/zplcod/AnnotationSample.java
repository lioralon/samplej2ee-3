package com.zplcod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationSample {

	public static final void getCar() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				Beans.class);
		Car car = ctx.getBean("car", Car.class);

		System.out.println("color is :" + car.getColor() + "; speed is "
				+ car.getSpeed());

	}
}
