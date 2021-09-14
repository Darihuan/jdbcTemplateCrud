package com.bosonit.jdbctemplatecrud.persona.application;

import com.bosonit.jdbctemplatecrud.core.exception.NotFoundexception;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input.PersonaDtoInput;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.output.PersonaDtoOutput;

import java.util.List;

public interface IPersonaService {
    List<PersonaDtoOutput> getAllPersonas();

    PersonaDtoOutput getPersonaById(Integer id) throws NotFoundexception;

    int savePersona(PersonaDtoInput persona) throws Exception;

    PersonaDtoOutput updatePersona(PersonaDtoInput persona, Integer id) throws NotFoundexception;

    void deletePersona(Integer id) throws NotFoundexception;
}
