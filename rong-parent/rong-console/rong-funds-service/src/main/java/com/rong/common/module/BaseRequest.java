package com.rong.common.module;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequest<T,Q extends BaseRequest<T,Q>> implements Serializable {
    T entity;

    public T getEntity() {
        return entity;
    }

    public Q setEntity(T entity) {
        this.entity = entity;
        return (Q)this;
    }
}
