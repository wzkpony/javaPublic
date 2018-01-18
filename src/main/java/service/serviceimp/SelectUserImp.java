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

    public  void  insertUserForRegist(String name,
                                      String pwd,
                                      String sex,
                                      String age,
                                      String idCard,
                                      String staffNum,
                                      String phone,
                                      String department,
                                      String post,
                                      String headImagePatch,
                                      String telephone,
                                      String mail,
                                      String bossName,
                                      int bossid)
    {
        testmap.insertUser(name,pwd,sex,age,idCard,staffNum,phone,department,post,headImagePatch,telephone,mail,
                bossName,bossid);
    }

}
