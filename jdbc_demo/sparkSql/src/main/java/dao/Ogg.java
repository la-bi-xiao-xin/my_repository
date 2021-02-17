package dao;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class Ogg {

    /**
     * table : ITCAST.tbl_route
     * op_type : U
     * op_ts : 2020-10-08 09:10:54.000774
     * current_ts : 2020-10-08T09:11:01.925000
     * pos : 00000000200006645758
     * before : {"id":104,"start_station":"东莞中心","start_station_area_id":441900,"start_warehouse_id":1,"end_station":"蚌埠中转部","end_station_area_id":340300,"end_warehouse_id":107,"mileage_m":1369046,"time_consumer_minute":56172,"state":1,"cdt":"2020-02-02 18:51:39","udt":"2020-02-02 18:51:39","remark":null}
     * after : {"id":104,"start_station":"东莞中心","start_station_area_id":441900,"start_warehouse_id":1,"end_station":"TBD","end_station_area_id":340300,"end_warehouse_id":107,"mileage_m":1369046,"time_consumer_minute":56172,"state":1,"cdt":"2020-02-02 18:51:39","udt":"2020-02-02 18:51:39","remark":null}
     */

    private String table;
    private String op_type;
    private String op_ts;
    private String current_ts;
    private String pos;
    private BeforeBean before;
    private AfterBean after;

    @Data
    public static class BeforeBean {
        /**
         * id : 104
         * start_station : 东莞中心
         * start_station_area_id : 441900
         * start_warehouse_id : 1
         * end_station : 蚌埠中转部
         * end_station_area_id : 340300
         * end_warehouse_id : 107
         * mileage_m : 1369046
         * time_consumer_minute : 56172
         * state : 1
         * cdt : 2020-02-02 18:51:39
         * udt : 2020-02-02 18:51:39
         * remark : null
         */

        private int id;
        private String start_station;
        private int start_station_area_id;
        private int start_warehouse_id;
        private String end_station;
        private int end_station_area_id;
        private int end_warehouse_id;
        private int mileage_m;
        private int time_consumer_minute;
        private int state;
        private String cdt;
        private String udt;
        private Object remark;
    }

    @Data
    public static class AfterBean {
        /**
         * id : 104
         * start_station : 东莞中心
         * start_station_area_id : 441900
         * start_warehouse_id : 1
         * end_station : TBD
         * end_station_area_id : 340300
         * end_warehouse_id : 107
         * mileage_m : 1369046
         * time_consumer_minute : 56172
         * state : 1
         * cdt : 2020-02-02 18:51:39
         * udt : 2020-02-02 18:51:39
         * remark : null
         */

        private int id;
        private String start_station;
        private int start_station_area_id;
        private int start_warehouse_id;
        private String end_station;
        private int end_station_area_id;
        private int end_warehouse_id;
        private int mileage_m;
        private int time_consumer_minute;
        private int state;
        private String cdt;
        private String udt;
        private Object remark;

    }
}
