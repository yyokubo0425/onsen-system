package com.example.travelsite.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, Model model){

        //セッションからloginErrorを取得
        HttpSession session = request.getSession(false);
        if(session != null){
            Object error = session.getAttribute("loginError");
            if(error != null){
                model.addAttribute("loginError", error.toString());
            }
            //画面を開いた時点で削除
            session.removeAttribute("loginError");
        }
        return "security/login";
    }

    @GetMapping("/error/403")
    public String error403(){
        return "error/403";
    }
}
