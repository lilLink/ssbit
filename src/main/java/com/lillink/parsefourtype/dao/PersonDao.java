package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Person;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.apache.logging.log4j.LogManager.getLogger;

public class PersonDao extends DBConnection implements BaseDao<Person> {

    public static final String FIND_ALL_QUERY = "SELECT * FROM person";
    public static final String UPDATE_ALL_QUERY = "UPDATE person SET first_name = ?, last_name = ?, birth_date = ? WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO person (first_name,last_name,birth_date) VALUES (?,?,?) RETURNING id";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM person WHERE id = ?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM person WHERE id = ?";

    public static final Logger LOGGER = getLogger();

    @Override
    public Person findById(Long id){
        Person person = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                person = new Person();
                person.setId(id);
                person.setFirstName(set.getString("first_name"));
                person.setLastName(set.getString("last_name"));
                person.setBirthDate(LocalDate.parse(set.getDate("birth_date").toString()));
            }
            LOGGER.trace("Person {} found by id is successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Person {} wasn't found by id in database", id, e);
        }
        return person;
    }

    @Override
    public Person findByPersonId(Long id){
        return null;
    }

    @Override
    public List<Person> findAll(){
        List<Person> resultList = new ArrayList<>();
        LOGGER.trace("Started finding all in database");
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

            while (set.next()){
                Person person = new Person();
                person.setId(set.getLong("id"));
                person.setFirstName(set.getString("first_name"));
                person.setLastName(set.getString("last_name"));
                person.setBirthDate(LocalDate.parse(set.getDate("birth_date").toString()));

                resultList.add(person);
            }
            LOGGER.trace("Person found all in database");
        } catch (SQLException e){
            LOGGER.warn("Person {} wasn't found all in database", e);
        }
        return resultList;
    }

    @Override
    public Long save(Person person, Long personId) {
        Long savedId = null;
        String actionQuery;
        try {
            if (person.getId() == null || person.getId() == 0) {
                actionQuery = INSERT_ALL_QUERY;
            }else
                actionQuery = UPDATE_ALL_QUERY;

            PreparedStatement statement = connection.prepareStatement(actionQuery);

            statement.setString(1, person.getFirstName());
            statement.setString(2,person.getLastName());
            statement.setDate(3, Date.valueOf(person.getBirthDate()));

            if (person.getId() != null && person.getId() != 0) {
                statement.setLong(4, person.getId());
            }

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            if (person.getId() != 0) {
                savedId = resultSet.getLong("id");
            }
            LOGGER.trace("Person {} entered all in database", person);
        }catch (SQLException e){
            LOGGER.warn("Person {} wasn't entered in database", person, e);
        }
        return savedId;
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        LOGGER.trace("Started deleting person with id {} from database", id);
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
            LOGGER.trace("Person with id {} deleted successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Person {} wasn't delete in database", id, e);
        }
    }
}
