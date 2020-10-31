package rich.zrc.mapper;

import rich.zrc.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    List<Blog> getBlogAll();

    List<Blog> getBlogByMap(Map map);
}
