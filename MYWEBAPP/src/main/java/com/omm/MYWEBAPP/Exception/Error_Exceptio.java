package com.omm.MYWEBAPP.Exception;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Error_Exceptio {
    private String message;
    private String details;
    private String timestamp;
    private int status;


}
