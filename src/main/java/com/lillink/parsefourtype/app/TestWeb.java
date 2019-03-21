package com.lillink.parsefourtype.app;

import com.lillink.parsefourtype.dao.AddressDao;
import com.lillink.parsefourtype.model.Address;

import java.util.List;

public class TestWeb {

    private AddressDao addressDao = new AddressDao();

    public String getHello()  {
        return "Hello Gradle Web Application";
    }

    public Address getAddress(){
        return addressDao.findById(20L);
    }

}
