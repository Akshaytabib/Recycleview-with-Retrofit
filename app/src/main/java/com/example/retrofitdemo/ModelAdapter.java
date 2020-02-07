package com.example.retrofitdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {
    Context context;
    ArrayList<Post> arrayList;
    public ModelAdapter(MainActivity mainActivity, ArrayList<Post> arrayList) {
        this.context= (Context) mainActivity;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post=arrayList.get(position);
        holder.ids.setText(Integer.toString(post.getId()));
        holder.userid.setText(Integer.toString(post.getUserid()));
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getText());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userid,ids,title,body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userid=itemView.findViewById(R.id.UserId);
            ids=itemView.findViewById(R.id.Id);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
