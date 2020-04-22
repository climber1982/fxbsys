package com.fxb.com.fxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GotoController {
    @RequestMapping("gotoindex")
    public  String gotoIndex(){
        return "index";
    }

    @RequestMapping("gotoTravelList")
    public String gotoTravelList(){
        return "travelList";
    }

   @RequestMapping("gotoUpate/{id}")
    public ModelAndView gotoUpate(@PathVariable String id){
        ModelAndView mv=new ModelAndView("/page/addTravel");
        return mv;
    }
   @RequestMapping("gotoAddUser/{id}")
    public ModelAndView gotoAddUser(@PathVariable String id){
        ModelAndView mv=new ModelAndView("userList");
        mv.addObject("trid",id);
        return  mv;
    }
    @RequestMapping("gotoLogin")
    public String gotoLogin(){
        return "login";
    }
}
