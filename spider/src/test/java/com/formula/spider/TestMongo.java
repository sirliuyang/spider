package com.formula.spider;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formula.spider.dao.RestaurantRepository;

public class TestMongo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		RestaurantRepository restaurantRepository = context.getBean(RestaurantRepository.class);
		restaurantRepository.test();
	}
}
