package www.lvchehui.com.carteam.http;

import org.xutils.common.Callback;

/**
 * 作者：V先生 on 2016/8/1 17:20
 * 作用：文件下载进度
 */
public abstract class PgCb<ResultType> implements Callback.ProgressCallback {
    @Override
    public void onWaiting() {

    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onLoading(long total, long current, boolean isDownloading) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
