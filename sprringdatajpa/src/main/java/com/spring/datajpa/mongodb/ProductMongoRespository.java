package com.spring.datajpa.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRespository extends MongoRepository<ProductMongo, String> {

}
