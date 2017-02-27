/**
 * @author Leon(Liu Yang)
 * Ideas from Formula Innovation
 */

package com.formula.spider.processor;

import java.util.List;

import com.formula.spider.dao.RestaurantRepository;
import com.formula.spider.parser.DataParser;
import com.formula.spider.parser.SmzdmParser;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class DianPingPageProcessor implements PageProcessor {
	private static String url = "http://www.smzdm.com/fenlei/danfantaoji/";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	private RestaurantRepository restaurantRepository;
	private String json;

	public DianPingPageProcessor(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public void process(Page page) {
		page.addTargetRequests(page.getHtml().links().regex("(http://www.smzdm.com/fenlei/\\w+/\\w+)").all());
		List<String> items = page.getHtml().xpath("h5").xpath("a").regex("/span>(.+?)</span>").all();
		/*
		 * for(String item : items){ System.out.println(item); }
		 */
		DataParser parser = new SmzdmParser();
		parser.parse(items);
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return null;
	}

}
