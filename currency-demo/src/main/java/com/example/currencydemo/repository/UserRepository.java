package com.example.currencydemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.currencydemo.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
