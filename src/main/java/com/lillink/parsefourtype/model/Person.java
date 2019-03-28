package com.lillink.parsefourtype.model;

import com.lillink.parsefourtype.adapter.LocaleDateAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement
    private Long id;
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    private LocalDate birthDate;
    @XmlElement
    @XmlElementWrapper
    private List<Job> job;
    @XmlElement
    private Address address;
    @XmlElement
    @XmlElementWrapper
    private List<Contact> contacts;


    public String getBirthDateAsString() {
        return birthDate.toString();
    }

    public void setBirthDateAsString(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public Person(){
        this.job = new ArrayList<>();
        this.contacts = new ArrayList<>();
        this.address = new Address();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", job=" + job +
                ", address=" + address +
                ", contacts=" + contacts +
                '}';
    }
}
