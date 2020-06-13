package com.example.fireworkapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContent;
    private List<Food> mdata;

    public RecyclerViewAdapter(Context mContent, List<Food> mdata) {
        this.mContent = mContent;
        this.mdata = mdata;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.foodName.setText(mdata.get(position).getName());
        holder.imageFood.setImageResource(mdata.get(position).getImage());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContent,ShopMainActivity.class);
                intent.putExtra("Food Name",mdata.get(position).getName());

                intent.putExtra("Food Picture",mdata.get(position).getImage());
                mContent.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;

        CircleImageView imageFood;
        RelativeLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.image_name);
            imageFood = itemView.findViewById(R.id.image);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}



