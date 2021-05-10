package rich.zrc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rich.zrc.dao.RichDao;

@Service
public class RichService {
    @Autowired
    private RichDao richDao;

    public void print() {
        System.out.println(richDao);
    }
}
