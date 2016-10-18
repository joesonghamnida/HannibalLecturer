package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by joe on 10/17/16.
 */
@RestController
public class HannibalLecturerController {

    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public ArrayList<Lecturer> getLecturer() throws IOException{
        return (ArrayList<Lecturer>) lecturers.findAll();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void addLecturer(HttpSession session, HttpServletResponse response, String name, String topic, String image){
        lecturers.save(new Lecturer(name, topic, image));
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public ArrayList<Review> getReview()throws IOException{
        return (ArrayList<Review>) reviews.findAll();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void addReview(String author, String text, int lecturerId, boolean isGood){
        Lecturer lecturer = lecturers.findOne(lecturerId);
        reviews.save(new Review(author, text, isGood, lecturer));
    }
}
