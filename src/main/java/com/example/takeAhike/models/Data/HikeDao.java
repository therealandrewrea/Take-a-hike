package com.example.takeAhike.models.Data;

import com.example.takeAhike.models.Forms.Category;
import com.example.takeAhike.models.Forms.Hike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by area on 6/19/17.
 */

@Repository
@Transactional
public interface HikeDao extends CrudRepository<Hike, Integer> {

}