/**
 * 
 */
package com.formula.spider.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Leon(Liu Yang) Ideas from Formula Innovation
 */
public class MongoRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean insert() {
		return false;
	}
}
