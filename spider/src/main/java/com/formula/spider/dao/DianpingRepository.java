/**
 * 
 */
package com.formula.spider.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.formula.spider.bean.City;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
@Repository
public class DianpingRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void testConn() {
		Set<String> collectionNames = mongoTemplate.getCollectionNames();
		for (String collectionName : collectionNames) {
			System.out.println(collectionName);
		}
	}
	
	public void getCity(){
		List<City> cities = null;
		DBCollection collection = mongoTemplate.getCollection("cities");
		DBCursor cursor = collection.find();
	    while(cursor.hasNext()) {
	        System.out.println(cursor.next());
	    }
	}

}
