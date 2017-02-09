package com.formula.spider.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

//http://blog.csdn.net/zhu_tianwei/article/details/44281019

public class RestaurantRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	public void test() {
		Set<String> collections = this.mongoTemplate.getCollectionNames();
		for(String collection: collections){
			System.out.println("Collection Name : " + collection);
		}
	}
}
