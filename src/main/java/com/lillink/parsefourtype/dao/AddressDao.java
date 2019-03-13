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
        return null;
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

    public void update(Address address) {

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(UPDATE_ALL_QUERRY);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(Address address) {

    }

    @Override
    public void delete(Long id) {

    }
}
