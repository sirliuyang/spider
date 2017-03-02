/**
 * @author Leon(Liu Yang)
 * Ideas from Formula Innovation
 */

package com.formula.spider;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formula.spider.dao.DianpingRepository;
import com.formula.spider.processor.TraverseAllCityForDianping;

import us.codecraft.webmagic.Spider;

public class Starter {
	private static String dianping = "http://www.dianping.com/citylist/";

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		//Insert the db
		/*TraverseAllCityForDianping dataGather = context.getBean(TraverseAllCityForDianping.class);
		Spider.create(dataGather).addUrl(dianping).thread(5).run();*/
		//Query the db
		DianpingRepository repository = context.getBean(DianpingRepository.class);
		repository.getCity();
	}
}
