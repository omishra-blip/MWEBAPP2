package com.omm.MYWEBAPP.DTO.InputDTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Feedbackinput {
    private customerinputdto customer;

    private int rating;
    private String comment;
}
