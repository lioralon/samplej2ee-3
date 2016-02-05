package com.zplcod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean,
		DisposableBean {

	private String beanName;
	private BeanFactory beanFactory;
	private String brand;
	private String color;

	protected void driver() {
		System.out.println(String.format("private field:%s%n", color));
	}

	private String speed;

	public String getColor() {
		return color;
	}

	public void setColor(String colorString) {
		this.color = colorString;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String maxSpeed) {
		this.speed = maxSpeed;
	}

	// <Bean> xml's initialization-method
	public void init() {
		System.out.println("speed set to 120km");
		this.speed = "120";
	}

	// <Bean> xml's destroy-method
	public void myDestory() {
		System.out.println("destory is called");
	}



	// DisposableBean interface
	public void destroy() throws Exception {

		System.out.println("Call DisposableBean.destory()");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	// BeanNameAware interface
	public void setBeanName(String name) {
		System.out.println("call BeanNameAware.setBeanName");
		this.beanName = name;
	}

	// BeanFactoryAware interface
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

		System.out.println("call BeanFactoryAware.setBeanFactory");
		this.beanFactory = beanFactory;

	}

	public void introduce() {
		System.out.println("brand:" + brand + ";color:" + color
				+ ";speed:" + speed);

	}

	public static final void callCar() throws Throwable {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = loader.loadClass("com.zplcod.car");
		Car car = (Car) clazz.newInstance();
		Field field = clazz.getDeclaredField("colorString");
		field.setAccessible(true);
		field.set(car, "red");

		Method method = clazz.getDeclaredMethod("driver");
		method.setAccessible(true);
		method.invoke(car, (Object[]) null);
	}

}
