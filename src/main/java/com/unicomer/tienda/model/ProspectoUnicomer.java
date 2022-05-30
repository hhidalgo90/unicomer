package com.unicomer.tienda.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prospecto")
public class ProspectoUnicomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private boolean gender;
    private String cellPhone;
    private String homePhone;
    private String addressHome;
    private String profession;
    private String incomes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getAddressHome() {
        return addressHome;
    }

    public void setAddressHome(String addressHome) {
        this.addressHome = addressHome;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIncomes() {
        return incomes;
    }

    public void setIncomes(String incomes) {
        this.incomes = incomes;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProspectoUnicomer{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", LastName='").append(lastName).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", gender=").append(gender);
        sb.append(", cellPhone='").append(cellPhone).append('\'');
        sb.append(", homePhone='").append(homePhone).append('\'');
        sb.append(", addressHome='").append(addressHome).append('\'');
        sb.append(", profession='").append(profession).append('\'');
        sb.append(", incomes='").append(incomes).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
