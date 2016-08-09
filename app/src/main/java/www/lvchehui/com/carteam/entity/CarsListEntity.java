package www.lvchehui.com.carteam.entity;

import java.util.List;

/**
 * Created by 张灿能 on 2016/8/9.
 * 作用：
 */
public class CarsListEntity {
    public String cars_gid;
    public String plate_number;
    public String vehicle_model;
    public String vehicle_color;
    public int seat_number_just;
    public int seat_number_sum_as;
    public int registration_first;
    public int passanger_premium;
    public String passanger_premium_url;
    public String drive_licence_number;
    public String drive_licence_url;
    public String road_transport_number;
    public String road_transport_url;
    public int manage_scope;
    public CarPhotosUrlBean car_photos_url;
    public String car_describe;
    public String motorcade_gid;
    public int check_status;
    public Object check_reason;
    public int runing_status;

    public static class CarPhotosUrlBean {
        public List<String> in;
        public List<String> out;
    }
}
