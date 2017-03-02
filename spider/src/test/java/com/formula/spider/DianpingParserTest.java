/**
 * 
 */
package com.formula.spider;

import org.junit.Before;
import org.junit.Test;

import com.formula.spider.parser.DianpingParser;

import junit.framework.TestCase;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */

public class DianpingParserTest {
	private static String input;

	@Before
	public void setup() {
	}

	@Test
	public void parseCities() {
		input = "<a href=\"http://www.dianping.com/abagaqi\" onclick=\"pageTracker._trackPageview('dp_citylist_new_pinyin_strongcity_1_1');\"><strong>阿巴嘎旗</strong></a>";
		System.out.println(DianpingParser.parseCities(input));
	}
}
