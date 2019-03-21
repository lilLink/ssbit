package com.lillink.parsefourtype.model;

import com.lillink.parsefourtype.adapter.LocaleDateAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Getter
@Setter
@XmlRootElement(name = "Job")
@XmlAccessorType(XmlAccessType.FIELD)
public class Job {

    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    private LocalDate beginWork;

    @XmlElement
    private String position;

    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    private LocalDate endWork;

    @XmlElement
    private String jobCompany;

    @XmlElement
    private String skill;

    @XmlElement
    private Long id;

    public Job(){}

    @Override
    public String toString() {
        return "Job{" +
                "beginWork=" + beginWork +
                ", position='" + position + '\'' +
                ", endWork=" + endWork +
                ", jobCompany='" + jobCompany + '\'' +
                ", skill='" + skill + '\'' +
                ", id=" + id +
                '}';
    }

    public String getBeginWorkAsString() {
        return beginWork.toString();
    }

    public void setBeginWorkAsString(String beginWork) {
        this.beginWork = LocalDate.parse(beginWork);
    }

}
