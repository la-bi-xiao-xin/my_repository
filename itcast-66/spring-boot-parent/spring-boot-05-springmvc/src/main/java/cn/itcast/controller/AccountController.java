package cn.itcast.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
@RestController
@RequestMapping("account")
public class AccountController {
@GetMapping("show01")
    public String show01(Integer uid,
                         String username,
                         Boolean isVIP) {
        String str = new Date().toLocaleString() + " ===== uid=" + uid
                + ", username=" + username + ", isVIP=" + isVIP;
        return str;
    }

    @PostMapping("show02")
    public String show2(@RequestParam("id") Integer uid,
                        @RequestParam("uname")String username,
                        @RequestParam("isVIP")Boolean isVIP){

        String str = new Date().toLocaleString() + " ===== uid=" + uid
                + ", username=" + username + ", isVIP=" + isVIP;
        return str;

    }

//    <a href="/account/show03/张三/李四/1000">测试</a>
    @RequestMapping("/show03/{out}/{in}/{money}")
    public String show3(@PathVariable("out") String outAccount,
                        @PathVariable("in") String inAccount,
                        @PathVariable("money") Double money
    ){
        String str = new Date().toLocaleString() + " ===== 执行转账业务 出账人: " + outAccount + ", 入账人: " + inAccount + ", 转账金额: " + money;
        return str;

    }
@GetMapping("show08")
    public String show08(@RequestHeader("User-Agent") String UserAgent){

    return "请求头信息:"+UserAgent;

    }
}



