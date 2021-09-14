package com.bosonit.jdbctemplatecrud.persona.infrastructure.repository;

import com.bosonit.jdbctemplatecrud.core.exception.NotFoundexception;
import com.bosonit.jdbctemplatecrud.persona.domain.Persona;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input.PersonaDtoInput;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.output.PersonaDtoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PersonaDtoOutput> selectPersonas() {
        String query = "SELECT id,password,company_email,personal_email,city,active,created_date,imagen_url,termination_date FROM personas LIMIT 100";
        System.out.println(query);
        return jdbcTemplate.query(query, (resultSet, i) -> {
            return new PersonaDtoOutput(
                    resultSet.getInt("id"),
                    resultSet.getString("password"),
                    resultSet.getString("company_email"),
                    resultSet.getString("personal_email"),
                    resultSet.getString("city"),
                    resultSet.getBoolean("active"),
                    resultSet.getDate("created_date"),
                    resultSet.getString("imagen_url"),
                    resultSet.getDate("termination_date")
            );
        });
    }


    public PersonaDtoOutput getPersonaById(Integer id) throws NotFoundexception {
        return null;
    }


    public int insertPersona(Persona persona) throws Exception {
        String query = " INSERT INTO personas(id,password,company_email,personal_email,city,active,created_date,imagen_url,termination_date) VALUES(?,?,?,?,?,?,?,?,?) ";
        ;
        System.out.println(query);
        return jdbcTemplate.update(query,
                persona.getId(), persona.getPassword(), persona.getCompany_email(),
                persona.getPersonal_email(), persona.getCity(), persona.getActive(), persona.getCreated_Date(), persona.getImagen_url(),
                persona.getTermination_Date());
    }


    public PersonaDtoOutput updatePersona(PersonaDtoInput persona, Integer id) throws NotFoundexception {
        return null;
    }


    public void deletePersona(Integer id) throws NotFoundexception {

    }
}
