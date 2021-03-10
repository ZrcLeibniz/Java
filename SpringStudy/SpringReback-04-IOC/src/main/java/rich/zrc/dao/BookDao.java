package rich.zrc.dao;

import org.springframework.stereotype.Repository;
import rich.zrc.pojo.Book;

@Repository
public class BookDao extends BaseDao<Book> {
    @Override
    public void save() {
        System.out.println("保存图书");
    }
}
