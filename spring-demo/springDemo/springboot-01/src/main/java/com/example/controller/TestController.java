package com.example.controller;

import com.kk.paystarter.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kk.kylinstarter.KylinService;

/**
 * 测试自定义starter
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 11:55:00
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    public KylinService kylinService;

    @GetMapping
    public String getStarterValue(){
        return "name="+kylinService.getKylinProperties().toString();
    }



    @GetMapping("/pay")
    public String getPayService(){
        return "payService="+PayService.getPayProperties().toString();
    }
}
