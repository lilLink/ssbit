package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Contact;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactDaoTest {
    
    private BaseDao<Contact> contactDao;
    
    @BeforeClass
    public void init(){
        this.contactDao = new ContactDao();
    }
    
    @Test
    public void testSave(){
        Contact contact1 = new Contact();
        
        contact1.setEmail("lillinkwrk@gmail.com");
        contact1.setNumber("+380 95 464 46 95");
        contactDao.save(contact1);

        Contact contact2 = new Contact();

        contact2.setEmail("vaduk2000@gmail.com");
        contact2.setNumber("+380 95 464 46 95");
        contact2.setId(3L);

        contactDao.save(contact2);
    }

    @Test
    public void testFindById(){
        contactDao.findById(3L);
    }

    @Test
    public void testDelete(){
        contactDao.delete(2L);
    }
}
