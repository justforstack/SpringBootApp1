package com.web.data.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.data.model.User;

@Repository
public interface UserRepository extends 
JpaRepository<User,Integer>{

}

