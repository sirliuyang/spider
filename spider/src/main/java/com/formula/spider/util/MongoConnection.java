package com.formula.spider.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	private static String address = "192.168.17.153";

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient(address, 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("dianping");
		mongoDatabase.createCollection("test");
	}
}
