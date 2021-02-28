package rich.zrc.mapper;

import org.apache.ibatis.annotations.Param;
import rich.zrc.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();

    Student selectById(@Param("id") int id);
}
