package controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class login {
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String  login(){
        int i=1;
        i++;
        System.out.println("i="+i);
        return  "hhhhh";
    }

    @RequestMapping(value="/doLogin/{username}/{password}",method=RequestMethod.GET)
    @ResponseBody
     public Map<String, Object> getTeacher(@PathVariable("username") Integer username, @PathVariable("password") Integer
            password){
        System.out.println("拦截了客户端json请求");
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
}
