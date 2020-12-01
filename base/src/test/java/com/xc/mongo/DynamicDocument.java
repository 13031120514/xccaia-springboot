package com.xc.mongo;


import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public abstract class DynamicDocument implements Serializable {

    private static final long serialVersionUID = 2024918934402668471L;

    @Id
    protected String id;

    protected Date createdTime = new Date();

    protected Date updatedTime = new Date();

    public String getId() {
        return id;
    }

    public DynamicDocument setId(String id) {
        this.id = id;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public DynamicDocument setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public DynamicDocument setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }
}