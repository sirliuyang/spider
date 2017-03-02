/**
 * 
 */
package com.formula.spider.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.formula.spider.bean.City;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class DianpingParser {
	public static List<City> parseCities(List<String> items) {
		List<City> cities = new ArrayList<City>();
		for (String item : items) {
			String name = "";
			String link = "";
			Pattern patternLink = Pattern.compile("<a href=\"(.*?)\" onclick=");
			Matcher matcherLink = patternLink.matcher(item);
			Pattern patternName0 = Pattern.compile("<strong>(.*?)</strong>");
			Matcher matcherName0 = patternName0.matcher(item);
			Pattern patternName1 = Pattern.compile(">(.*?)</a>");
			Matcher matcherName1 = patternName1.matcher(item);
			//TODO: This part needs re-factory
			if (matcherName0.find()) {
				name = matcherName0.group(1).trim();
			}
			if (matcherLink.find()) {
				link = matcherLink.group(1);
			}
			if (!link.contains("citylist")) {
				if (name.isEmpty()) {
					if (matcherName1.find()) {
						name = matcherName1.group(1).trim();
					}
				} else {
					cities.add(new City(name, link));
				}
			}
		}
		return cities;
	}
}
