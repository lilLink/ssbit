package com.lillink.parsefourtype.service.dao;

import com.lillink.parsefourtype.dao.ContactDao;
import com.lillink.parsefourtype.model.Contact;

import java.util.List;

public class ContactService implements Service<Contact> {
    private ContactDao contactDao = new ContactDao();

    @Override
    public List<Contact> getAll(){
        return contactDao.findAll();
    }

    @Override
    public void remove(Long id){
        contactDao.delete(id);
    }

    @Override
    public Contact getById(Long id){
        return contactDao.findById(id);
    }

    @Override
    public Long add(Contact contact){
        return contactDao.save(contact);
    }
}
