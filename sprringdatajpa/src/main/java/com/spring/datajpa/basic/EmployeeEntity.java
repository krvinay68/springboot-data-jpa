package com.spring.datajpa.basic;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;



/*
 * Use to specify the table name incase we can provide our table instead of class name
 * @Table(name="Employee")
 * @Column or @Column(name = "Ename") used to specify the column name
 */
@Entity
@Table
//@Lazy
public class EmployeeEntity {

	//@TableGenerator(name = "emp_genertor",table = "e_pkgenerator",pkColumnName = "pk_name",valueColumnName = "gen_val",allocationSize = 100)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator = "emp_genertor")
	
	//it will generate id automatically
//	@GenericGenerator(name = "emp_generator", strategy = "CustomGenerator")
//	@GeneratedValue(generator ="emp_generator" )
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id	
	private long id;
	//@Column(name = "Ename")
	private String name;
	private String empid;
	private String address;
	private String department;
	private String age;
	
	public EmployeeEntity() {};
	public EmployeeEntity(String name, String empid, String address, String department, String age) {
		
		this.name = name;
		this.empid = empid;
		this.address = address;
		this.department = department;
		this.age=age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", empid=" + empid + ", address=" + address
				+ ", department=" + department + ", age=" + age + "]";
	}
	
	
	
}
