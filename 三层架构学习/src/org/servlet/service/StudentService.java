package org.servlet.service;

import org.servlet.dao.StudentDao;
import org.servlet.entity.Student;

//业务逻辑层：逻辑性的增删改查,对Dao层进行的组装
public class StudentService {
	StudentDao studentDao = new StudentDao();	
	
	public boolean addStudent(Student student) {
		if(! studentDao.IsExsit(student.getID())) {
			studentDao.insert(student);
			return true;
		}else {
			System.out.println("增加失败，目标已存在");
			return false;
		}
	}
}
