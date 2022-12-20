package org.foto.italy.demo.repo;

import org.foto.italy.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
