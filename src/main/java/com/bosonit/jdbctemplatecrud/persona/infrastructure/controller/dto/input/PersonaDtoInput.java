package com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaDtoInput {
    Integer id;
    String password;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;
}
