package com.omm.MYWEBAPP.Exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error_Exceptio {
    private String message;
    private String details;
    private String timestamp;
    private int status;


}
