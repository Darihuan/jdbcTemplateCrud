package com.bosonit.jdbctemplatecrud.persona.infrastructure.repository;

import com.bosonit.jdbctemplatecrud.core.exception.NotFoundexception;
import com.bosonit.jdbctemplatecrud.persona.domain.Persona;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.input.PersonaDtoInput;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.controller.dto.output.PersonaDtoOutput;
import com.bosonit.jdbctemplatecrud.persona.infrastructure.repository.RowMapper.PersonaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PersonaDtoOutput> selectPersonas() {
        String query = "SELECT id,password,company_email,personal_email,city,active,created_date,imagen_url,termination_date FROM personas LIMIT 100";
        System.out.println(query);
        PersonaRowMapper mapper = new PersonaRowMapper();
        return jdbcTemplate.query(query, (resultSet, i) -> {
            return new PersonaDtoOutput(mapper.mapRow(resultSet, i));
        });
    }


    public List<Persona> getPersonaById(Integer id) throws NotFoundexception {
        String query = "SELECT id,password,company_email,personal_email,city,active,created_date,imagen_url,termination_date FROM personas WHERE id = ?";

        return jdbcTemplate.query(query, new PersonaRowMapper(), id);

    }


    public int insertPersona(Persona persona) throws Exception {
        String query = " INSERT INTO personas(id,password,company_email,personal_email,city,active,created_date,imagen_url,termination_date) VALUES(?,?,?,?,?,?,?,?,?) ";
        System.out.println(query);
        return jdbcTemplate.update(query,
                persona.getId(), persona.getPassword(), persona.getCompany_email(),
                persona.getPersonal_email(), persona.getCity(), persona.getActive(), persona.getCreated_Date(), persona.getImagen_url(),
                persona.getTermination_Date());

    }


    public int updatePersona(PersonaDtoInput persona, Integer id) throws NotFoundexception {
       String query = "UPDATE personas SET password = ?,company_email = ?,personal_email = ?,city = ?,active = ?,created_date = ?,imagen_url = ?,termination_date = ? WHERE id = ? ";
        System.out.println(query);
      return jdbcTemplate.update(query,persona.getPassword(),persona.getCompany_email(),persona.getPersonal_email(),persona.getCity(),
                persona.getActive(),persona.getCreated_Date(),persona.getImagen_url(), persona.getTermination_Date(), id);

    }


    public void deletePersona(Integer id) throws NotFoundexception {
        String query = "DELETE FROM personas WHERE id = ?";
        System.out.println(query);

        jdbcTemplate.query(query,new PersonaRowMapper(),id);

    }
}
