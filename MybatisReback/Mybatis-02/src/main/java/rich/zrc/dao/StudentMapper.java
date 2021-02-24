package rich.zrc.dao;

import rich.zrc.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectStudents();
}
