package cn.itcast.controller;


import cn.itcast.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloword")
public class HelloController {
    @Autowired
    private ActionService actionService;

    //@Autowired
   // private PersionConfig persionConfig;
    @GetMapping("hello")
    public String hello() {
        actionService.say();

        return "提前还款总计需要换:"+actionService.getowemoney()+"</br>"+"按期还款总计:24459.23"+"</br>"+"差额:"+(actionService.getowemoney()-24459.23);
    }

}
