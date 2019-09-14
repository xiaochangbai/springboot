package cn.xdd.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xchb
 * @version 1.0
 * @ClassName UserHandleIntercept
 * @description 用户登陆拦截器
 * @createTime 2019年09月13日 21:30
 */
public class UserHandleIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginUserEmail= (String)request.getSession().getAttribute("loginUserEmail");
        if(loginUserEmail==null){
            //session中没有用户登陆邮箱号，表示当前用户没有登陆
            //拦截并跳转到登陆页
            request.setAttribute("msg","没有访问权限，请先登陆");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else {
            //放行
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
