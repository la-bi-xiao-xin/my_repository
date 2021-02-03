package cn.itcast;

import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTemplate07ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RestTemplate restTemplate;
@Test
    public void findAll(){
   String url="http://localhost:8011/user/findAll";
    User[] userArr = restTemplate.getForObject(url, User[].class);
    List<User> userList = Arrays.asList(userArr);
    for (User user : userList) {
        System.out.println("**********");
        System.out.println(user);
    }
}
@Test
    public void findById(){
    String url="http://localhost:8011/user/findById/2";
    User user = restTemplate.getForObject(url, User.class);
    System.out.println("**********");
    System.out.println(user);

}
}
