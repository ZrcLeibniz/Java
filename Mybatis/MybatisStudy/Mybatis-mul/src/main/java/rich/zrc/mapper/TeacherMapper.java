package rich.zrc.mapper;

import org.apache.ibatis.annotations.Param;
import rich.zrc.pojo.Teacher;

public interface TeacherMapper {
    Teacher getTeacher(int id);
}
