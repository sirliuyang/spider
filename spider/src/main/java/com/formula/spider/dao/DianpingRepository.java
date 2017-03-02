/**
 * 
 */
package com.formula.spider.dao;

import java.util.Set;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
@Repository
public class MongoRepository {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public boolean save(JSON json) {
		DBObject dbObject = (DBObject) json;
		mongoTemplate.save(dbObject);
		return false;
	}
	
	public void save(String json) {
		DBObject dbObject = (DBObject)JSON.parse(json);
		mongoTemplate.save(dbObject);
	}
	
	//public 

	public void test() {
		Set<String> collectionNames = mongoTemplate.getCollectionNames();
		
		for (String collectionName : collectionNames) {
			DBCollection collection = mongoTemplate.getCollection(collectionName);
		}

		/*
		 * //Manual MongoClient mongoClient = new MongoClient(); MongoDatabase
		 * database = mongoClient.getDatabase("dianping");
		 * MongoCollection<Document> collection =
		 * database.getCollection("restaurant");
		 */
	}
}
