package com.lillink.parsefourtype.service.parser;

import com.lillink.parsefourtype.model.Company;
import com.lillink.parsefourtype.service.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.Optional;

public class XmlCompanyParser extends Parser<Company> {

    public XmlCompanyParser(String path){
        super(path);
    }


    @Override

    public Optional<Company> parse(){
        try {
            return this.deserializeXml(path);
        } catch (JAXBException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Company> deserializeXml(String path) throws  JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Company company = (Company) unmarshaller.unmarshal(new File(path));
        return Optional.of(company);

    }
}
