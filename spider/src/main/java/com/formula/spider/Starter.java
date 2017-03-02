/**
 * @author Leon(Liu Yang)
 * Ideas from Formula Innovation
 */

package com.formula.spider;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formula.spider.processor.TraverseAllCityForDianping;

import us.codecraft.webmagic.Spider;

public class Starter {
	private static String dianping = "http://www.dianping.com/citylist/";

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		TraverseAllCityForDianping test = context.getBean(TraverseAllCityForDianping.class);
		Spider.create(test).addUrl(dianping).thread(5).run();
	}
}
