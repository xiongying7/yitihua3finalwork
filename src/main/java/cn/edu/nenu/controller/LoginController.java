package cn.edu.nenu.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;

@CommonsLog
@Controller
//@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "login";
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String homepageForm() {
        return "homepage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("username")&&password.equals("password")){
            return "homepage";
        }
        else if(username.equals("admin")&&password.equals("admin")){
            return "user/list";
        }
        else {
            return "login";
        }
    }



//    @RequestMapping(value = "/index",method = RequestMethod.GET)
//    public String index(){
//        String url = "http://localhost:8080/index";
//        String url1 = "http://localhost:8080/login/index";
//        log.info(url);
//        return "index";
//    }



//    //@RequestMapping(value = "/login",method = RequestMethod.GET)
//    @GetMapping("/login/{id}")
//    public String loginForm(@PathVariable("id")Integer id){
//        log.info("login?method=get");
//        log.info(id);
//        return "login";
//    }
//
//    //@RequestMapping(value = "/login",method = RequestMethod.POST)
//    @PostMapping("/login")
//    public String login(@RequestParam(value = "username") String username,
//                        @RequestParam(value = "password") String password,
//                        Model model){
//        log.info("login?method=post");
//        //String username = request.getParameter("username");
//        log.info(username);
//        //log.info(json);
//        model.addAttribute("username",username);
//
//        //User user = new User();
//        //user.setName("admin");
//
//
//        if ("admin".equals(username)&&"123".equals(password)){
//            return "loginsuccess";
//        }else{
//            //return "loginfail";
//            return "user/userForm";
//            //web-inf/views/+ return 字符串 + .jsp
//        }
//
//    }
//
//    //public ModelAndView login(ServletRequest request){
//    //    String username = request.getParameter("username");
//    //    ModelAndView mv = new ModelAndView("loginsuccess");
//    //    mv.addObject("username",username);
//    //    return mv;
//    //}
}
