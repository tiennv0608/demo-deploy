package com.codegym.casestudy.service;

import com.codegym.casestudy.model.comment.Comment;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void delete(Long id);

}
