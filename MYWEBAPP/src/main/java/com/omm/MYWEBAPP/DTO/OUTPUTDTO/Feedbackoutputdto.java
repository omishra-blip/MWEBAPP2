package com.omm.MYWEBAPP.DTO.OUTPUTDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Feedbackoutputdto {
    private String id;
    private CustomerDto customer;
    private int rating;
    private String comment;
    private LocalDate date;
}
