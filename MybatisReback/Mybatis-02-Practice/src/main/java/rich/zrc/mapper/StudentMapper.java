package rich.zrc.mapper;

import rich.zrc.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();

    Student selectStudentById(int id);
}
