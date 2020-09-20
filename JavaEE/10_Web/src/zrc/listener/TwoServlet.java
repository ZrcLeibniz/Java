package zrc.listener;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jiaozi_money = 30;
        int gaifan_money = 15;
        int miantiao_money = 20;
        int xiaofie = 0;
        String username = null;
        int money = 0;
        Cookie newCard = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 1.读取请求头参数信息，得到用户点餐食物类型
        String food = request.getParameter("food");
        // 2.读取请求头中Cookie
        Cookie[] cookies = request.getCookies();
        // 3.刷卡消费
        for (Cookie card : cookies) {
            String key = card.getName();
            String value = card.getValue();
            if (key.equals("username")) {
                username = value;
            } else {
                money = Integer.parseInt(value);
                if ("饺子".equals(food)) {
                    if (money < jiaozi_money) {
                        writer.print("用户" + username + "余额不足");
                    } else {
                        newCard = new Cookie("money", (money - jiaozi_money) + "");
                        xiaofie = jiaozi_money;
                    }
                } else if ("面条".equals(food)) {
                    if (money < miantiao_money) {
                        writer.print("用户" + username + "余额不足");
                    } else {
                        newCard = new Cookie("money", (money - miantiao_money) + "");
                        xiaofie = miantiao_money;
                    }
                } else if ("盖饭".equals(food)) {
                    if (money < gaifan_money) {
                        writer.print("用户" + username + "余额不足");
                    } else {
                        newCard = new Cookie("money", (money - gaifan_money) + "");
                        xiaofie = gaifan_money;
                    }
                }
            }
        }
        // 4.将用户的会员卡返还给用户
        response.addCookie(newCard);
        // 5.将消费记录写入响应头
        writer.print("用户消费金额为" + xiaofie + "元");
    }
}
