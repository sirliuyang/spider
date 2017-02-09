package com.formula.spider.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
@CompoundIndexes(@CompoundIndex(name = "", def = "{'name': 1}"))
public class Restaurant {
	@Id
	@Indexed(unique = true)
	private String id;

	@Indexed
	private String name;
}
