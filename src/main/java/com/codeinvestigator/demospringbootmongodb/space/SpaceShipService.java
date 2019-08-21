package com.codeinvestigator.demospringbootmongodb.space;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceShipService {

    private final MongoTemplate mongoTemplate;

    public SpaceShipService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<SpaceShip> allTheSourcers(){
        Query query = new Query()
                .addCriteria(Criteria.where("type").is("sourcer"))
                .with(Sort.by(Sort.Order.desc("engines"))).
                limit(4);
        return mongoTemplate.find(query, SpaceShip.class);
    }
}
