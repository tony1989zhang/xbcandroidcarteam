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

        @Override
        public String toString() {
            return "CarPhotosUrlBean{" +
                    "in=" + in +
                    ", out=" + out +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CarsListEntity{" +
                "cars_gid='" + cars_gid + '\'' +
                ", plate_number='" + plate_number + '\'' +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", vehicle_color='" + vehicle_color + '\'' +
                ", seat_number_just=" + seat_number_just +
                ", seat_number_sum_as=" + seat_number_sum_as +
                ", registration_first=" + registration_first +
                ", passanger_premium=" + passanger_premium +
                ", passanger_premium_url='" + passanger_premium_url + '\'' +
                ", drive_licence_number='" + drive_licence_number + '\'' +
                ", drive_licence_url='" + drive_licence_url + '\'' +
                ", road_transport_number='" + road_transport_number + '\'' +
                ", road_transport_url='" + road_transport_url + '\'' +
                ", manage_scope=" + manage_scope +
                ", car_photos_url=" + car_photos_url +
                ", car_describe='" + car_describe + '\'' +
                ", motorcade_gid='" + motorcade_gid + '\'' +
                ", check_status=" + check_status +
                ", check_reason=" + check_reason +
                ", runing_status=" + runing_status +
                '}';
    }
}
