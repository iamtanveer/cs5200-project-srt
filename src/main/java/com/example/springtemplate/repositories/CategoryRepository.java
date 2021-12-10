package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
