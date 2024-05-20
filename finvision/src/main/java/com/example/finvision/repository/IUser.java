package com.example.finvision.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.finvision.model.User;

public interface IUser extends CrudRepository<User, String>{

}