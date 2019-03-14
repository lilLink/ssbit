package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddressDao extends Dao implements BaseDao<Address> {

    public static final String FIND_ALL_QUERY = "select * from address";
    public static final String UPDATE_ALL_QUERY = "UPDATE address SET country = ?, city = ?, street = ? WHERE id = ?";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM address WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO address (country,city,street) VALUES (?,?,?)";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM address WHERE id = ?";

    @Override
    public Address findById(Long id){
        Address address = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setLong(1,id);
            ResultSet set = statement.executeQuery();
            if (set.first()){
                address = new Address();
                address.setId(id);
                address.setCountry("country");
                address.setCity("city");
                address.setStreet("street");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public List<Address> findAll(){
        List<Address> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

            while (set.next()){
                Address address = new Address();
                address.setCountry(set.getString("country"));
                address.setCity(set.getString("city"));
                address.setStreet(set.getString("street"));

                resultList.add(address);
            }
            System.out.println("All contacts get from database");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }

    public void update(Address address) {

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(UPDATE_ALL_QUERY);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Long save(Address address) {
        try {
            String actionQuery = (address.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);


            statement.setString(1,address.getCountry());
            statement.setString(2,address.getCity());
            statement.setString(3,address.getStreet());

            if (address.getId() != null) {
                statement.setLong(4, address.getId());
            }

            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return address.getId();
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
