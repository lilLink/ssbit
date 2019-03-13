package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDao extends Dao implements BaseDao<Contact> {

    public static final String FIND_ALL_QUERRY = "select * from contact";
    public static final String UPDATE_ALL_QUERRY = "update contacts set email = ?, number = ?";

    @Override
    public Contact findById(Long id){
        return null;
    }

    @Override
    public List<Contact> findAll(){
        List<Contact> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERRY);

            while (set.next()){
                Contact contact = new Contact();
                contact.setEmail(set.getString("email"));
                contact.setValue(set.getString("number"));

                resultList.add(contact);
            }
            System.out.println("All contacts get from database");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }

    public Contact update(Contact contact) {
        List<Contact> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(UPDATE_ALL_QUERRY);

            String email = set.getString("email");
            String number = set.getString("number");

            contact.setEmail(email);
            contact.setValue(number);

            resultList.add(contact);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Contact contact) {
    }

    @Override
    public void delete(Long id) {

    }
}
