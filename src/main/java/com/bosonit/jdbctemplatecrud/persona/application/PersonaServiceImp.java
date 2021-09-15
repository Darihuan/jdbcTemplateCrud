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
        try {
            Persona personas = repository.getPersonaById(id).get(0);
            return new PersonaDtoOutput(personas);
        } catch (Exception e) {
            throw new NotFoundexception(e.getMessage());
        }
    }

    @Override
    public PersonaDtoOutput savePersona(PersonaDtoInput persona) throws Exception {
        Persona guardar = new Persona(persona);
        PersonaDtoOutput devolver = null;
        if (repository.insertPersona(guardar) != 0) {
            devolver = new PersonaDtoOutput(guardar);
        }
        return devolver;


    }

    @Override
    public PersonaDtoOutput updatePersona(PersonaDtoInput persona, Integer id) throws NotFoundexception {
        try {
            Persona personaEntity = new Persona(persona);
            PersonaDtoOutput devolver = null;
            if (repository.updatePersona(persona, id) != 0)
                devolver = new PersonaDtoOutput(personaEntity);
            return devolver;

        } catch (Exception e) {
            throw new NotFoundexception("No existe persona con id:" + id);
        }
    }

    @Override
    public void deletePersona(Integer id) throws NotFoundexception {
        try {
            repository.deletePersona(id);
        } catch (Exception e) {
            throw new NotFoundexception("No existe persona con id:" + id);
        }
    }
}
