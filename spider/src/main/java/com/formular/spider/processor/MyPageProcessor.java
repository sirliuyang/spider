package com.formular.spider.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyPageProcessor implements PageProcessor {
	
	private static String url = "https://en.wikipedia.org/wiki/Portal:Contents/Overviews";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        //page.addTargetRequests(page.getHtml().links().regex("(https://en\\.wikipedia\\.org/\\w+/\\w+)").all());
        /*
        page.putField("author", page.getUrl().regex("https://en\\.wikipedia\\.org/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
        */
        
        //page.putField("", field);
    	System.out.println(page.getHtml().xpath("body").xpath("div").xpath("a").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //Spider.create(new GithubRepoPageProcessor()).addUrl("https://en.wikipedia.org/wiki/Main_Page").thread(5).run();
    	System.setProperty("javax.net.ssl.trustStore","C:\\eclipse32\\workspace\\ordinary\\jssecacerts");
    	
    	Spider test = new Spider(new MyPageProcessor());
    	test.test(url);
    }
}
