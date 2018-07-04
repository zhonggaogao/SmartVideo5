package com.example.g1620731.smartvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SeriesRecycleAdapter extends RecyclerView.Adapter<SeriesRecycleAdapter.MyViewHolder> {
    private List<String> mDatas;
    private List<String> mTextDatas;
    private Context context;
    private LayoutInflater inflater;
    private SparseArray<Integer> heightArray;


    public SeriesRecycleAdapter(Context context , List<String> mDatas, List<String> mTextDatas){
        this.context = context;
        this.mDatas = mDatas;
        this.mTextDatas = mTextDatas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        heightArray = new SparseArray<Integer>();
        View itemView = inflater.inflate(R.layout.item_seriesrecycle,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (heightArray.get(position) == null){
            Glide.with(context)
                    .load(mDatas.get(position))
                    .asBitmap()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {

                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                            // Do something with bitmap here.
                            int height = bitmap.getHeight(); //获取bitmap信息，可赋值给外部变量操作，也可在此时行操作。
                            bitmap.getWidth();
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.iv.getLayoutParams();
                            layoutParams.height = height;
                            holder.iv.setLayoutParams(layoutParams);
                            heightArray.put(position,height);

                        }

                    });
        }else {
            int height = heightArray.get(position);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.iv.getLayoutParams();
            layoutParams.height = height;
            holder.iv.setLayoutParams(layoutParams);
        }

        Glide.with(context)
                .load(mDatas.get(position))
                .into(holder.iv);

        holder.tv.setText(mTextDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public MyViewHolder(final View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.ivImage);
            tv = (TextView) itemView.findViewById(R.id.ivText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("瀑布流", "当前点击的位置："+getPosition());
                    Intent intent = new Intent(itemView.getContext(), SeriesWebViewActivity.class);
                    intent.putExtra("position",getPosition());
                    context.startActivity(intent);
                }
            });

        }
    }
}

