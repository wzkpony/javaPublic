package controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.serviceimp.ApplyServerImp;

@Controller
public class ApplyController {
    /*
     * ResponseBody:调用commitApply，会调用commitApplyFor方法
     * RequestParam：网络请求调用到这的参数
     * RequestMapping：定义地址路径和网路请求方式
     */
    @Resource(name = "applyServerImpid")
    private ApplyServerImp applyServerImp;
    @RequestMapping(value = "/commitApply" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> commitApplyFor(@RequestParam Map<String,Object> mapApply) {
        Map<String, Object> map = new HashMap<String, Object>();
        int userid = Integer.parseInt(mapApply.get(ControllerConfig.userid).toString());
        int auditid = Integer.parseInt(mapApply.get(ControllerConfig.auditid).toString());
        int receiverid = Integer.parseInt(mapApply.get(ControllerConfig.receiverid).toString());
       boolean success = applyServerImp.insertApplyServer(
                userid,
                mapApply.get(ControllerConfig.applyState).toString(),
                mapApply.get(ControllerConfig.type).toString(),
                mapApply.get(ControllerConfig.state_).toString(),
                mapApply.get(ControllerConfig.userName).toString(),
                auditid,
                mapApply.get(ControllerConfig.auditName).toString(),
                mapApply.get(ControllerConfig.commitTime).toString(),
                mapApply.get(ControllerConfig.beginTime).toString(),
                mapApply.get(ControllerConfig.endTime).toString(),
                mapApply.get(ControllerConfig.reason).toString(),
                mapApply.get(ControllerConfig.interval).toString(),
                receiverid,
                mapApply.get(ControllerConfig.receiverName).toString(),
                mapApply.get(ControllerConfig.applyCode).toString()
        );
        if (success)
        {
            map.put(ControllerConfig.code,"200");
            map.put(ControllerConfig.mas,"申请成功");
        }
        else
        {
            map.put(ControllerConfig.code,"400");
            map.put(ControllerConfig.mas,"申请失败");
        }
        return map;
    }
    @RequestMapping(value = "/updateApply",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> updateApplyFor(@RequestParam Map<String,Object> mapApply){
        Map<String, Object> map = new HashMap<String, Object>();
        int userid = Integer.parseInt(mapApply.get(ControllerConfig.userid).toString());
        int auditid = Integer.parseInt(mapApply.get(ControllerConfig.auditid).toString());
        int receiverid = Integer.parseInt(mapApply.get(ControllerConfig.receiverid).toString());
        boolean success = applyServerImp.updateApplyServer(
                userid,
                mapApply.get(ControllerConfig.applyState).toString(),
                mapApply.get(ControllerConfig.type).toString(),
                mapApply.get(ControllerConfig.state_).toString(),
                mapApply.get(ControllerConfig.userName).toString(),
                auditid,
                mapApply.get(ControllerConfig.auditName).toString(),
                mapApply.get(ControllerConfig.commitTime).toString(),
                mapApply.get(ControllerConfig.beginTime).toString(),
                mapApply.get(ControllerConfig.endTime).toString(),
                mapApply.get(ControllerConfig.reason).toString(),
                mapApply.get(ControllerConfig.interval).toString(),
                receiverid,
                mapApply.get(ControllerConfig.receiverName).toString(),
                mapApply.get(ControllerConfig.applyCode).toString()
        );
        if (success)
        {
            map.put(ControllerConfig.code,"200");
            map.put(ControllerConfig.mas,"更改申请成功");
        }
        else
        {
            map.put(ControllerConfig.code,"400");
            map.put(ControllerConfig.mas,"更改申请失败");
        }
        return map;
    }

}
