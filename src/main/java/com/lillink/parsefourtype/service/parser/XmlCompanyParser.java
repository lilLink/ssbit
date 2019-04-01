package com.lillink.parsefourtype.service.parser;

import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.Optional;

public class XmlCompanyParser extends Parser<Person> {

    public XmlCompanyParser(String path){
        super(path);
    }


    @Override

    public Optional<Person> parse(){
        try {
            return this.deserializeXml(path);
        } catch (JAXBException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Person> deserializeXml(String path) throws  JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Person person = (Person) unmarshaller.unmarshal(new File(path));
        return Optional.of(person);

    }
}
