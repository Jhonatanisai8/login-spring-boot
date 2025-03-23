package com.isai.login_spring_boot.service;

public interface CrudService<T,K> {

    T saveUser(K entity);
}