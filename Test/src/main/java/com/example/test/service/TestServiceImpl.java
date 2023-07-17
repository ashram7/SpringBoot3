package com.example.test.service;

import com.example.test.entity.Test;
import com.example.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TestServiceImpl implements TestService {
    @Autowired
    TestRepository repository;

    @Override
    public Iterable<Test> selectAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Test> selectOneById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Test> selectOneRandomTest() {
        return Optional.empty();
    }

    @Override
    public Boolean checkTest(Integer id, Boolean myAnswer) {
        return null;
    }

    @Override
    public void insertTest(Test test) {

    }

    @Override
    public void updateTest(Test test) {

    }

    @Override
    public void deleteTestById(Integer id) {

    }
}
