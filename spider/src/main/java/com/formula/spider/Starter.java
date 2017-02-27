/**
 * @author Leon(Liu Yang)
 * Ideas from Formula Innovation
 */

package com.formula.spider;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formula.spider.dao.RestaurantRepository;

public class Starter {
	public static void main(){
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		RestaurantRepository restaurantRepository = context.getBean(RestaurantRepository.class);
		
	}
}
