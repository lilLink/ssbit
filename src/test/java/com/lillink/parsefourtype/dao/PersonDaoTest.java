package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PersonDaoTest {

    private BaseDao<Person> personDao;

    @BeforeClass
    public void init(){
        this.personDao = new PersonDao();
    }

    @Test
    public void testSave(){
        Person person1 = new Person();
        person1.setFirstName("Vadim");
        person1.setLastName("Ptitsyn");
        person1.setBirthDate(LocalDate.parse("2000-08-07"));

        personDao.save(person1);

        Person person2 = new Person();
        person2.setId(2L);
        person2.setFirstName("Vadym");
        person2.setLastName("Ptitsyn");
        person2.setBirthDate(LocalDate.parse("2000-08-07"));

        personDao.save(person2);

    }

    @Test
    public void testFindById(){
        Person person1 = new Person();
        person1.setFirstName("Vadim");
        person1.setLastName("Ptitsyn");
        person1.setBirthDate(LocalDate.parse("2000-08-07"));

        Long savedId = personDao.save(person1);

        Assert.assertEquals(personDao.findById(savedId),person1);
    }

    @Test
    public void testDelete(){
        personDao.delete(3L);
    }
}
