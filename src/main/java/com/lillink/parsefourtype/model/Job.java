package com.lillink.parsefourtype.model;

import com.lillink.parsefourtype.adapter.LocaleDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;
import java.time.LocalDate;

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
    private Long id;

    public Job(){}

    @Override
    public String toString() {
        return "Job{" +
                "beginWork=" + beginWork +
                ", position='" + position + '\'' +
                ", endWork=" + endWork +
                ", id=" + id +
                '}';
    }

    public String getBeginWorkAsString() {
        return beginWork.toString();
    }

    public LocalDate getBeginWork() {
        return beginWork;
    }

    public void setBeginWork(String beginWork) {
        this.beginWork = LocalDate.parse(beginWork);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEndWorkAsString() {
        return endWork.toString();
    }

    public LocalDate getEndWork() {
        return endWork;
    }

    public void setEndWork(String endWork) {
        this.endWork = LocalDate.parse(endWork);
    }

    public Long getId() {
        return id;
    }

    public void setBeginWork(LocalDate beginWork) {
        this.beginWork = beginWork;
    }

    public void setEndWork(LocalDate endWork) {
        this.endWork = endWork;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
