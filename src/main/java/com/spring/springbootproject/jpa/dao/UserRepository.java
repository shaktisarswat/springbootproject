package com.spring.springbootproject.jpa.dao;

import com.spring.springbootproject.jpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    // Customizing the query using spring data
    public List<User> findByName(String name);

    // Using @Query keyword with Native query
    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();

    // Using JPA query with @Query keyword
    @Query("select u From User u WHERE u.name=:n and u.id=:id")
    public List<User> getBYNameANDId(@Param("n") String name, @Param("id") Integer id);


}
