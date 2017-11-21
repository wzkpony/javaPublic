package service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.List;
import model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface SelectUser {
    public List<UserInfo>getSelectUser();
    public UserInfo getSelectForLogin(String name,String pwd);
    public void insertUserForRegist(String name, String pwd, String sex,
                                    String age, String idcard);
}
