package com.xc.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.collections.CollectionUtils;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class DynamicRepository {

    @Resource
    private MongoOperations mongoOperations;

    public Set<String> getExistingCollection() {
        return this.mongoOperations.getCollectionNames();
    }

    public MongoCollection<Document> createCollection(String collectionName) {
        return this.mongoOperations.createCollection(collectionName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return this.mongoOperations.collectionExists(collectionName) ? this.mongoOperations.getCollection(collectionName)
                : this.createCollection(collectionName);
    }

    public DynamicDocument insert(String collectionName, DynamicDocument data) {
        return this.mongoOperations.insert(data, collectionName);
    }

    public Long delete(List<QueryParam> queryParams, String collectionName) {
      Query query = new Query();
      if (CollectionUtils.isNotEmpty(queryParams)) {
        Criteria criteria = new Criteria();
        queryParams.forEach(queryParam -> MongoCondition.execute(criteria, queryParam));
        query.addCriteria(criteria);
      }
      DeleteResult remove = this.mongoOperations.remove(query,  collectionName);
      return remove.getDeletedCount();
    }

    public Long update(List<QueryParam> queryParams, Update update, String collectionName) {
      Query query = new Query();
      if (CollectionUtils.isNotEmpty(queryParams)) {
        Criteria criteria = new Criteria();
        queryParams.forEach(queryParam -> MongoCondition.execute(criteria, queryParam));
        query.addCriteria(criteria);
      }
      UpdateResult updateResult = this.mongoOperations.upsert(query, update, collectionName);
      return updateResult.getModifiedCount();
    }

    public <T> List<T> query(String collectionName, List<QueryParam> queryParams, Class<T> resultEntity) {
        Query query = new Query();
        if (CollectionUtils.isNotEmpty(queryParams)) {
            Criteria criteria = new Criteria();
            queryParams.forEach(queryParam -> MongoCondition.execute(criteria, queryParam));
            query.addCriteria(criteria);
        }
        return this.mongoOperations.find(query, resultEntity, collectionName);
    }


    public <T> T queryOne(List<QueryParam> queryParams, Class<T> resultEntity, String collectionName) {
        Query query = new Query();
        if (CollectionUtils.isNotEmpty(queryParams)) {
            Criteria criteria = new Criteria();
            queryParams.forEach(queryParam -> MongoCondition.execute(criteria, queryParam));
            query.addCriteria(criteria);
        }
        return this.mongoOperations.findOne(query, resultEntity, collectionName);
    }

    public <T> T findAndModify(List<QueryParam> queryParams, List<QueryParam> updateParams, Class<T> resultEntity, String collectionName) {
        Query query = new Query();
        if (CollectionUtils.isNotEmpty(queryParams)) {
            Criteria criteria = new Criteria();
            queryParams.forEach(queryParam -> MongoCondition.execute(criteria, queryParam));
            query.addCriteria(criteria);
        }
        Update update = new Update();
        if (CollectionUtils.isNotEmpty(queryParams)) {
            updateParams.forEach(updateParam -> {
                update.set(updateParam.getField(), updateParam.getValue());
            });
        }
        return this.mongoOperations.findAndModify(query, update, resultEntity, collectionName);
    }

    public Map<String, Object> insert(String collectionName, Map<String, Object> data) {
        return this.mongoOperations.insert(data, collectionName);
    }
}
