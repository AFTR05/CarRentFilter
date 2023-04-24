package com.example.carrent.repository;

import java.util.HashSet;
import java.util.List;

public interface Repository <T>{
    HashSet<T> list();
    T byId(Long id);
    void save(T t);
    void delete(Long id);
    void update(Long id,T t);
}
