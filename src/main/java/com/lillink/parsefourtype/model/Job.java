package com.lillink.parsefourtype.model;

import com.lillink.parsefourtype.adapter.LocaleDateAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
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

    @NotNull(message = "start date of work must be not null")
    @Past(message = "start date of work must be in past")
    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    private LocalDate beginWork;
    @NotNull(message = "position must be not null")
    @NotBlank(message = "position can't be blank")
    @XmlElement
    private String position;
    @NotNull(message = "end date of work must be not null")
    @PastOrPresent(message = "end date of work must be in past or present")
    @XmlElement
    @XmlJavaTypeAdapter(LocaleDateAdapter.class)
    private LocalDate endWork;
    @NotNull(message = "company name must be not null")
    @NotBlank(message = "company name can't be blank")
    @XmlElement
    private String jobCompany;
    @NotNull(message = "skill must be not null")
    @NotBlank(message = "skill can't be blank")
    @XmlElement
    private String skill;

    @XmlElement
    private Long id;

    public Job(){}

    public Job(LocalDate beginWork, String position, LocalDate endWork, String jobCompany, String skill) {
        this.beginWork = beginWork;
        this.position = position;
        this.endWork = endWork;
        this.jobCompany = jobCompany;
        this.skill = skill;
    }

    @Override
    public String toString() {
        return  " BeginWork = " + beginWork +
                ", Position = '" + position + '\'' +
                ", EndWork = " + endWork +
                ", Company = '" + jobCompany + '\'' +
                ", Skill = '" + skill + '\'';
    }

    public String getBeginWorkAsString() {
        return beginWork.toString();
    }

    public void setBeginWorkAsString(String beginWork) {
        this.beginWork = LocalDate.parse(beginWork);
    }

}
