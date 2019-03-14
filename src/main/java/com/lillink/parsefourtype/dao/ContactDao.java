package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Contact;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.lillink.parsefourtype.utility.ClassNameUtil.getClassName;
import static org.apache.logging.log4j.LogManager.getLogger;

public class ContactDao extends Dao implements BaseDao<Contact> {

    public static final String FIND_ALL_QUERY = "SELECT * FROM contact";
    public static final String UPDATE_ALL_QUERY = "UPDATE contacts SET email = ?, number = ?";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM contacts WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO contacts (email,number) VALUES (?,?)";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM contacts WHERE id = ?";

    public static final Logger LOGGER = getLogger(getClassName());

    @Override
    public Contact findById(Long id){
        Contact contact = null;
        LOGGER.trace("Started finding by id {} in database");
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.first()){
                contact = new Contact();
                contact.setId(id);
                contact.setEmail(set.getString("email"));
                contact.setValue(set.getString("number"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public List<Contact> findAll(){
        List<Contact> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

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

    @Override
    public Long save(Contact contact) {
        try {
            String actionQuery = (contact.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);

            statement.setString(1,contact.getEmail());
            statement.setString(2,contact.getValue());

            if (contact.getId() != null) {
                statement.setLong(4, contact.getId());
            }

            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contact.getId();
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
