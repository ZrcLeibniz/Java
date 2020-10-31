package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Blog;
import rich.zrc.util.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBlogMapper {
    @Test
    public void testGetBlogAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogAll = mapper.getBlogAll();
        for (Blog blog : blogAll) {
            System.out.println(blog);
        }
    }

    @Test
    public void testGetBlogByMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title", "Java不难");
        map.put("author", "rich");
        List<Blog> blogByMap = mapper.getBlogByMap(map);
        for (Blog blog : blogByMap) {
            System.out.println(blog);
        }
    }
}
