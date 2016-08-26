package www.lvchehui.com.carteam.entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by 张灿能 on 2016/8/25.
 * 作用：
 */
@Table(name = "IdentitySubmitEntity")
public class IdentitySubmitEntity {
    @Column(name = "add_time")
    public int add_time;
    @Column(name = "update_time")
    public int update_time;
    @Column(name = "ver")
    public String ver;
    @Column(name = "phone")
    public String phone;
    @Column(name = "phone_backup")
    public Object phone_backup;
    @Column(name = "true_name")
    public String true_name;
    @Column(name = "idcard_url")
    public String idcard_url;
    @Column(name = "idcard_number")
    public String idcard_number;
    @Column(name = "users_gid")
    public String users_gid;
    @Column(name = "check_status")
    public int check_status;
    @Column(name = "identity_type")
    public int identity_type;
    @Column(name = "identity_account")
    public String identity_account;
    @Column(name = "check_reason")
    public String check_reason;
    @Column(name = "identity_gid")
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
