package com.formular.spider.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
	public static List<String> parseSmzdm(List<String> items) {
		List<String> results = null;
		for (String item : items) {
			String temp = "";
			Pattern pattern0 = Pattern.compile("(.*)<span class=\"z-highlight\">");
			Matcher matcher0 = pattern0.matcher(item);
			Pattern pattern1 = Pattern.compile("<span class=\"z-highlight\">(.*)");
			Matcher matcher1 = pattern1.matcher(item);
			if (matcher0.find()) {
				item = matcher0.group(1).trim();
			}
			if (matcher1.find()) {
				temp = matcher1.group(1).trim();
			}
			item = "相机： " + item + "\n价格： " + temp + "\n";
			System.out.println(item);

		}
		return results;
	}

	// private static

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("<span class=\"z-highlight\">(.*)");
		Matcher matcher = pattern.matcher("Canon 佳能 EOS 70D套机(18-200mm)中高端数码单反相机 <span class=\"z-highlight\">7399元包邮");
		if (matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
}
