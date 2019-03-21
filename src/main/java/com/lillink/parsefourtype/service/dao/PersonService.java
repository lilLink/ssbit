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
    public void remove(Long id){
        personDao.delete(id);
    }

    @Override
    public Person getById(Long id){
        return personDao.findById(id);
    }

    @Override
    public Long add(Person person){
        return personDao.save(person);
    }
}
