package org.learning.java.springblogricette.repository;

import org.learning.java.springblogricette.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categoria,Integer> {
}
