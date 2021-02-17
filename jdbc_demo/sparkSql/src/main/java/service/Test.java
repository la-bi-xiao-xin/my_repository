package service;

import com.google.gson.Gson;
import dao.Ogg;

public class Test {
    public static void main(String[] args) {
        String ogg = "\n" +
                "{\n" +
                "  \t\"table\": \"ITCAST.tbl_route\",\n" +
                "  \t\"op_type\": \"U\",\t\n" +
                "  \t\"op_ts\": \"2020-10-08 09:10:54.000774\",\n" +
                "  \t\"current_ts\": \"2020-10-08T09:11:01.925000\",\n" +
                "  \t\"pos\": \"00000000200006645758\",\n" +
                "  \t\"before\": {\t\t\t\t\t\t\t\t\t\n" +
                "  \t\t\"id\": 104,\n" +
                "  \t\t\"start_station\": \"东莞中心\",\n" +
                "  \t\t\"start_station_area_id\": 441900,\n" +
                "  \t\t\"start_warehouse_id\": 1,\n" +
                "  \t\t\"end_station\": \"蚌埠中转部\",\n" +
                "  \t\t\"end_station_area_id\": 340300,\n" +
                "  \t\t\"end_warehouse_id\": 107,\n" +
                "  \t\t\"mileage_m\": 1369046,\n" +
                "  \t\t\"time_consumer_minute\": 56172,\n" +
                "  \t\t\"state\": 1,\n" +
                "  \t\t\"cdt\": \"2020-02-02 18:51:39\",\n" +
                "  \t\t\"udt\": \"2020-02-02 18:51:39\",\n" +
                "  \t\t\"remark\": null\n" +
                "         },\n" +
                "  \t\"after\": {\t\t\t\t\t\t\t\t\t\n" +
                "  \t\t\"id\": 104,\n" +
                "  \t\t\"start_station\": \"东莞中心\",\n" +
                "  \t\t\"start_station_area_id\": 441900,\n" +
                "  \t\t\"start_warehouse_id\": 1,\n" +
                "  \t\t\"end_station\": \"TBD\",\n" +
                "  \t\t\"end_station_area_id\": 340300,\n" +
                "  \t\t\"end_warehouse_id\": 107,\n" +
                "  \t\t\"mileage_m\": 1369046,\n" +
                "  \t\t\"time_consumer_minute\": 56172,\n" +
                "  \t\t\"state\": 1,\n" +
                "  \t\t\"cdt\": \"2020-02-02 18:51:39\",\n" +
                "  \t\t\"udt\": \"2020-02-02 18:51:39\",\n" +
                "  \t\t\"remark\": null\n" +
                "     }\n" +
                "  }";


        Gson gson = new Gson();
        Ogg ogg1 = gson.fromJson(ogg, Ogg.class);
        Ogg.BeforeBean before = ogg1.getBefore();
        String cdt = before.getCdt();
        System.out.println(cdt);

    }
}
