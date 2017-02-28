/**
 * 
 */
package com.formula.spider.util;

import java.util.ArrayList;
import java.util.List;

import com.formula.spider.bean.City;
import com.formula.spider.parser.DianpingParser;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class TraverseAllCityForDianping implements PageProcessor {
	private static List<City> cities = new ArrayList<City>();
	private static String url = "http://www.dianping.com/citylist/";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
			.setUserAgent(
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2723.3 Safari/537.36")
			.addCookie("User", "PC-Lily").addHeader("Accept", "application/json, text/javascript");

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.
	 * webmagic.Page)
	 */
	@Override
	public void process(Page page) {
		// If try to get data directly, it will return 403
		// page.addTargetRequests(page.getHtml().links().regex("(http://www.dianping.com/citylist/)").all());
		List<String> items = page.getHtml().xpath("//div[@class='main page-cityList']").xpath("//div[@class='section']")
				.xpath("//ul").xpath("//div[@class='terms']").xpath("//a").all();
		// page.getHtml().xpath("//div[@class='main page-cityList']").xpath("")
		for (String item : items) {
			cities.add(DianpingParser.parseCities(item));
		}
	}

	public List<City> getCities() {
		return cities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#getSite()
	 */
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new TraverseAllCityForDianping()).addUrl(url).thread(5).run();
	}
}
