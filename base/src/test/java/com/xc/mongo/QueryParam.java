package com.xc.mongo;


public class QueryParam {

    private String field;

    private MongoCondition condition = MongoCondition.EQ;

    private Object value;

    public QueryParam(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public QueryParam(String field, MongoCondition condition, Object value) {
        this.field = field;
        this.condition = condition;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public MongoCondition getCondition() {
        return condition;
    }

    public void setCondition(MongoCondition condition) {
        this.condition = condition;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
