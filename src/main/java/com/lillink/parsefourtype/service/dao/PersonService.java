package com.lillink.parsefourtype.service.dao;

import com.lillink.parsefourtype.dao.PersonDao;
import com.lillink.parsefourtype.model.Person;

import java.util.List;

public class PersonService implements Service<Person> {
    private PersonDao personDao = new PersonDao();

    @Override
    public List<Person> getAll(){
        return personDao.findAll();
    }

    @Override
    public void delete(Long id){
        personDao.delete(id);
    }

    @Override
    public Person getByPersonId(Long id){
        return null;
    }

    @Override
    public Person getById(Long id){
        return personDao.findById(id);
    }

    public Long save(Person person, Long personId){
        return personDao.save(person,null);
    }
}
