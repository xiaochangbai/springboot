package cn.xdd.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.Date;

/**
 * 全局拦截器
 * @author xchb
 * @version 1.0
 * @ClassName OverallIntecept
 * @description null
 * @createTime 2019年09月11日 19:45
 */

public class OverallIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path=request.getServletPath();
        String interceptPath="/date";
        String content="<h1 style=\"color:{0}\">{1}</h1>";
        if(interceptPath.equals(path)){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(MessageFormat.format(content,"green",new Date()));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("拦截器："+this.getClass().getSimpleName()+"."+"postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("拦截器："+this.getClass().getSimpleName()+"."+"afterCompletion");
    }

}
