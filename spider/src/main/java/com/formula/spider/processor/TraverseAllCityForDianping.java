/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */

package com.formula.spider.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.formula.spider.bean.City;
import com.formula.spider.parser.DianpingParser;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

@Repository
public class TraverseAllCityForDianping implements PageProcessor {
	@Autowired
	private MongoTemplate mongoTemplate;

	private static List<City> cities = new ArrayList<City>();
	private static String url = "http://www.dianping.com/citylist/";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
			.setUserAgent(
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2723.3 Safari/537.36")
			.addCookie("User", "PC-Lily").addHeader("Accept", "application/json, text/javascript");

	@Override
	public void process(Page page) {
		// If try to get data directly, it will return 403
		// page.addTargetRequests(page.getHtml().links().regex("(http://www.dianping.com/citylist/)").all());
		List<String> items = page.getHtml().xpath("//div[@class='main page-cityList']").xpath("//div[@class='section']")
				.xpath("//ul").xpath("//div[@class='terms']").xpath("//a").all();
		// page.getHtml().xpath("//div[@class='main page-cityList']").xpath("")
		cities = DianpingParser.parseCities(items);
		if (mongoTemplate != null) {
			for (City city : cities) {
				mongoTemplate.save(city);
			}
		}
	}

	public List<City> getCities() {
		return cities;
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new TraverseAllCityForDianping()).addUrl(url).thread(5).run();
	}
}
