package www.lvchehui.com.carteam.entity;

/**
 * Created by 张灿能 on 2016/8/25.
 * 作用：
 */
public class IdentitySubmitEntity {
    public int add_time;
    public int update_time;
    public String ver;
    public String phone;
    public Object phone_backup;
    public String true_name;
    public String idcard_url;
    public String idcard_number;
    public String users_gid;
    public int check_status;
    public int identity_type;
    public String identity_account;
    public String check_reason;
    public String identity_gid;

    @Override
    public String toString() {
        return "IdentitySubmitEntity{" +
                "add_time=" + add_time +
                ", update_time=" + update_time +
                ", ver='" + ver + '\'' +
                ", phone='" + phone + '\'' +
                ", phone_backup=" + phone_backup +
                ", true_name='" + true_name + '\'' +
                ", idcard_url='" + idcard_url + '\'' +
                ", idcard_number='" + idcard_number + '\'' +
                ", users_gid='" + users_gid + '\'' +
                ", check_status=" + check_status +
                ", identity_type=" + identity_type +
                ", identity_account='" + identity_account + '\'' +
                ", check_reason='" + check_reason + '\'' +
                ", identity_gid='" + identity_gid + '\'' +
                '}';
    }
}
