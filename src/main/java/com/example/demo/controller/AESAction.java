package com.example.demo.controller;

import com.example.demo.util.AESUtils;
import com.example.demo.util.RSA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AESAction { 
    /**
     * AES+RSA 简单加密
     * @return
     */
    @RequestMapping("goActionAes")
    public String goActionAes() {
        return "test/AESRSA";
    }

    @RequestMapping("actionAes")
    public String actionAes(HttpServletRequest request) throws Exception {

        String rsaKey = request.getParameter("rsaKey").replaceAll(" ","+");
        String data = request.getParameter("data").replaceAll(" ","+");
        String rsaIV = request.getParameter("rsaIV").replaceAll(" ","+");
        String key = RSA.decrypt(rsaKey,ConstantPool.privateKey);
        String iv = RSA.decrypt(rsaIV,ConstantPool.privateKey);
        String plainText = AESUtils.decryptData(key, data,iv);
        System.out.println("key="+key);
        System.out.println("iv="+iv);
        System.out.println(plainText);
        return "";
    }

    /**
     * AES 加密
     * @return
     */
    @RequestMapping("goAES")
    public String goAES(){return "test/AES";}

    @RequestMapping("AES")
    public String AES(HttpServletRequest request) {
        String key = request.getParameter("key").replaceAll(" ","+");
        String data = request.getParameter("data").replaceAll(" ","+");
        String iv = request.getParameter("iv").replaceAll(" ","+");
        data = AESUtils.decryptData(key,data,iv);
        System.out.println("加密前数据       :"+data);
        return "";
    }
}
