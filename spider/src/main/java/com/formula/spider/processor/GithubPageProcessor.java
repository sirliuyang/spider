/**
 * @author Leon(Liu Yang)
 * Ideas from Formula Innovation
 */

package com.formula.spider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class GithubPageProcessor implements PageProcessor {

	/*
	 * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等 第一部分关于爬虫的配置，包括编码、抓取间隔、超时时间、重试次数等，也包括一些模拟的参数
	 * 例如User Agent、cookie，以及代理的设置
	 * 我们会在第5章-“爬虫的配置”里进行介绍。在这里我们先简单设置一下：重试次数为3次，抓取间隔为一秒
	 */
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.
	 * webmagic.Page)
	 */
	@Override
	public void process(Page page) {
		/*
		 * 部分二：定义如何抽取页面信息，并保存下来
		 * 第二部分是爬虫的核心部分：对于下载到的Html页面，你如何从中抽取到你想要的信息？
		 * WebMagic里主要使用了三种抽取技术：XPath、正则表达式和CSS选择器。
		 * 另外，对于JSON格式的内容，可使用JsonPath进行解析
		 */
		page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
		page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
		if (page.getResultItems().get("name") == null) {
			// skip this page
			page.setSkip(true);
		}
		page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

		// 部分三：从页面发现后续的url地址来抓取
		page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.codecraft.webmagic.processor.PageProcessor#getSite()
	 */
	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {

		Spider.create(new GithubRepoPageProcessor())
				// 从"https://github.com/code4craft"开始抓
				.addUrl("https://github.com/code4craft")
				// 开启5个线程抓取
				.thread(5)
				// 启动爬虫
				.run();
	}
}
