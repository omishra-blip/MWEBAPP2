package com.omm.MYWEBAPP.DTO.InputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class customerinputdto {
    private String name;
    private String email;
    private String city;
    private String phno;
}
