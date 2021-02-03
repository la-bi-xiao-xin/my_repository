package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {
    /**
     * 主键id
     */

    private Long id;

    /**
     * 商品集合id
     */

    private Long spu;
    /**
     * 商品最小品类单元id
     */

    private Long sku;
    /**
     * 商品标题
     */

    private String title;
    /**
     * 商品价格
     */

    private Object price;

    /**
     * 商品图片
     */

    private String pic;

    /**
     * 商品详情地址
     */

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
