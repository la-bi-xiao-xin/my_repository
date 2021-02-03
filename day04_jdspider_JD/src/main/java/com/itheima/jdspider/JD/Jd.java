package com.itheima.jdspider.JD;

import com.itheima.jdspider.utils.C3P0Utils;
import com.itheima.jdspider.utils.Item;
import lombok.var;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Jd {
    public static void main(String[] args) throws IOException, SQLException {
        //2.2创建HttpClient对象用于发送请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for (int i = 1; i < 100; i++) {  //循环内为一页数据的爬取过程
            //1.获取查询网页地址
            String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&suggest=1.def.0.V06--38s0&wq=%E6%89%8B%E6%9C%BA&page=" + (2 * i - 1) + "&s=1&click=0";
            //2.发送请求获取数据
            //2.2 创建请求方式对象
            HttpGet httpGet = new HttpGet(url);
            //2.3设置请求头
            httpGet.setHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Mobile Safari/537.36");
            //2.4发送请求,获取响应
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //2.5获取响应行和响应体
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String html = EntityUtils.toString(entity);

                //3.解析html数据
                //3.1创建用于解析的document对象
                Document document = Jsoup.parse(html);
                //3.2传入选择器解析相应内容
                Elements phones = document.select("ul[class=gl-warp clearfix]>li");//获取页面所有手机区对应的元素选择器对象
                //System.out.println(elements.size());  //判断是否拿到相应选择器 -->成功

                for (Element phone : phones) {
                    //3.2.1获取sku  spu
                    String sku = phone.attr("data-sku");
                    String spu = phone.attr("data-spu");
                    if(spu==null || "".equals(spu)){
                        spu=sku;
                    }
                   // if (spu == null || "".equals(spu)) spu = sku;
                    System.out.println(sku + "____" + spu); //判断是否拿到响应值-->成功

                    //3.3.2获取title
                    Elements titleElent = phone.select("div[class=p-name p-name-type-2]>a>em");
                    String title = titleElent.text();
                    //System.out.println(title); //判断是否拿到响应值-->成功

                    //3.3.3获取price
                    Elements priceElent = phone.select(".p-price>strong>i");// 有不懂!   .gl-i-wrap>.p-price>strong>i可以//.gl-i-wrap>.p-price>.J_100012223336>不行
                    String price = priceElent.text();
                    //System.out.println(price);//判断是否拿到响应值-->成功

                    //3.3.4获取商品详情地址
                    Elements adressElent = phone.select(".p-img>a");
                    String adress = "https:" + adressElent.attr("href");
                    // System.out.println(adress);  //判断是否拿到响应值-->成功

                    //3.3.4获取照片并存储到本地文件
                    Elements picUrlElent = phone.select(".p-img>a>img");
                    String picUrl = "http:" + picUrlElent.attr("src");
                    System.out.println(picUrl);
                    HttpGet httpGet1 = new HttpGet(picUrl);
                    CloseableHttpResponse response1 = httpClient.execute(httpGet1);
                    HttpEntity entity1 = response1.getEntity();
                    InputStream inputStream = entity1.getContent();
                    String imgFileName = "F:\\jdpic\\" + UUID.randomUUID().toString() + picUrl.substring(picUrl.lastIndexOf("."));
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(imgFileName));
                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len = inputStream.read(bytes)) != -1) {
                        bufferedOutputStream.write(bytes, 0, len);
                    }
                    inputStream.close();
                    bufferedOutputStream.close();
                    //封装对象

                    Item item = new Item(null,
                            Long.parseLong(spu),
                            Long.parseLong(sku),
                            title,
                            Double.parseDouble(price),
                            imgFileName,
                            adress,
                            new Date().toLocaleString(),
                            new Date().toLocaleString()
                    );
                    //4.存储数据
                    Connection connection = C3P0Utils.getConnection();
                    String sql = "insert into jd_item VALUES (null,?,?,?,?,?,?,?,?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setLong(1, item.getSpu());
                    statement.setLong(2, item.getSku());
                    statement.setString(3, item.getTitle());
                    statement.setDouble(4, item.getPrice());
                    statement.setString(5, item.getPic());
                    statement.setString(6, item.getUrl());
                    statement.setString(7, item.getCreated());
                    statement.setString(8, item.getUpdated());
                    int result = statement.executeUpdate();
                    C3P0Utils.closeAll(null, statement, connection);

                }
                // System.out.println(itemList.size()); //测试是否封装数据对象成功-->成功

            }//获取一页数据结束
            System.out.println(i); //测试是否循环
        }
        httpClient.close();
    }
}
