package rich.zrc.service;

import org.springframework.beans.factory.annotation.Autowired;
import rich.zrc.dao.BaseDao;

public class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    public void save() {
        baseDao.save();
    }
}
