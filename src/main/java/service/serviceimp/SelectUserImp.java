package service.serviceimp;

import java.util.List;
import mapper.UserMapper;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SelectUser;

@Service("selectUserid")
public class SelectUserImp implements SelectUser {

    @Autowired
    private UserMapper testmap;
    public List<UserInfo>getSelectUser()
    {
        return testmap.selectusermapper();
    }

    public UserInfo getSelectForLogin(String name, String pwd) {
        List<UserInfo> listmodel = testmap.selectusermapperForLogin(name,pwd);
        if (listmodel.size() >= 1)
        {
            UserInfo info = listmodel.get(0);
            return info;
        }
        else
        {
            return null;
        }
    }

    public  void  insertUserForRegist(String name,String pwd,String sex, String age,String idcard)
    {
        testmap.insertUser(name,pwd,sex,age,idcard);
    }

}
