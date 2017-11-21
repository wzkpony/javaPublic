package service.serviceimp;

import mapper.CardRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CardRecordid")
public class CardRecordImp {

    @Autowired
    private CardRecordMapper cardRecordmap;
    public void insertTimeCrad(int userid, String years, String months,
                               String days, int state,String limits,String location,int signType)
    {
        cardRecordmap.insertCardRecord(userid,years,months,days,state,limits,location,signType);

    }
}
