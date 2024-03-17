package com.k8sone.k8sonedemoone.repository;

import com.k8sone.k8sonedemoone.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
