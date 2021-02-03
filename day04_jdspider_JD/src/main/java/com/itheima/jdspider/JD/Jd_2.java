package com.itheima.jdspider.JD;

import com.itheima.jdspider.utils.C3P0Utils;
import com.itheima.jdspider.utils.Item;
import lombok.SneakyThrows;
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
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//每次同时爬取5个页面 间隔1分钟以后, 爬取下一个5个页面, 直到将100页全部爬取
public class Jd_2 {
    public static void main(String[] args) throws IOException, SQLException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //1.创建一个容器存储100页url,选用线程安全的列表集合
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(100);
        for (int i = 1; i <= 100; i++) {
            String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&page=" + (2 * i - 1) + "&click=0";
            arrayBlockingQueue.offer(url);
        }
        System.out.println(arrayBlockingQueue.size());

        //2.创建多线程执行获取响应,解析,存储的过程;考虑使用线程池,避免频繁创建关闭线程,节约资源提升执行效率
        //2.1创建线程池
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        for (int i = 0; i <1 ; i++) {
            scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("获取html完成");
                        String html = getHtml((String) arrayBlockingQueue.poll(), httpClient);  //1.调用方法获取响应体html
                        System.out.println("获取html完成");
                        Item item = getItem(html, httpClient);   //2.调用方法获取查询结果item对象
                        System.out.println("解析完成");
                        saveData(item);
                        System.out.println("存储完成");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            },0,6, TimeUnit.SECONDS);
            System.out.println(i);
        }
        // httpClient.close();//释放资源
    }

    private static void saveData(Item item) throws SQLException {
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


    public static String getHtml(String url, CloseableHttpClient httpClient) throws IOException {


        //2.发送请求获取数据
        //2.2 创建请求方式对象
        HttpGet httpGet = new HttpGet(url);
        System.out.println(22222);
        //2.3设置请求头
        httpGet.setHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Mobile Safari/537.36");
        System.out.println(33333);
        //2.4发送请求,获取响应
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println(44444);
        //2.5获取响应行和响应体
        String html = null;
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            html = EntityUtils.toString(entity);
        }
        System.out.println(55555);
        return html;
    }

    public static Item getItem(String html, CloseableHttpClient httpClient) throws IOException {
        //3.解析html数据
        //3.1创建用于解析的document对象
        Document document = Jsoup.parse(html);
        //3.2传入选择器解析相应内容
        Elements phones = document.select("ul[class=gl-warp clearfix]>li");//获取页面所有手机区对应的元素选择器对象
        //System.out.println(elements.size());  //判断是否拿到相应选择器 -->成功
        Item item = null;
        for (Element phone : phones) {
            //3.2.1获取sku  spu
            String sku = phone.attr("data-sku");
            String spu = phone.attr("data-spu");
            if(spu==null || "".equals(spu)){
                spu=sku;
            }
            // System.out.println(sku+"____"+spu); //判断是否拿到响应值-->成功

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
            System.out.println(adress);  //判断是否拿到响应值-->成功

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
            item = new Item(null,
                    Long.parseLong(spu),
                    Long.parseLong(sku),
                    title,
                    Double.parseDouble(price),
                    imgFileName,
                    adress,
                    new Date().toLocaleString(),
                    new Date().toLocaleString()
            );

        }
        return item;
    }
}
