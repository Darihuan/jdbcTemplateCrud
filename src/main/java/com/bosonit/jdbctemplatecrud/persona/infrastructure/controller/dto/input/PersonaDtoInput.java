package com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaDtoInput {

    Integer id;
    @NotNull
    String password;
    @Email
    @NotNull
    String company_email;
    @Email
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    @NotNull
    String imagen_url;
    Date termination_Date;
}
