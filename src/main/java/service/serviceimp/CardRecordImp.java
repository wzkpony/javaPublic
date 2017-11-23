package service.serviceimp;

import java.text.SimpleDateFormat;
import mapper.CardRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CardRecordid")
public class CardRecordImp {

    @Autowired
    private CardRecordMapper cardRecordmap;
    public void insertTimeCrad(int userid, int state,String limits,String location,int signType)
    {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date=new java.util.Date();
        String str=sdf.format(date);

        String years = "";
        String months = "";
        String days = "";
        String time = "";
//        2017-11-22 10:40:35


        cardRecordmap.insertCardRecord(userid,years,months,days,state,limits,location,signType);

    }
}
