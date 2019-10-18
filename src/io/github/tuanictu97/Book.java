package io.github.tuanictu97;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="ten")
	private String name;
	
	@Column(name="mota")
	private String desc;
	
	public Book() {
		
	}
	public Book(int id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public Book(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
