package com.example.g1620731.smartvideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;



public class SeriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private List<String> mTextData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        initData();
        initView();

    }

    private void initData() {
        mDatas = new ArrayList<String>();
        mTextData = new ArrayList<String>();
        for (int i = 0 ; i < ImageUtil.SeriesimageUrls.length ; i++){
            String data = ImageUtil.SeriesimageUrls[i];
            mDatas.add(data);
        }
        for (int ii = 0 ; ii < ImageUtil.Seriestext.length ; ii++){
            String data = ImageUtil.Seriestext[ii];
            mTextData.add(data);
        }
    }



    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //添加布局管理
        StaggeredGridLayoutManager manager = new  StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        //设置适配器
        recyclerView.setAdapter(new SeriesRecycleAdapter(this,mDatas,mTextData));
        //设置item添加和删除的动画
        //设置item添加和删除的动画
//        recyclerView.setItemAnimator();
        //设置分隔线
//        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));

    }

}

