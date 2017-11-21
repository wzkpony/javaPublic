package mapper;

import org.apache.ibatis.annotations.Param;

public interface CardRecordMapper {
    public void insertCardRecord(@Param("userid") int userid,
                                 @Param("years") String years,
                                 @Param("months") String  months,
                                 @Param("days") String days,
                                 @Param("state") int state,
                                 @Param("limits") String limits,
                                 @Param("location") String location,
                                 @Param("signType") int signType);




}
