package Day7_16.Test;

import Day7_16.Utils.new_DBUtils;
import Day7_16.bean.User;

import java.util.List;

public class new_DBUtilsTest {
    public static void main(String[] args) {
        //创建class对象
        Class<User> userClass = User.class;
        //查询语句
        String sql ="select * from Day7_16";
        List<User> arr = new_DBUtils.select(sql, userClass);
        for (User user : arr) {
            System.out.println(user);
        }
    }
}
