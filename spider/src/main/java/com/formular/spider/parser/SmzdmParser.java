package com.formular.spider.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.formular.spider.bean.SmzdmProduct;

public class SmzdmParser implements DataParser {
	
	@Override
	public List<String> parse(List<String> items) {
		List<String> results = new ArrayList<String>();
		for (String product : items) {
			String price = "";
			Pattern pattern0 = Pattern.compile("(.*)<span class=\"z-highlight\">");
			Matcher matcher0 = pattern0.matcher(product);
			Pattern pattern1 = Pattern.compile("<span class=\"z-highlight\">(.*)");
			Matcher matcher1 = pattern1.matcher(product);
			if (matcher0.find()) {
				product = matcher0.group(1).trim();
			}
			if (matcher1.find()) {
				price = matcher1.group(1).trim();
			}
			System.out.println("产品： " + product + "\n价格： " + price + "\n");
			SmzdmProduct smzdmProduct = new SmzdmProduct(product, price);
			results.add("产品： " + product + ", 价格： " + price + "\n");
		}
		return results;
	}

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("<span class=\"z-highlight\">(.*)");
		Matcher matcher = pattern.matcher("Canon 佳能 EOS 70D套机(18-200mm)中高端数码单反相机 <span class=\"z-highlight\">7399元包邮");
		if (matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
}
