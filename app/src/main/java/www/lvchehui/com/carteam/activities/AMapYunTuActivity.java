package www.lvchehui.com.carteam.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import www.lvchehui.com.carteam.R;
import www.lvchehui.com.carteam.base.BaseAct;
import www.lvchehui.com.carteam.tools.Constants;
import www.lvchehui.com.carteam.tools.SPUtil;
import www.lvchehui.com.carteam.tools.XgoLog;
import www.lvchehui.com.carteam.view.CloudOverlay;
import www.lvchehui.com.carteam.view.TitleView;

/**
 * Created by 张灿能 on 2016/7/25.
 * 作用：提交云图地图
 */
@ContentView(R.layout.activity_yuntu_amap)
public class AMapYunTuActivity extends BaseAct implements LocationSource,AMapLocationListener,CloudSearch.OnCloudSearchListener {

    @ViewInject(R.id.title_view)
    private TitleView m_title_view;
    @ViewInject(R.id.map)
    private MapView map;
    private AMap aMap;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;
    private CloudSearch mCloudSearch;
    private Marker mCloudIDMarer;
    private ArrayList<CloudItem> items = new ArrayList<>();
    private List<CloudItem> mCloudItems;
    private CloudSearch.Query mQuery;
    private CloudOverlay mPoiCloudOverlay;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        map.onCreate(savedInstanceState);
        setTitleV(m_title_view, "地图");
        init();
        searchByQuery();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        map.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    private void init(){
        if (null == aMap){
            aMap = map.getMap();
            setUpMap();
        }

         mCloudSearch = new CloudSearch(this);
        mCloudSearch.setOnCloudSearchListener(this);
    }

    private void setUpMap() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        myLocationStyle.strokeColor(Color.BLACK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setLocationSource(this);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        XgoLog.e("aMapLocation:" + aMapLocation);

        if (mListener != null && aMapLocation != null)
        {
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0)
            {
                mListener.onLocationChanged(aMapLocation);

            }else{
                String errText = "定位失败" + aMapLocation.getErrorCode() + ":" + aMapLocation.getErrorCode();
                Log.e("AmapErr",errText);
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        if (mLocationClient == null)
        {
            mLocationClient = new AMapLocationClient(this);
            mLocationOption = new AMapLocationClientOption();
            mLocationClient.setLocationListener(this);
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mLocationOption.setInterval(30000);
            mLocationClient.setLocationOption(mLocationOption);
            mLocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mLocationClient != null)
        {
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
        mLocationClient = null;
    }

    @Override
    public void onCloudSearched(CloudResult result, int rCode) {
        dismissProgressDialog();
        if (rCode == 1000)
        {
            if (result != null && result.getQuery() != null)
            {
                if (result.getQuery().equals(mQuery))
                {
                    mCloudItems = result.getClouds();
                    if (mCloudItems != null && mCloudItems.size() > 0)
                    {
                         mPoiCloudOverlay = new CloudOverlay(aMap, mCloudItems);
                        mPoiCloudOverlay.removeFromMap();
                        mPoiCloudOverlay.addToMap();
                        for (CloudItem item:mCloudItems) {
                            Iterator<Map.Entry<String, String>> iter = item.getCustomfield().entrySet().iterator();
                            while (iter.hasNext())
                            {
                                Map.Entry<String, String> entry = iter.next();
                                String key = entry.getKey();
                                String val = entry.getValue();
                                XgoLog.e("key:" + key + "val:" + val);
                            }

                        }
                    }
                }
            }else{
                showToast("result:" + result + "rCode:" + rCode);
            }
        }else{
            showToast("onCloundSearched:" + rCode);
        }

    }

    @Override
    public void onCloudItemDetailSearched(CloudItemDetail item, int rCode) {
    }

    public void searchByQuery(){
        showProgressDialog();
        items.clear();
        CloudSearch.SearchBound bound = new CloudSearch.SearchBound("全国");
        try {
            mQuery = new CloudSearch.Query(Constants.YUNTU_MAP.AMAP_YUNTU_TABLEID,"",bound);
            mQuery.addFilterString("xbc_gid",(String) SPUtil.getInstant(this).get(Constants.USERS_GID,""));
            mCloudSearch.searchCloudAsyn(mQuery);
        } catch (AMapException e) {
            e.printStackTrace();
        }


    }
}
