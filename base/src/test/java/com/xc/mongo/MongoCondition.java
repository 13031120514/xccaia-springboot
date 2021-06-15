package com.xc.mongo;


import org.springframework.data.mongodb.core.query.Criteria;

import java.util.function.BiConsumer;

public enum MongoCondition {

  EQ((criteria, queryParam) -> {
    criteria.and(queryParam.getField()).is(queryParam.getValue());
  }),
  GT((criteria, queryParam) -> {
    criteria.and(queryParam.getField()).gt(queryParam.getValue());
  }),
  GE((criteria, queryParam) -> {
    criteria.and(queryParam.getField()).gte(queryParam.getValue());
  }),
  NE((criteria, queryParam) -> {
    criteria.and(queryParam.getField()).ne(queryParam.getValue());
  }),
  LT((criteria, queryParam) -> {
    criteria.and(queryParam.getField()).lt(queryParam.getValue());
  }),
  LE((criteria, queryParam) -> {
    criteria.and(queryParam.getField()).lte(queryParam.getValue());
  });

  private BiConsumer<Criteria, QueryParam> conditionConsumer;

  MongoCondition(BiConsumer<Criteria, QueryParam> conditionConsumer) {
    this.conditionConsumer = conditionConsumer;
  }

  public static void execute(Criteria criteria, QueryParam queryParam) {
    if (queryParam.getCondition() == null) {
      return;
    }
    queryParam.getCondition().getConditionConsumer().accept(criteria, queryParam);
  }

  public BiConsumer<Criteria, QueryParam> getConditionConsumer() {
    return conditionConsumer;
  }

  public void setConditionConsumer(
      BiConsumer<Criteria, QueryParam> conditionConsumer) {
    this.conditionConsumer = conditionConsumer;
  }
}
