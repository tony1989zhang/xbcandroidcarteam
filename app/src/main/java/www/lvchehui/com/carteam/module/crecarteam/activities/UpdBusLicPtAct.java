package www.lvchehui.com.carteam.module.crecarteam.activities;

import www.lvchehui.com.carteam.activities.UploadIdPtAct;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：上传营业执照
 */
public class UpdBusLicPtAct extends UploadIdPtAct {
    @Override
    public void initView() {
        super.initView();
        //获取数据库进行查询操作。
        initTextView("上传营业执照", "统一社会信用代码", "上传营业执照图片", "请在营业执照复印件上，按如下要求完成并拍照上传。\n" +
                "注：手写“仅用于享包车认证”，并在复印件上加盖红色公章。", "http://www.51pla.com/UploadPic/2011/11/12/20111112111827679974.jpg");
        //uploadType = UpdBusLicPtAct.class.getSimpleName();
    }
}
