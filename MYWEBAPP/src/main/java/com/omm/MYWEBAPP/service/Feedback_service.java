package com.omm.MYWEBAPP.service;

import com.omm.MYWEBAPP.DTO.InputDTO.Feedbackinput;
import com.omm.MYWEBAPP.DTO.MAPPER.CustoemrcumFeedbackMAp;
import com.omm.MYWEBAPP.DTO.MAPPER.User_Mapper;
import com.omm.MYWEBAPP.DTO.OUTPUTDTO.Feedbackoutputdto;
import com.omm.MYWEBAPP.Entity.FeedbackEntity;
import com.omm.MYWEBAPP.repo.Feedbackrepo;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class Feedback_service {
    private final Feedbackrepo feedbackrepo;
    private final CustoemrcumFeedbackMAp custoemrcumFeedbackMAp;
    private final MongoTemplate mongoTemplate;
    //



    public List<Feedbackoutputdto>getAllfeedback(){
        return feedbackrepo.findAll().stream().map(custoemrcumFeedbackMAp::toFeedbackOutputDto).toList();
    }
    public Feedbackoutputdto getFeedbackById(String id){
        return custoemrcumFeedbackMAp.toFeedbackOutputDto(feedbackrepo.findById(id).orElse(null));
    }
    public String addFeedback( List<Feedbackinput> feedbackinput){
       List<FeedbackEntity>entities=feedbackinput.stream()
               .map(custoemrcumFeedbackMAp::toFeedbackEntity)
               .toList();
        entities.forEach(entity -> entity.setDate(LocalDate.now()));
       feedbackrepo.saveAll(entities);
       return "The feedbacks added successfully";


    }
    public String deleteFeedback(String id){
        feedbackrepo.deleteById(id);
        return "Feedback deleted successfully";
    }
    public String DeleteallFeedback(){
        feedbackrepo.deleteAll();
        return "All feedback deleted successfully";
    }
   public List<FeedbackEntity> GettingHighrated(){
        Aggregation aggregation=Aggregation.newAggregation(Aggregation.match(Criteria.where("rating").gt(3)));
        return mongoTemplate.aggregate(aggregation,FeedbackEntity.class,FeedbackEntity.class).getMappedResults();
   }
    public List<Document> getAveragerating() {
        return mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.group("customer.email")
                                .first("customer.name").as("name")
                                .first("customer.city").as("city")
                                .avg("rating").as("avgRating")
                ),
                FeedbackEntity.class,
                Document.class
        ).getMappedResults();
    }

    public List<Feedbackoutputdto>getfeedbackbycustomercity(String city){
       return feedbackrepo.findAll().stream().filter(feedbackEntity -> feedbackEntity.getCustomer().getCity().equalsIgnoreCase(city)).map(custoemrcumFeedbackMAp::toFeedbackOutputDto).toList();
   }
    public List<Document> getFeedbackCountPerCity() {
        return mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.group("customer.city")
                                .count().as("totalFeedbacks")
                ),
                FeedbackEntity.class,
                Document.class
        ).getMappedResults();
    }




}
