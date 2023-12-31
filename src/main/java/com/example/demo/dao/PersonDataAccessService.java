package com.example.demo.dao;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        String sqlQuery="SELECT id,name FROM person";
        return jdbcTemplate.query(sqlQuery,(resultSet,i)->{
            UUID id=UUID.fromString(resultSet.getString("id"));
            String name=resultSet.getString("name");
            return new Person(id,name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // Implement the method
        String sqlQuery="SELECT id,name FROM person";
        // Person person=jdbcTemplate.queryForObject(sqlQuery, new Object[] {id},(resultSet,i)->{
        //     UUID id=UUID.fromString(resultSet.getString("id"));
        //     String name=resultSet.getString("name");
        //     return new Person(id,name);
        // });
            return null;
        // return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
