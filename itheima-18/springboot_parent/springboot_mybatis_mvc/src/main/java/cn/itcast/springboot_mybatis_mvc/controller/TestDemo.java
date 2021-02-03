package cn.itcast.springboot_mybatis_mvc.controller;

import cn.itcast.springboot_mybatis_mvc.entity.ActivityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test-demo")
public class TestDemo {


    @GetMapping("return_test")
    public List<ActivityEntity> return_test(){
        ArrayList<ActivityEntity> ac_list = new ArrayList<>();
        for (int i = 1; i <=5 ; i++) {
            ActivityEntity activityEntity = new ActivityEntity();
            activityEntity.setPlayer_id(i);
            activityEntity.setDevice_id(i+100);
            activityEntity.setEvent_date(new Date(System.currentTimeMillis()));
            activityEntity.setGames_played(i+1000);
            ac_list.add(activityEntity);
        }
        return ac_list;
    }
}
