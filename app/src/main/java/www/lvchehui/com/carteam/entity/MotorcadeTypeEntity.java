package www.lvchehui.com.carteam.entity;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：
 */
public class MotorcadeTypeEntity {
    private String MotorcadeTypeName;
    private String MotorcadeTypeDes;
    private int type;

    public MotorcadeTypeEntity(String motorcadeTypeName, String motorcadeTypeDes) {
        MotorcadeTypeName = motorcadeTypeName;
        MotorcadeTypeDes = motorcadeTypeDes;
    }

    public String getMotorcadeTypeName() {
        return MotorcadeTypeName;
    }

    public String getMotorcadeTypeDes() {
        return MotorcadeTypeDes;
    }
}
