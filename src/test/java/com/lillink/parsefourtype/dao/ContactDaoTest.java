package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Contact;
import org.testng.Assert;
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
        
        contactDao.save(contact1,null);

        Contact contact2 = new Contact();

        contact2.setEmail("vaduk2000@gmail.com");
        contact2.setNumber("+380 95 464 46 95");
        contact2.setId(3L);

        contactDao.save(contact2,null);
    }

    @Test
    public void testFindById(){
        Contact contact1 = new Contact();

        contact1.setEmail("lillinkwrk@gmail.com");
        contact1.setNumber("+380 95 464 46 95");

        Long savedId = contactDao.save(contact1,null);

        Assert.assertEquals(contactDao.findById(savedId), contact1);
    }

    @Test
    public void testDelete(){
        contactDao.delete(2L);
    }
}
