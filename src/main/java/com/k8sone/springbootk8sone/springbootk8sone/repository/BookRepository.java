package com.k8sone.springbootk8sone.springbootk8sone.repository;

import com.k8sone.springbootk8sone.springbootk8sone.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
