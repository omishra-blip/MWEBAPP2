package com.omm.MYWEBAPP.Entity;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "feedbacks")
public class FeedbackEntity {
    @Id
    private String id;

    private Customer_entity customer;
    private int rating; // 1–5
    private String comment;
    private LocalDate date;

}
