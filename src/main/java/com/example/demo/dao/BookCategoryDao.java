package com.example.demo.dao;

import com.example.demo.domain.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryDao extends JpaRepository<BookCategory, Long> {
}
