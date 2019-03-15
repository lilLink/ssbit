package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Person;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.apache.logging.log4j.LogManager.getLogger;
import static com.lillink.parsefourtype.utility.ClassNameUtil.getClassName;

public class PersonDao extends Dao implements BaseDao<Person> {

    public static final String FIND_ALL_QUERY = "SELECT * FROM person";
    public static final String UPDATE_ALL_QUERY = "UPDATE person SET first_name = ?, last_name = ?, birth_date = ?, skills = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO person (first_name,last_name,birth_date,skills) VALUES (?,?,?,?)";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM person WHERE id = ?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM person WHERE id = ?";

    public static final Logger LOGGER = getLogger(getClassName());

    @Override
    public Person findById(Long id){
        Person person = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.first()){
                person = new Person();
                person.setId(id);
                person.setFirstName(set.getString("first_name"));
                person.setLastName(set.getString("last_name"));
                person.setBirthDate(LocalDate.parse(set.getDate("birth_date").toString()));
                person.setSkills(set.getString("skills"));
            }
            LOGGER.trace("Person {} found by id successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Person {} wasn't found in database", id, e);
        }
        return person;
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
                person.setFirstName(set.getString("first_name"));
                person.setLastName(set.getString("last_name"));
                person.setBirthDate(LocalDate.parse(set.getDate("birth_date").toString()));
                person.setSkills(set.getString("skills"));


                resultList.add(person);
            }
            LOGGER.trace("Person found all successfully");
        } catch (SQLException e){
            LOGGER.warn("Person wasn't found in database", e);
        }
        return resultList;
    }

    @Override
    public Long save(Person person) {
        try {
            String actionQuery = (person.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);

            statement.setString(1, person.getFirstName());
            statement.setString(2,person.getLastName());
            statement.setString(3,person.getBirthDateAsString());
            statement.setString(4,person.getSkills());

            if (person.getId() != null) {
                statement.setLong(4, person.getId());
            }

            statement.execute();
            LOGGER.trace("Person {} entered all in database", person);
        }catch (SQLException e){
            LOGGER.warn("Person {} wasn't entered in database", person, e);
        }
        return person.getId();
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        LOGGER.trace("Started deleteing person with id {} in database", id);
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
            LOGGER.trace("Person with id {} deleted successfully ", id);
        }catch (SQLException e){
            LOGGER.warn("Person {} wasn't deleted in database", id ,e);
        }
    }
}
