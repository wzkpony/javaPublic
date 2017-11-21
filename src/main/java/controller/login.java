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

    /**
     *登录
     */
    @Resource(name = "selectUserid")
    private SelectUserImp selectuserimp;
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String  login(){
        int i=1;
        i++;
        System.out.println("i="+i);
        return  "hhhhh";
    }
    /**
     *检测用户是否存在
     */
    @RequestMapping(value="/doLogin/{username}/{password}",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
     public Map<String, Object> getTeacher(@PathVariable("username") String username, @PathVariable("password") String
            password){
        System.out.println("拦截了客户端json请求");

        UserInfo userinfo =  selectuserimp.getSelectForLogin(username,password);

        Map<String, Object> map = new HashMap<String, Object>();
        if (userinfo == null)
        {
            map.put("result", "2");
            map.put("mas", "用户不存在");
            return map; //封装为json返回给客户端
        }
        if((userinfo.getName().equals(username))&&(userinfo.getPwd().equals(password))){
            System.out.println("密码正确");
            map.put("result", "1");
            map.put("date","userinfo");
            return map; //封装为json返回给客户端
        }

        System.out.println("密码错误");
        map.put("result", "0");
        map.put("mas", "密码错误");

        return map; //封装为json返回给客户端
    }




    /**
     *注册
     */
    @RequestMapping(value = "/register",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> userResgister(@RequestParam Map<String,Object>mapRes)
    {

        Map<String, Object> map_ = new HashMap<String, Object>();
        UserInfo listmodel = selectuserimp.getSelectForLogin(mapRes.get("name").toString(),mapRes.get("pwd").toString());
        if (listmodel == null)
        {
            selectuserimp.insertUserForRegist(mapRes.get("name").toString(),mapRes.get("pwd").toString(),mapRes.get("sex").toString(),mapRes.get("age").toString(),
                    mapRes.get("idcard").toString());
            map_.put("result","1");
            return map_;
        }
        else
        {
            map_.put("result","2");
            map_.put("mas","该用户已存在");

            return map_;
        }

    }






}
