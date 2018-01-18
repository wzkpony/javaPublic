package service;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface ApplyServer {
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
                                  String applyCode);
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
                                     String applyCode);
    
}
