package service;
import dao.UserDao;
import domain.User;
import util.MySpring;

public class UserService {
    UserDao userDao = MySpring.getBean("dao.UserDao");
    //确认用户
    public String confirm(String aname,String apassword) {
        User user = userDao.selectOne(aname);
        if (user != null && user.getApassword().equals(apassword)) {
            return "登录成功";
        }
        return "账号或密码错误";
    }

    //新增用户
    public String regist(String aname, String apassword, Float abalance) {
        User user = userDao.selectOne(aname);
        if (user != null) {
            return "当前账号已存在";
        }
        userDao.insert(aname, apassword, abalance);
        return "用户创建成功";
    }

    public Float selectMoney(String name) {
        User user = userDao.selectOne(name);
        return user.getAbalance();
    }

    public String updateUserMoney(String aname,Float money) {
        String out = "";
        Boolean value = userDao.update(aname,money);
        if (value) {
            out="操作成功，您当前余额为："+ this.selectMoney(aname);
        } else {
            out = "操作有误，请稍后重试";
        }
        return out;
    }
}
