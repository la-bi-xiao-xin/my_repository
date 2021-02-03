package cn.itcast.springboot_mybatis_mvc.entity;


import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Data


public class ActivityEntity {
    private Integer player_id;
    private Integer device_id;
    private Date event_date;
    private Integer games_played;

}
