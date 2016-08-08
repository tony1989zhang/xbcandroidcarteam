package www.lvchehui.com.carteam.evebus;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：上传证件id 与 照片链接的
 */
public class UploadIdPtEvent {
    private String idNum;
    private String idCardPt;

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getIdCardPt() {
        return idCardPt;
    }

    public void setIdCardPt(String idCardPt) {
        this.idCardPt = idCardPt;
    }
}
