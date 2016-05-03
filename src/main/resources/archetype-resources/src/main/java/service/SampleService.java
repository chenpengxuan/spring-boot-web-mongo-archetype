package ${package}.service;

import ${package}.dto.IdentityDTO;
import lombok.extern.slf4j.Slf4j;
import org.jongo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

/**
 * Sample service.
 *
 * @author sempere
 */
@Slf4j
@Transactional(readOnly = true)
@Service
public class SampleService {

	@Value("${spring.data.mongodb.collection.name}")
	public String collectionName;

	@Autowired
	private MongoTemplate mongoTemplate;

	// *************************************************************************
	//
	// Rest methods
	//
	// *************************************************************************

	/**
	 * Check access to DB by returning one document from it.
	 *
	 * @return a JSON object
	 */
	public IdentityDTO check() {
		return this.getMongoCollection()
				.findOne()
				.as(IdentityDTO.class);
	}

	// *************************************************************************
	//
	// Convenience methods
	//
	// *************************************************************************

	/**
	 * Get the mongo collection object.
	 *
	 * @return MongoCollection
	 */
	protected MongoCollection getMongoCollection() {
		return new Jongo(this.mongoTemplate.getDb()).getCollection(collectionName);
	}
}
