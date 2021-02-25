package rich.zrc.mapper;

import org.apache.ibatis.annotations.Param;
import rich.zrc.pojo.Student;
import rich.zrc.utils.QueryParam;

import java.util.List;

public interface StudentMapper {
    // 无参数
    List<Student> selectAll();

    // 简单参数
    Student selectStudentById(int id);

    // 多个参数
    List<Student> selectStudentBNameAndAge(@Param("studentName") String name, @Param("studentAge") Integer age);

    // 使用java对象作为接口中的参数
    List<Student> selectStudentByObject(QueryParam param);
}
