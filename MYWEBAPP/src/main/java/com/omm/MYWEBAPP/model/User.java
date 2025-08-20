package com.omm.MYWEBAPP.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @NotEmpty(message = "Name is required")
   @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;
    private String email;
    private String phno;
}
