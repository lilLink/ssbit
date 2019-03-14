package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDao extends Dao implements BaseDao<Person> {

    public static final String FIND_ALL_QUERY = "select * from person";
    public static final String UPDATE_ALL_QUERY = "update person set first_name = ?, last_name = ?, birth_date = ?, skills = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO person (first_name,last_name,birth_date,skills) VALUES (?,?,?,?)";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM person WHERE id = ?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM person WHERE id = ?";

    @Override
    public Person findById(Long id){
        Person person = null;
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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> findAll(){
        List<Person> resultList = new ArrayList<>();

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
            System.out.println("All person get from database");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }

    public Person update(Person person) {

        List<Person> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(UPDATE_ALL_QUERY);

            String firstName = set.getString("first_name");
            String lastName = set.getString("last_name");
            LocalDate birthDate = LocalDate.parse(set.getDate("birth_date").toString());
            String skills = set.getString("skills");

            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setBirthDate(birthDate);
            person.setSkills(skills);

            resultList.add(person);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Person person) {
        try {
            String actionQuery = (person.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);

            statement.setString(1, person.getFirstName());
            statement.setString(2,person.getLastName());
            statement.setString(3,person.getBirthDate());
            statement.setString(4,person.getSkills());

            if (person.getId() != null) {
                statement.setLong(4, person.getId());
            }

            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
