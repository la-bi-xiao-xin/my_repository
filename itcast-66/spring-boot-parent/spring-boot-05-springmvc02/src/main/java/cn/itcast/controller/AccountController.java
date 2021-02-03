package cn.itcast.controller;

import cn.itcast.pojo.Account;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@RestController
@RequestMapping("account")
public class AccountController {
@GetMapping("show01")
    public String show01(String uid,String username,Boolean isVIP){

        String str = new Date().toLocaleString() + " ===== uid=" + uid
                + ", username=" + username + ", isVIP=" + isVIP;
        return str;

    }
@GetMapping("/show03/{out}/{in}/{money}")
    public String show02(@PathVariable("out") String outAccount, @PathVariable("in")String inAccount,@PathVariable("money") Double money){

        String str = new Date().toLocaleString() + " ===== outAccount=" + outAccount
                + ", inAccount=" + inAccount+ ", money=" + money;
        return str;

    }
    // 需求4: 直接形参声明pojo即可接收
    @RequestMapping("show04")
    public String show04(Account account) {
        String str = new Date().toLocaleString() + " ===== 功能4 : " + account;
        return str;
    }

}
