package com.example.redisCluster;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    @Cacheable(value = "c1")
    public String getBookById(Integer id) {
        System.out.println("getBookById");
        return "This is Python book.";
    }

    @CachePut(value = "c1")
    public String updateBookById(Integer id) {
        return "This is a brand-new Python book.";
    }

    @CacheEvict(value = "c1")
    public void deleteById(Integer id) {
        System.out.println("deleteById");
    }

    @Cacheable(value = "c2")
    public String getBookById2(Integer id) {
        System.out.println("getBookById2");
        return "This is a Java book";
    }
}
