package com.syngenta.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.syngenta.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

int save = 0;
int delete = 0;

List<Contact> findByName(String name);

List<Contact> findAll();

}