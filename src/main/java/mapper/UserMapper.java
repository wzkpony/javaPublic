package mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.List;
import model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

public List<UserInfo> selectusermapper();

public List<UserInfo> selectusermapperForLogin(@Param("name") String name,@Param("pwd") String pwd);

public void insertUser(@Param("name") String name,
                       @Param("pwd") String pwd,
                       @Param("sex") String sex,
                       @Param("age") String age,
                       @Param("idCard") String idCard,
                       @Param("staffNum") String staffNum,
                       @Param("phone") String phone,
                       @Param("department") String department,
                       @Param("post") String post,
                       @Param("headImagePatch") String headImagePatch,
                       @Param("telephone") String telephone,
                       @Param("mail") String mail,
                       @Param("bossName") String bossName,
                       @Param("bossid") int bossid);

}






