package com.omm.MYWEBAPP.controller;

import com.omm.MYWEBAPP.DTO.InputDTO.Feedbackinput;
import com.omm.MYWEBAPP.DTO.OUTPUTDTO.Feedbackoutputdto;
import com.omm.MYWEBAPP.Entity.FeedbackEntity;
import com.omm.MYWEBAPP.service.Feedback_service;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class feedbackcontroller {

   private final Feedback_service feedback_service;

    @GetMapping("/feedback")
    public ResponseEntity<List<Feedbackoutputdto>> getFeedback(){
        return ResponseEntity.ok(feedback_service.getAllfeedback());
    }
    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedbackoutputdto> getFeedbackById(@PathVariable String id){
        return ResponseEntity.ok(feedback_service.getFeedbackById(id));
    }
    @PostMapping("/feedback/add")
    public String addFeedback(@RequestBody List<Feedbackinput> feedbackinput){
        return feedback_service.addFeedback(feedbackinput);

    }
    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable String id){
        return ResponseEntity.ok(feedback_service.deleteFeedback(id));
    }
    @DeleteMapping("/feedback/deleteall")
    public ResponseEntity<String> deleteallFeedback(){
        return ResponseEntity.ok(feedback_service.DeleteallFeedback());
    }
    @GetMapping("/feedback/highrated")
    public ResponseEntity<List<FeedbackEntity>> getHighrated(){
        return ResponseEntity.ok(feedback_service.GettingHighrated());
    }
    @GetMapping("/feedback/city/{city}")
    public ResponseEntity<List<Feedbackoutputdto>> getfeedbackbycustomercity(@PathVariable String city){
       return ResponseEntity.ok(feedback_service.getfeedbackbycustomercity(city));
    }
    @GetMapping("/feedback/avg")
    public ResponseEntity<List<Document>> getAveragerating(){
        return ResponseEntity.ok(feedback_service.getAveragerating());
    }
    @GetMapping("/feedback/count-by-city")
    public ResponseEntity<List<Document>>getFeedbackCountPerCity(){
        return ResponseEntity.ok(feedback_service.getFeedbackCountPerCity());
    }

}
