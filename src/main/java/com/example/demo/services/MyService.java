package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void simpleMethod() {
        System.out.println("Executing simpleMethod");
    }

    @org.springframework.web.bind.annotation.ResponseBody
    public String methodWithResponseBody() {
        System.out.println("Executing methodWithResponseBody");
        return "Response from methodWithResponseBody";
    }

    public void methodWithException(String input) {
        System.out.println("Executing methodWithException with input: " + input);
        throw new RuntimeException("Exception from methodWithException");
    }
}


