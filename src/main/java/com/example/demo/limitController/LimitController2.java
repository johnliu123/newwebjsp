package com.example.demo.limitController;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aop.Limit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/limit2")
@RestController
public class LimitController2 {

	@GetMapping("/test2")
    @Limit(key = "limit2", permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "当前排队人数较多，请稍后再试！")
    public String limit2() {
        log.info("令牌桶limit2获取令牌成功");
        return "请求成功";
    }


    @GetMapping("/test3")
    @Limit(key = "limit3", permitsPerSecond = 2, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "系统繁忙，请稍后再试！")
    public String limit3() {
        log.info("令牌桶limit3获取令牌成功");
        return "请求成功";
    }
}
