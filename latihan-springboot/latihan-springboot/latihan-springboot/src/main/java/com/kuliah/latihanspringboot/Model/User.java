package com.kuliah.latihanspringboot.Model;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id_user;

    private String fname;
    private String lname;
    private String email;

    private String username;
    private String password;
}
