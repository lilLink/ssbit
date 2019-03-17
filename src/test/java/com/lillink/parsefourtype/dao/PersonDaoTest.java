package com.lillink.parsefourtype.dao;

import com.lillink.parsefourtype.model.Person;
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
        person1.setFirstName("Vadym");
        person1.setLastName("Ptitsyn");
        person1.setBirthDate(LocalDate.of(2000,8,7));
        person1.setSkills("Java");

        personDao.save(person1);
        
        Person person2 = new Person();
        person2.setFirstName("Vadym");
        person2.setLastName("Ptitsyn");
        person2.setBirthDate(LocalDate.of(2000,8,7));
        person2.setSkills("QC");
        person2.setId(1L);

        personDao.save(person2);
    }

    @Test
    public void testDelete(){
        personDao.delete(4L);
    }
}
