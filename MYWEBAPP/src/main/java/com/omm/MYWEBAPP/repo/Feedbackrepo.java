package com.omm.MYWEBAPP.repo;

import com.omm.MYWEBAPP.Entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feedbackrepo extends MongoRepository <FeedbackEntity,String> {

}
