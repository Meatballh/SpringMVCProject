package cn.edu.xit.entity;





import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Student {
	//@NumberFormat(pattern="###,##")
	@Min(5)//被注释的元素必须是一个数字，其值必须大于或等于5
	private int id;
	private String name;
	private int age;
	private Address address;
	
	@Past//当前时间以前
	@DateTimeFormat(pattern="yyyy-MM-dd") //格式化 :前台传递来的数据，将前台传递来的数据固定为yyyy-MM-dd
	private Date birthday;//  2020-10-15
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Student() {
		
	}
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
