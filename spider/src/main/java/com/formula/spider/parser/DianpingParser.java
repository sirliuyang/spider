/**
 * 
 */
package com.formula.spider.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.formula.spider.bean.City;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class DianpingParser {
	public static City parseCities(String item) {
		String name = "";
		String link = "";
		Pattern patternLink = Pattern.compile("<a href=\"(.*?)\" onclick=");
		Matcher matcherLink = patternLink.matcher(item);
		Pattern patternName = Pattern.compile("<strong>(.*?)</strong>");
		Matcher matcherName = patternName.matcher(item);
		if (matcherName.find()) {
			name = matcherName.group(1).trim();
		}
		if (matcherLink.find()) {
			link = matcherLink.group(1);
		}
		City city = new City(name, link);
		System.out.println(city);
		return city;
	}
}
