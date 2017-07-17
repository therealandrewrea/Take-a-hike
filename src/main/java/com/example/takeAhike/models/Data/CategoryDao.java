package com.example.takeAhike.models.Data;

import com.example.takeAhike.models.Forms.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by area on 6/19/17.
 */

@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {

}
