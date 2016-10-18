package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 10/17/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
