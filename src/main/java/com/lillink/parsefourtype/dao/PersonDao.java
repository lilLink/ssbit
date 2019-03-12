package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDao extends Dao implements BaseDao<Person> {

    public static final String FIND_ALL_QUERRY = "select * from person";
    public static final String UPDATE_ALL_QUERRY = "update person set first_name = ?, last_name = ?, birth_date = ?, skills = ?";

    @Override
    public Person findById(Long id){

    }

    @Override
    public List<Person> findAll(){
        List<Person> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERRY);

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

    @Override
    public Person update(Person person) {

        List<Person> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(UPDATE_ALL_QUERRY);

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
    public Person save(Person person) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
