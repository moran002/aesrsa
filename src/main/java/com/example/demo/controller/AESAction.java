package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.AESUtils;
import com.example.demo.util.RSA;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AESAction {
    /**
     * AES+RSA 简单加密
     *
     * @return
     */
    @RequestMapping("goActionAes")
    public String goActionAes() {
        return "test/AESRSA";
    }

    @RequestMapping("actionAes")
    public String actionAes(HttpServletRequest request) throws Exception {
        String rsaKey = request.getParameter("rsaKey");
        String data = request.getParameter("data");
        String rsaIV = request.getParameter("rsaIV");
        if (StringUtils.isEmpty(rsaKey) ||StringUtils.isEmpty(data) ||StringUtils.isEmpty(rsaIV)) {
            return "";
        }
        String key = RSA.decrypt(rsaKey, ConstantPool.privateKey);
        String iv = RSA.decrypt(rsaIV, ConstantPool.privateKey);
        String plainText = AESUtils.decryptData(key, data, iv);
        request.setAttribute("data", plainText);
        request.setAttribute("key", key);
        request.setAttribute("rsaKey", rsaKey);
        request.setAttribute("iv", iv);
        request.setAttribute("rsaIV", rsaIV);
        return "test/AESRSA";
    }

    /**
     * AES 加密
     *
     * @return
     */
    @RequestMapping("goAES")
    public String goAES() {
        return "test/AES";
    }

    @RequestMapping("AES")
    public String AES(HttpServletRequest request) {
        String key = request.getParameter("key").replaceAll(" ", "+");
        String data = request.getParameter("data").replaceAll(" ", "+");
        String iv = request.getParameter("iv").replaceAll(" ", "+");
        data = AESUtils.decryptData(key, data, iv);
        System.out.println("加密前数据       :" + data);
        request.setAttribute("data", data);
        request.setAttribute("key", key);
        request.setAttribute("iv", iv);
        return "test/AES";
    }

    /**
     * 加密
     *
     * @param request
     * @return
     */
    @RequestMapping("goEncryption")
    public String goEncryption(HttpServletRequest request) {
        String rsaKey = null;
        String rsaIV = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userid", "xiyang");
        jsonObject.put("password", "password");
        String data = JSON.toJSONString(jsonObject);
        String key = AESUtils.generateKey();
        String iv = AESUtils.generateKey();
        String aesData = AESUtils.encryptData(key, data, iv);
        try {
            rsaKey = RSA.encrypt(key, ConstantPool.publicKey);
            rsaIV = RSA.encrypt(iv, ConstantPool.publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("rsaKey",rsaKey);
        request.setAttribute("rsaIV",rsaIV);
        request.setAttribute("aesData",aesData);
        return "/test/decrypt";
    }

}
