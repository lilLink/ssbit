package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public class AddressDao extends DBConnection implements BaseDao<Address> {

    public static final String FIND_ALL_QUERY = "SELECT * FROM address";
    public static final String UPDATE_ALL_QUERY = "UPDATE address SET country = ?, city = ?, street = ? WHERE id = ?";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM address WHERE id = ?";
    public static final String FIND_BY_PERSON_QUERY = "SELECT * FROM address WHERE person = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO address (country,city,street,person) VALUES (?,?,?,?) RETURNING id";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM address WHERE id = ?";

    public static final Logger LOGGER = getLogger();

    @Override
    public Address findById(Long id){
        Address address = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                address = new Address();
                address.setId(id);
                address.setCountry(set.getString("country"));
                address.setCity(set.getString("city"));
                address.setStreet(set.getString("street"));
                LOGGER.trace("Address {} found by id successfully", id);
            }
        }catch (SQLException e){
            LOGGER.warn("Address {} wasn't found in database", id, e);
        }
        return address;
    }

    @Override
    public Address findByPersonId(Long id){
        Address address = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_PERSON_QUERY);
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                address = new Address();
                address.setId(id);
                address.setCountry(set.getString("country"));
                address.setCity(set.getString("city"));
                address.setStreet(set.getString("street"));
                LOGGER.trace("Address {} found by id successfully", id);
            }
        }catch (SQLException e){
            LOGGER.warn("Address {} wasn't found in database", id, e);
        }
        return address;
    }

    @Override
    public List<Address> findAll(){
        List<Address> resultList = new ArrayList<>();
        LOGGER.trace("Started finding all {} in database");
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

            while (set.next()){
                Address address = new Address();
                address.setId(set.getLong("id"));
                address.setCountry(set.getString("country"));
                address.setCity(set.getString("city"));
                address.setStreet(set.getString("street"));

                resultList.add(address);
                LOGGER.trace("Address {} found all successfully",address);
            }
        } catch (SQLException e){
            LOGGER.warn("Address {} wasn't found in database",e);
        }
        return resultList;
    }

    @Override
    public Long save(Address address, Long personId) {
        Long savedId = null;
        try {
            String actionQuery = (address.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);


            statement.setString(1,address.getCountry());
            statement.setString(2,address.getCity());
            statement.setString(3,address.getStreet());
            statement.setLong(4,personId);

            if (address.getId() != null) {
                statement.setLong(4, address.getId());
            }

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            savedId = resultSet.getLong("id");
            LOGGER.trace("Address {} entered all in database", address);
        }catch (SQLException e){
            LOGGER.warn("Address {} wasn't entered in database", address);
        }
        return savedId;
    }

    @Override
    public void delete(Long id) {
        PreparedStatement statement = null;
        LOGGER.trace("Started deleting client with id {} from database", id);
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
            LOGGER.trace("Address with id {} deleted successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Address {} wasn't delete in database", id, e);
        }
    }
}
