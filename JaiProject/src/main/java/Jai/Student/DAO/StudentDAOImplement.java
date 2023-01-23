package Jai.Student.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Jai.Student.api.Student;
import Jai.Student.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImplement implements StudentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {
		
		
		//I will write some logic to get me student data
		
		String sql ="SELECT * FROM students";
		
		List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return theListOfStudent;
	}
	@Override
	public void saveStudent(Student student) {
		
	Object[] sqlParameters = {student.getName(),student.getMobile(),student.getCountry()};
		
	String sql = "insert into students(name,mobile,country) values(?,?,?)";
	
	jdbcTemplate.update(sql, sqlParameters);
	
	System.out.println("1 record inserted..");
	
	}
	@Override
	public Student getStudent(int id) {
		String sql = "Select*FROM STUDENTS WHERE ID = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}
	@Override
	public void update(Student student) {
		
		String sql = "UPDATE STUDENTS SET name = ?, mobile = ?,country = ? WHERE id = ?";
		jdbcTemplate.update(sql,student.getName(), student.getMobile(),student.getCountry(), student.getId());
		System.out.println("1 record updated....");
		
		
	}
	@Override
	public void deleteStudent(int id) {
		
		String sql = "DELETE FROM STUDENTS WHERE ID = ?";
		jdbcTemplate.update(sql, id);
		
	}
}
