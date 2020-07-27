package com.example.intro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Arts> data;

    public RecyclerViewAdapter(Context context, List<Arts> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardview_photos, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_title.setText(data.get(position).getTitle());
        holder.iv_images.setImageResource(data.get(position).getThumbnail());

        holder.cv_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Arts_Activity.class);

                intent.putExtra("Title", data.get(position).getTitle());
                intent.putExtra("Description", data.get(position).getDescription());
                intent.putExtra("Thumbnail", data.get(position).getThumbnail());
                intent.putExtra("Category", data.get(position).getCategory());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title;
        ImageView iv_images;
        CardView cv_images;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tvTitle);
            iv_images = (ImageView) itemView.findViewById(R.id.ivImage);
            cv_images = (CardView) itemView.findViewById(R.id.cvimages);


        }
    }
}
