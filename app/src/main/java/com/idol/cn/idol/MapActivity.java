package com.idol.cn.idol;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;

/**
 * Created by solin on 2017/8/11.
 */

public class MapActivity extends AppCompatActivity implements AMap.OnMyLocationChangeListener{

    private static final int ACCESS_COARSE_LOCATION_REQUEST_CODE = 100;

    private MapView mapView;
    //地图控制器对象
    private AMap aMap;
    //定位蓝点样式类
    private MyLocationStyle myLocationStyle;
    //地位经纬度
    private LatLng latLng;

    @Override
    public void onMyLocationChange(Location location) {
        //第一个参数是：latitude，第二个参数是longitude
        latLng = new LatLng(location.getLatitude(),location.getLongitude());
        showMarker();

        Snackbar snackbar = Snackbar.make(mapView,"经度:"+location.getLongitude()+";纬度:"+location.getLatitude(), Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.Pink));
        snackbar.show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_main);
        mapView = (MapView) findViewById(R.id.mapView);
        //创建地图
        mapView.onCreate(savedInstanceState);
        if(aMap==null)aMap=mapView.getMap();
        checkStoragePermission();
    }

    private void initMap(){
        //初始化定位蓝点样式类
        myLocationStyle = new MyLocationStyle();
        //连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER);
        //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        myLocationStyle.interval(2000);
        //设置是否显示定位小蓝点，用于满足只想使用定位，不想使用定位小蓝点的场景，设置false以后图面上不再有定位蓝点的概念，但是会持续回调位置信息。(方法自5.1.0版本后支持)
        myLocationStyle.showMyLocation(true);
        //设置定位蓝点的Style
        aMap.setMyLocationStyle(myLocationStyle);
        //true：显示室内地图；false(默认)：不显示；
        aMap.showIndoorMap(true);
        //监听经纬度变化信息
        aMap.setOnMyLocationChangeListener(this);
        //通过aMap对象设置定位数据源的监听
        //aMap.setLocationSource(this);
        //显示默认的定位按钮
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        // 可触发定位并显示当前位置
        aMap.setMyLocationEnabled(true);
    }

    private void showMarker(){
        MarkerOptions markerOption=new MarkerOptions();
        markerOption.position(latLng);
        markerOption.title("成都");
        markerOption.snippet("我");
//        markerOption.perspective(true);
//        markerOption.draggable(true);
        markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.azure_mark));//设置图标
        aMap.addMarker(markerOption);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //重新绘制加载地图
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //暂停地图的绘制
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁地图
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存地图当前的状态
        mapView.onSaveInstanceState(outState);
    }

    private void checkStoragePermission() {

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED||ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},ACCESS_COARSE_LOCATION_REQUEST_CODE);
        }else{
            initMap();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if(requestCode==ACCESS_COARSE_LOCATION_REQUEST_CODE){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                initMap();
            }else{
                Snackbar snackbar = Snackbar.make(mapView,"权限申请失败", Snackbar.LENGTH_SHORT);
                snackbar.getView().setBackgroundColor(getResources().getColor(R.color.Pink));
                snackbar.show();
            }

        }
    }
}
