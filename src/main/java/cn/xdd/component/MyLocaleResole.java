package cn.xdd.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author xchb
 * @version 1.0
 * @ClassName MyLocaleResole
 * @description 自定义区域信息解析器
 * @createTime 2019年09月13日 00:05
 *
 */
public class MyLocaleResole implements LocaleResolver {
    private final static int LANGUAGE_CONTRY_LENGTH=2;
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中所带的语言地区信息
        String languageCountry=request.getParameter("l");
        Locale locale=null;
        //请求中携带区域语言信息参数
        if(!StringUtils.isEmpty(languageCountry)){
            String[] str=languageCountry.split("_");
            if(str.length>=LANGUAGE_CONTRY_LENGTH){
                locale=new Locale(str[0],str[1]);
            }
        }else {
            //请求中没有携带区域语言信息参数，使用请求头中的区域信息（根据浏览器语言来设置的）
            locale=request.getLocale();
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}