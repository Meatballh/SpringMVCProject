package cn.edu.xit.converter;

import org.springframework.core.convert.converter.Converter;

import cn.edu.xit.entity.Student;

public class MyConverter implements Converter<String, Student> {//<S,T>:source,target

	public Student convert(String source) {//source:2-zs-23
		String[] studentStrArr = source.split("-");
		Student student = new Student();
		student.setId(Integer.parseInt(studentStrArr[0]));
		student.setName(studentStrArr[1]);
		student.setAge(Integer.parseInt(studentStrArr[2]));
		return student;
	}
}
