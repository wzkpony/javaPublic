package service.serviceimp;

import java.util.List;
import mapper.testmapper;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SelectUser;

@Service("selectUserid")
public class SelectUserImp implements SelectUser {

    @Autowired
    private testmapper testmap;
    public List<UserInfo>getSelectUser()
    {
        return testmap.selectusermapper();
    }
}
