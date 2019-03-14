package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Address;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddressDaoTest {

    private BaseDao<Address> addressDao;

    @BeforeClass
    public void init(){
        this.addressDao = new AddressDao();
    }

    @Test
    public void testSave(){
        Address address1 = new Address();
        address1.setCountry("Ukraine");
        address1.setCity("Chernivtsi");
        address1.setStreet("Golovna 204");

        addressDao.save(address1);

        Address address2 = new Address();
        address2.setCountry("Ukraine");
        address2.setCity("Chernivtsi");
        address2.setStreet("Bulvar 2");
        address2.setId(2L);

        addressDao.save(address2);
    }

    @Test
    public void testFindById(){
        addressDao.findById(1L);
    }

    @Test
    public void testDelete(){
        addressDao.delete(3L);
    }
}
