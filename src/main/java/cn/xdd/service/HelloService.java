package cn.xdd.service;

import java.util.Date;

/**
 * @author xchb
 * @version 1.0
 * @ClassName HelloService
 * @description null
 * @createTime 2019年09月07日 22:44
 */
public class HelloService {

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"\n"+new Date().toString().toUpperCase();
    }
}
