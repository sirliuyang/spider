/**
 * 
 */
package com.formula.spider.dao;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
@Repository
public class MongoRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean BasicDBObjectBuilderInsert(String database, String table) {
		return false;
	}
	
	public void test(){
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("dianping");
		MongoCollection<Document> collection = database.getCollection("restaurant");
		System.out.println(collection.toString());
	}
}
