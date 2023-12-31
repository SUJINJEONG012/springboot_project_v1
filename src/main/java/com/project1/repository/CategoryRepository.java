package com.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project1.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
