package com.lillink.parsefourtype.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @NotNull(message = "email must be not null")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+(com|net|ua|ru|org)$")
    @XmlElement
    private String email;

    @NotNull(message = "phone number must be not null")
    @NotBlank(message = "phone number must be not blank")
    @Pattern(regexp = "^\\+?\\d{12}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")
    @XmlElement
    private String number;

    public Contact(){}

    public Contact(String email, String number) {
        this.email = email;
        this.number = number;
    }

    @Override
    public String toString() {
        return " Email='" + email + '\'' +
                ", Number='" + number + '\'';
    }
}
