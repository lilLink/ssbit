package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressDao extends Dao implements BaseDao<Address> {

    public static final String FIND_ALL_QUERRY = "select * from address";
    public static final String UPDATE_ALL_QUERRY = "";

    @Override
    public Address findById(Long id){

    }

    @Override
    public List<Address> findAll(){
        List<Address> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERRY);

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

    @Override
    public Address update(Address address) {
        List<Address> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(UPDATE_ALL_QUERRY);

            String country = set.getString("country");
            String city = set.getString("city");
            String street = set.getString("street");

            address.setCountry(country);
            address.setCity(city);
            address.setStreet(street);

            resultList.add(address);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
