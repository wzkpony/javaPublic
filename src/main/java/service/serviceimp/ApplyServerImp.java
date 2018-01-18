package service.serviceimp;

import com.sun.org.apache.xpath.internal.operations.Bool;
import mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("applyServerImpid")
public class ApplyServerImp {

    @Autowired
    private ApplyMapper mapper;
    public boolean insertApplyServer(int userid,
                                  String applyState,
                                  String type,
                                  String state,
                                  String name,
                                  int auditid,
                                  String auditName,
                                  String commitTime,
                                  String beginTime,
                                  String endTime,
                                  String reason,
                                  String interval,
                                  int receiverid,
                                  String receiverName,
                                  String applyCode)
    {
        boolean success = false;
        int index = mapper.intsertApply(userid,applyState,type,state,name,auditid,auditName,commitTime,beginTime,endTime,
            reason,
            interval,receiverid,receiverName,applyCode);
       if (index != 0)
       {
           success = true;
       }
       return success;
    }

    public boolean updateApplyServer(int userid,
                                     String applyState,
                                     String type,
                                     String state,
                                     String name,
                                     int auditid,
                                     String auditName,
                                     String commitTime,
                                     String beginTime,
                                     String endTime,
                                     String reason,
                                     String interval,
                                     int receiverid,
                                     String receiverName,
                                     String applyCode)
    {
        boolean success = false;
        int index =  mapper.updateApply(userid,applyState,type,state,name,auditid,
                auditName,commitTime,beginTime,endTime,reason,
                interval,receiverid,receiverName,applyCode);
        if (index != 0)
        {
            success = true;
        }
        return success;

    }
}
