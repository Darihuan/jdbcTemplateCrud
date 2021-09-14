package com.bosonit.jdbctemplatecrud.persona.application;

import com.bosonit.jdbctemplatecrud.core.exception.NotFoundexception;
import com.bosonit.jdbctemplatecrud.persona.domain.Persona;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input.PersonaDtoInput;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.output.PersonaDtoOutput;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.repository.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements IPersonaService {
    @Autowired
    PersonaDao repository;


    @Override
    public List<PersonaDtoOutput> getAllPersonas() {
        return repository.selectPersonas();
    }

    @Override
    public PersonaDtoOutput getPersonaById(Integer id) throws NotFoundexception {
        return null;
    }

    @Override
    public int savePersona(PersonaDtoInput persona) throws Exception {
        Persona guardar = new Persona(persona);

        return repository.insertPersona(guardar);


    }

    @Override
    public PersonaDtoOutput updatePersona(PersonaDtoInput persona, Integer id) throws NotFoundexception {
        return null;
    }

    @Override
    public void deletePersona(Integer id) throws NotFoundexception {

    }
}
