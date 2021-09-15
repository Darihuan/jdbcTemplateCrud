package com.bosonit.jdbctemplatecrud.persona.domain;


import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input.PersonaDtoInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    Integer id;
    String password;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;

    public Persona(PersonaDtoInput personaDTO) {
        setId(personaDTO.getId());
        setPassword(personaDTO.getPassword());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.getActive());
        setCreated_Date(personaDTO.getCreated_Date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_Date(personaDTO.getTermination_Date());
    }
}
