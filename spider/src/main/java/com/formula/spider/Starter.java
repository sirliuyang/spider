/**
 * @author Leon(Liu Yang)
 * Ideas from Formula Innovation
 */

package com.formula.spider;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formula.spider.dao.RestaurantRepository;
import com.formula.spider.processor.SmzdmPageProcessor;
import com.formula.spider.util.TraverseAllCityForDianping;

import us.codecraft.webmagic.Spider;

public class Starter {
	private static String dianping = "http://www.dianping.com/citylist/";
	public static void main(String[] args){
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		RestaurantRepository restaurantRepository = context.getBean(RestaurantRepository.class);
		TraverseAllCityForDianping getter = new TraverseAllCityForDianping();
		Spider test = new Spider(getter);
		test.test(dianping);
		System.out.println(getter.getCities());
	}
}
