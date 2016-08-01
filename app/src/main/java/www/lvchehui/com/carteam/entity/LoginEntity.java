package www.lvchehui.com.carteam.entity;

/**
 * 作者：V先生 on 2016/8/1 17:16
 * 作用：登录的bean
 */
public class LoginEntity {
    private String gid;
    private String username;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ResDataBean{" +
                "gid='" + gid + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
