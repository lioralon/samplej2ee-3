package com.zplcod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	@Bean(name = "car")
	public Car buildCar() {
		Car car = new Car();
		car.setColor("blank");
		car.setSpeed("120");
		return car;
	}

}
