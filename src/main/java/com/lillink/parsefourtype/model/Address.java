package com.lillink.parsefourtype.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlElement
    private Long id;
    @NotNull(message = "country must be not null")
    @NotBlank(message = "country can't be blank")
    @XmlElement
    private String country;
    @NotNull(message = "city must be not null")
    @NotBlank(message = "city can't be blank")
    @XmlElement
    private String city;
    @NotNull(message = "street must be not null")
    @NotBlank(message = "street can't be blank")
    @XmlElement
    private String street;

    public Address(){}

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                " country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
