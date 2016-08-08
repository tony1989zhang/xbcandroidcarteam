package www.lvchehui.com.carteam.module.crecarteam.activities;

import www.lvchehui.com.carteam.activities.UploadIdPtAct;
import www.lvchehui.com.carteam.tools.XgoLog;

/**
 * Created by 张灿能 on 2016/8/8.
 * 作用：上传道路许可证
 */
public class UpdRoadPtPtAct extends UploadIdPtAct {
    @Override
    protected void initView() {
        super.initView();
        XgoLog.e("initView:");
        //获取数据库进行查询操作。
        initTextView("上传道路经营许可证", "道路经营许可证号", "上传道路经营许可证图片", "请在道路经营许可证复印件上，按如下要求完成并拍照上传。注：手写“仅用于享包车认证”，并在复印件上加盖红色公章。", "http://img5.imgtn.bdimg.com/it/u=4022192071,1728188534&fm=21&gp=0.jpg");
    //    uploadType = UpdRoadPtPtAct.class.getSimpleName();
    }
}
