package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "jd-item",type = "jd-item")
public class Item {
    /**
     * 主键id
     */
    @Id // springdata es 注解
    private Long id;

    /**
     * 商品集合id
     */
    @Field(index = false, store = true, type = FieldType.Long) // springdata es 注解
    private Long spu;
    /**
     * 商品最小品类单元id
     */
    @Field(index = false, store = true, type = FieldType.Long)
    private Long sku;
    /**
     * 商品标题
     */
    @Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.Text)
    private String title;
    /**
     * 商品价格
     */
    @Field(index = false, store = true, type = FieldType.Double)
    private Object price;

    /**
     * 商品图片
     */
    @Field(index = false, store = true, type = FieldType.Text)
    private String pic;

    /**
     * 商品详情地址
     */
    @Field(index = false, store = true, type = FieldType.Text)
    private String url;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

}
