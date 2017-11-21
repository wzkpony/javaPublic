package mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.List;
import model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface testmapper {

public List<UserInfo> selectusermapper();

public List<UserInfo> selectusermapperForLogin(@Param("name") String name,@Param("pwd") String pwd);

public void insertUser(@Param("name") String name, @Param("pwd") String pwd, @Param("sex") String sex, @Param
        ("age") String age, @Param
        ("idcard") String idcard);



}






