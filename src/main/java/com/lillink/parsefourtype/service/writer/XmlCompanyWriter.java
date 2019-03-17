package com.lillink.parsefourtype.service.writer;

import com.lillink.parsefourtype.model.Company;
import com.lillink.parsefourtype.service.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class XmlCompanyWriter extends Writer<Company> {

    public XmlCompanyWriter(String path){
        super(path);
    }

    @Override
    public void write(Company company){
        try {
            this.serializeXml(company);
        }catch (IOException e){
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void serializeXml(Company company) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(company, new File(path));
    }
}
