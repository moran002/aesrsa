package com.example.demo.controller;

import com.example.demo.util.RSA;

import java.util.Map;

public class GeneratorRSAKey {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = RSA.generateKeyPair();
        System.out.println("publicKey   :"+map.get("publicKey"));
        System.out.println("privateKey   :"+map.get("privateKey"));
    }
}
