package com.lillink.parsefourtype.service.dao;

import com.lillink.parsefourtype.dao.AddressDao;
import com.lillink.parsefourtype.model.Address;

import java.util.List;

public class AddressService implements Service<Address> {
    private AddressDao addressDao = new AddressDao();

    @Override
    public List<Address> getAll(){
        return addressDao.findAll();
    }

    @Override
    public void remove(Long id){
        addressDao.delete(id);
    }

    @Override
    public Address getById(Long id){
        return addressDao.findById(id);
    }

    @Override
    public Long add(Address address){
        return addressDao.save(address);
    }
}
