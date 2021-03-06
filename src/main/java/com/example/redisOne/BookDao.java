package com.example.redisOne;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
//@Service
@CacheConfig(cacheNames = "book_cache")
public class BookDao {
//    @Autowired
//    MyKeyGenerator myKeyGenerator;
//    @Cacheable(keyGenerator = "myKeyGenerator")

    @Cacheable
    public Book getBookById(Integer id) {
        System.out.println("getBookById");
        Book book = new Book();
        book.setId(id);
        book.setName("JavaBook");
        book.setAuthor("James");
        return book;
    }
    @CachePut(key = "#book.id")
    public Book updateBookById(Book book) {
        System.out.println("updateBookById");
        book.setName("PythonBook");
        return book;
    }
    @CacheEvict(key = "#id" )
    public void deleteBookById(Integer id) {
        System.out.println("deleteBookById");
    }
}
