package com.example.finvision.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.finvision.model.Finance;

public interface IFinance extends CrudRepository<Finance, Integer>{

}