package com.darrylion.healthinsurancerestapi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "patient_policy")
public class PatientPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientPolicyId;

    private String lastName;

    private String firstName;

    private String patronymic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date termPolicy;

    public PatientPolicy() {
    }

    public PatientPolicy(String lastName, String firstName, String patronymic, Date birthday, Date termPolicy) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.termPolicy = termPolicy;
    }

    public Long getPatientPolicyId() {
        return patientPolicyId;
    }

    public void setPatientPolicyId(Long patientPolicyId) {
        this.patientPolicyId = patientPolicyId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getTermPolicy() {
        return termPolicy;
    }

    public void setTermPolicy(Date termPolicy) {
        this.termPolicy = termPolicy;
    }
}
