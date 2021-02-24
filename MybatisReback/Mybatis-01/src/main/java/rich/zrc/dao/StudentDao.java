package rich.zrc.dao;

import rich.zrc.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();

    int insertStudent(Student student);
}
