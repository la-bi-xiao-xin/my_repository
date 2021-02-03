package cn.itcast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        //System.out.println("完美世界,故乡原风景,最后的莫西干人,蓝蓝的夜蓝蓝的梦,寂静之声,秋日私语,Caravan-a_hisa,森林狂想曲");
        String song = "完美世界,故乡原风景,最后的莫西干人,蓝蓝的夜蓝蓝的梦,寂静之声,秋日私语,Caravan-a_hisa,森林狂想曲";
        return "hello spring boot! 今日推荐:" +song;
    }
}
