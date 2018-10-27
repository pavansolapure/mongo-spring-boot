package com.opencodez.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import com.opencodez.domain.Users;

@Component
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public long updateUser(String address, Double salary) {
		
		Query query = new Query(Criteria.where("address").is(address));
		Update update = new Update();
		update.set("salary", salary);
		
		UpdateResult result = mongoTemplate.updateFirst(query, update, Users.class);

		if (result != null)
			return result.getModifiedCount();
		else
			return 0;
	}

}
