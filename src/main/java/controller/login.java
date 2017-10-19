package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.serviceimp.SelectUserImp;

@Controller
public class login {

    /**
     *
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

    @RequestMapping(value="/doLogin/{username}/{password}",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
     public Map<String, Object> getTeacher(@PathVariable("username") Integer username, @PathVariable("password") Integer
            password){
        System.out.println("拦截了客户端json请求");


        List<UserInfo> userList =  selectuserimp.getSelectUser();



        Map<String, Object> map = new HashMap<String, Object>();

        if((username == 111)&&(password == 111)){
            System.out.println("密码正确");
            map.put("result", "1");
            return map; //封装为json返回给客户端
        }

        System.out.println("密码错误");
        map.put("result", "0");
        return map; //封装为json返回给客户端
    }

    @RequestMapping(value = "/register",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object>userResgister(@RequestParam(value = "iphone")String iphone,
    @RequestParam(value = "map")Map<String, Object> model)
    {
        System.out.println(iphone);
        return null;
    }




}
