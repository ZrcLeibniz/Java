package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Blog;
import rich.zrc.util.IDUtils;
import rich.zrc.util.MybatisUtils;

import java.util.*;

public class TestBlogMapper {
    @Test
    public void testAddBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("rich");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        blog.setAuthor("rich");
        blog.setCreateTime(new Date());
        blog.setViews(1000);
        mapper.addBlog(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("SpringBoot如此简单");
        blog.setAuthor("rich");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        blog.setAuthor("rich");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap<>();
        map.put("author", "rich");
        map.put("title", "Java如此简单");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        Map map1 = new HashMap<>();
        List<Blog> blogs1 = mapper.queryBlogChoose(map1);
        sqlSession.close();
    }

    @Test
    public void testUpdateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title", "Java不难");
        map.put("author", "rich");
        map.put("id", "c48c1f19b279452797ac28a288d99eea");
        int i = mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        map.put("ids", arrayList);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
