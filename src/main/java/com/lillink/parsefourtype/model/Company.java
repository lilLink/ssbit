package com.lillink.parsefourtype.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "Company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

    @XmlElement
    private String nameCompany;

    @XmlElement
    @XmlElementWrapper
    private List<Person> personList;

    public Company(){}

    @Override
    public String toString() {
        return "Company{" +
                "nameCompany='" + nameCompany + '\'' +
                ", personList=" + personList +
                '}';
    }
}
