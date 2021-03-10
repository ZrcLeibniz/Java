package rich.zrc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rich.zrc.mapper.RichMapper;

@Service
public class RichService {
    @Autowired
    private RichMapper richMapper;

    public void richService() {
        System.out.println("service正在调用dao帮你喊出Spring牛逼");
        richMapper.rich();
    }
}
