package rich.zrc.dao;

import rich.zrc.pojo.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectStudents();
}
