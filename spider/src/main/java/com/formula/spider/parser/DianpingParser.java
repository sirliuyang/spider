/**
 * 
 */
package com.formula.spider.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.formula.spider.bean.City;
import com.formula.spider.bean.SmzdmProduct;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class DianpingParser {
	public static City parseCities(String item) {
		String name = "";
		String link = "";
		Pattern pattern0 = Pattern.compile("<a href=\".*\" onclick=");
		Matcher matcher0 = pattern0.matcher(item);
		Pattern pattern1 = Pattern.compile("");
		Matcher matcher1 = pattern1.matcher(item);
		if (matcher0.find()) {
			name = matcher0.group(1).trim();
		}
		if (matcher1.find()) {
			link = matcher1.group(1).trim();
		}
		City city = new City(name, link);
		System.out.println(city);
		return city;
	}
}
