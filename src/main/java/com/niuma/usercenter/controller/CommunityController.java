package com.niuma.usercenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community")
@Slf4j
public class CommunityController {

    @GetMapping("/listBlock")
    public void listBlock() {

    }

}
