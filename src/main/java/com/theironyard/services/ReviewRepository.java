package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 10/17/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
