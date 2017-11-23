package controller;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.serviceimp.CardRecordImp;


@Controller
public class CardRecord {

    /**
     *签卡
     */
    @Resource(name = "CardRecordid")
    private CardRecordImp cardRecordImp;

    @RequestMapping(value = "/CardRecord",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> timeCardRecord(@RequestParam Map<String,Object> mapTimeCard)
    {
        Map<String, Object> map_ = new HashMap<String, Object>();

        int userid = Integer.valueOf(mapTimeCard.get("userid").toString()).intValue();
        String years = mapTimeCard.get("years").toString();
        String months = mapTimeCard.get("months").toString();
        String days = mapTimeCard.get("days").toString();
        int state = Integer.valueOf(mapTimeCard.get("state").toString()).intValue();
        String limits = mapTimeCard.get("limits").toString();
        String location = mapTimeCard.get("location").toString();
        int signType = Integer.valueOf(mapTimeCard.get("signType").toString()).intValue();

        cardRecordImp.insertTimeCrad(userid,state,limits,location,signType);
        map_.put("mas","已签到");
        return map_;
    }

}
