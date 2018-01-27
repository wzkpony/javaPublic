package controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.serviceimp.SelectUserImp;


@Controller
public class login {

    @Resource(name = "selectUserid")
    private SelectUserImp selectuserimp;


    /**
     * 登录
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String login() {
        int i = 1;
        i++;
        System.out.println("i=" + i);
        return "hhhhh";
    }
     */
    /**
     * 检测用户是否存在
     */
    @RequestMapping(value = "/doLogin", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> getTeacher(@RequestParam Map<String,Object> mapApply) {

        String userName = mapApply.get(ControllerConfig.name).toString();
        String password = mapApply.get(ControllerConfig.password).toString();
        UserInfo userinfo = selectuserimp.getSelectForLogin(userName, password);

        Map<String, Object> map = new HashMap<String, Object>();
        if (userinfo == null) {
            map.put(ControllerConfig.result, "0");
            map.put(ControllerConfig.mas, "用户不存在");
            return map; //封装为json返回给客户端
        }
        if ((userinfo.getName().equals(userName)) && (userinfo.getPwd().equals(password))) {
            map.put(ControllerConfig.result, "1");
            map.put(ControllerConfig.data, userinfo);
            return map; //封装为json返回给客户端
        }

        map.put(ControllerConfig.result, "0");
        map.put(ControllerConfig.mas, "密码错误");

        return map; //封装为json返回给客户端
    }


    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> userResgister(@RequestParam Map<String, Object> mapRes) {

        Map<String, Object> map_ = new HashMap<String, Object>();
        UserInfo listmodel = selectuserimp.getSelectForLogin(mapRes.get(ControllerConfig.name).toString(), mapRes
                .get(ControllerConfig.password)
                .toString());
        if (listmodel == null) {

            int bossid = Integer.parseInt(mapRes.get(ControllerConfig.bossid).toString());
            selectuserimp.insertUserForRegist(
                    mapRes.get(ControllerConfig.name).toString(),
                    mapRes.get
                            (ControllerConfig.password).toString(),
                    mapRes.get(ControllerConfig.sex).toString(),
                    mapRes
                            .get(ControllerConfig.age).toString(),
                    mapRes.get(ControllerConfig.idcard).toString(),
                    mapRes.get(ControllerConfig.staffNum).toString(),
                    mapRes.get(ControllerConfig.phone).toString(),
                    mapRes.get(ControllerConfig.department).toString(),
                    mapRes.get(ControllerConfig.post).toString(),
                    mapRes.get(ControllerConfig.headImagePatch).toString(),
                    mapRes.get(ControllerConfig.telephone).toString(),
                    mapRes.get(ControllerConfig.mail).toString(),
                    mapRes.get(ControllerConfig.bossName).toString(),
                    bossid
                    );
            map_.put(ControllerConfig.result, "1");
            return map_;



        } else {
            map_.put(ControllerConfig.result, "0");
            map_.put(ControllerConfig.mas, "该用户已存在");

            return map_;
        }

    }


}
