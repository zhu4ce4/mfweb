package com.lqj.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
//        ModelAndView mav = new ModelAndView("errorPage");
//        mav.addObject("exception", e);
//        mav.addObject("url", request.getRequestURL());
//        return mav;
//    }
//}
