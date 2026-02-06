package com.example.travelsite.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //404エラー(存在しないID)
    @ExceptionHandler(OnsenNotFoundException.class)
    public String handle404(OnsenNotFoundException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error/404";
    }

    //500(その他の予期せないエラー)
    @ExceptionHandler(Exception.class)
    public String handle500(Model model) {
        model.addAttribute("errorMessage", "予期せぬエラーが発生しました");
        return "error/500";
    }
}
