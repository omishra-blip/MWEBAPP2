package com.omm.MYWEBAPP.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTo {
    @JsonView(View.Detailed.class)
    private Integer id;
    @NotEmpty(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    @JsonView({View.Public.class,View.Input.class})
    private String name;
    @JsonView({View.Public.class,View.Input.class})
    private String email;
    @JsonView({View.Detailed.class,View.Input.class})
    private String phno;

}
