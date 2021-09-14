package com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.output;

import com.bosonit.jdbctemplatecrud.persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDtoOutput {


    Integer id;
    String password;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;
    public PersonaDtoOutput(Persona persona) {

        setId(persona.getId());
        setPassword(persona.getPassword());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_Date(persona.getCreated_Date());
        setImagen_url(persona.getImagen_url());
        setTermination_Date(persona.getTermination_Date());
    }
}
