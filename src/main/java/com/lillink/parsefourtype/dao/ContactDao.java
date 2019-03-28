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

import static org.apache.logging.log4j.LogManager.getLogger;

public class ContactDao extends DBConnection implements BaseDao<Contact> {

    public static final String FIND_ALL_QUERY = "SELECT * FROM contacts";
    public static final String UPDATE_ALL_QUERY = "UPDATE contacts SET email = ?, number = ? WHERE id = ?";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM contacts WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO contacts (email,number,person) VALUES (?,?,?) RETURNING id";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM contacts WHERE id = ?";

    public static final Logger LOGGER = getLogger();

    @Override
    public Contact findById(Long id){
        Contact contact = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                contact = new Contact();
                contact.setId(id);
                contact.setEmail(set.getString("email"));
                contact.setNumber(set.getString("number"));
            }
            LOGGER.trace("Contact {} found by id successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Contact {} wasn't found in database", id);
        }
        return contact;
    }

    @Override
    public List<Contact> findAll(){
        List<Contact> resultList = new ArrayList<>();
        LOGGER.trace("Started finding all in database");
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

            while (set.next()){
                Contact contact = new Contact();
                contact.setId(set.getLong("id"));
                contact.setEmail(set.getString("email"));
                contact.setNumber(set.getString("number"));

                resultList.add(contact);
            }
            LOGGER.trace("Contact found all successfully");
        } catch (SQLException e){
            LOGGER.warn("Contact {} wasn't found in database",e);
        }
        return resultList;
    }

    @Override
    public Long save(Contact contact, Long personId) {
        Long savedId = null;
        try {
            String actionQuery = (contact.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);

            statement.setString(1,contact.getEmail());
            statement.setString(2,contact.getNumber());
            statement.setLong(3,personId);
            if (contact.getId() != null) {
                statement.setLong(3, contact.getId());
            }

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            savedId = resultSet.getLong("id");
            LOGGER.trace("Contact {} entered all in database",contact);
        }catch (SQLException e){
            LOGGER.warn("Contact {} wasn't entered in database", contact, e);
        }
        return savedId;
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        LOGGER.trace("Started deleting contact with id {} from database", id);
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
            LOGGER.trace("Contact with id {} deleted successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Contact {} wasn't delete in database", id, e);
        }
    }
}
