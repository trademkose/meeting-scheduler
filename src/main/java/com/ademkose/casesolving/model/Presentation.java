package com.ademkose.casesolving.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "presentation")
public class Presentation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "time")
	private String time;
	@Column(name = "minute")
	private  int minute;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	 
	public Presentation(Long id, String name, String time, int minute) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.minute = minute;
	}
	public Presentation() {
		
	}
	@Override
	public String toString() {
		return "Presentation [Id=" + id + ", name=" + name + ", time=" + time + ", minute=" + minute + "]";
	}  
	

}
