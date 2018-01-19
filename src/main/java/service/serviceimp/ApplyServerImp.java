package service.serviceimp;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;
import java.util.List;
import mapper.ApplyMapper;
import model.ApplyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("applyServerImpid")
public class ApplyServerImp {

    @Autowired
    private ApplyMapper applyMapper;
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
        int index = applyMapper.intsertApply(userid,applyState,type,state,name,auditid,auditName,commitTime,beginTime,endTime,
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
        int index =  applyMapper.updateApply(userid,applyState,type,state,name,auditid,
                auditName,commitTime,beginTime,endTime,reason,
                interval,receiverid,receiverName,applyCode);
        if (index != 0)
        {
            success = true;
        }
        return success;

    }

    public List<ApplyModel> getSelectApplyServer(int userid,
                                                 String applyState,
                                                 String state,
                                                 int auditid,
                                                 String commitTime,
                                                 String beginTime,
                                                 String endTime,
                                                 int receiverid,
                                                 String applyCode)
    {
        List<ApplyModel> listApply = new ArrayList<ApplyModel>();
        listApply = applyMapper.selectApply(userid,applyState,state,auditid,commitTime,beginTime,endTime,receiverid,applyCode);
        return listApply;
    }
}
