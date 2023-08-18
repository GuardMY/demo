package com.example.demo.controller;

import com.example.demo.service.DemoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/demoController")
@RestController
@ApiResponse
public class DemoController {
    @Resource
    DemoService demoService;

    @RequestMapping(method = RequestMethod.GET, value = "/writeMessage")
    public String writeMessage(@RequestParam String name, @RequestParam String message) {
        if (demoService.writeMessage(name, message)) {
            return "Success!";
        } else {
            return "Failed!";
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getMessage/{name}")
    public String listMessageByName(@PathVariable String name) {
        List<String> messageList = demoService.listMessageByName(name);
        if (messageList.isEmpty()) {
            return name + " hasn't written any message yet!";
        } else {
            StringBuilder messageBuilder = new StringBuilder();
            messageBuilder.append(name).append(" :").append(System.lineSeparator());
            for (String message : messageList) {
                messageBuilder.append(message).append(System.lineSeparator());
            }
            return messageBuilder.toString();
        }
    }
}
