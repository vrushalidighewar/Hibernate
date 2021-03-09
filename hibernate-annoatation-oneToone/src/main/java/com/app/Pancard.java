package com.app;


import javax.persistence.Column;
import org.hibernate.annotations.Parameter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pancard")
public class Pancard {

    @Id
    @GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
    @Column(name="id")
    private int id;
    
    @Column(name="pancardno")
    private String panNo;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Pancard [id=" + id + ", panNo=" + panNo + "]";
	}
    
 
	
}
