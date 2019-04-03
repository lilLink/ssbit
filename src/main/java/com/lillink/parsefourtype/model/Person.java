package com.lillink.parsefourtype.model;

import com.lillink.parsefourtype.adapter.LocaleDateAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement
    private Long id;

    @NotNull(message = "name must be not null")
    @NotBlank(message = "name can't be blank")
    @Pattern(regexp = "^[A-Z]?[a-z]*(?:-[A-Z][a-z]*)?$")
    @XmlElement
    private String firstName;

    @NotNull(message = "last name must be not null")
    @NotBlank(message = "last name can't be blank")
    @XmlElement
    private String lastName;

    @NotNull(message = "date of birth must be not null")
    @Past(message = "date of birth must be in past")
    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    private LocalDate birthDate;

    @XmlElement
    @XmlElementWrapper
    private List<Job> job = new ArrayList<>();

    @XmlElement
    private Address address;

    @XmlElement
    @XmlElementWrapper
    private List<Contact> contacts = new ArrayList<>();


    public String getBirthDateAsString() {
        return birthDate.toString();
    }

    public void setBirthDateAsString(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public Person(){
    }

    public Person(String firstName, String lastName, LocalDate birthDate, List<Job> job, Address address, List<Contact> contacts){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.job = job;
        this.contacts = contacts;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(job, person.job) &&
                Objects.equals(address, person.address) &&
                Objects.equals(contacts, person.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, job, address, contacts);
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
