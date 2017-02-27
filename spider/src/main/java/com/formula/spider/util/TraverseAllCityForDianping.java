/**
 * 
 */
package com.formula.spider.util;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class TraverseAllCityForDianping implements PageProcessor {
	private static List<String> cities;
	private static String url = "http://www.dianping.com/citylist/";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).addHeader("Accept", "application/json, text/javascript");

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.
	 * webmagic.Page)
	 */
	@Override
	public void process(Page page) {
		//If try to get data directly, it will return 403
		page.addTargetRequests(page.getHtml().links().regex("(http://www.dianping.com/citylist/)").all());
		List<String> items = page.getHtml().xpath("//div[@class='main page-cityList']").links().all();
		for (String item : items) {
			System.out.println(item);
		}
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
	
	public static void main(String[] args){
		Spider.create(new TraverseAllCityForDianping()).addUrl(url).thread(5).run();
	}
}
