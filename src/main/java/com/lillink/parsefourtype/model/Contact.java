package com.lillink.parsefourtype.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name = "Contacts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {

    @XmlElement
    private Long id;
    @XmlElement
    private String email;
    @XmlElement
    private String value;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public Contact(){}
}
