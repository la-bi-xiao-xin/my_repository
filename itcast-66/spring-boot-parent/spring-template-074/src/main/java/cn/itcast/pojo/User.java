package cn.itcast.pojo;

import lombok.Data;

@Data  //注解  lombo注解用于创建set get toString 等实体类通用方法
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
}
