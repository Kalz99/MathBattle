package com.example.mathbattle.scoreboard;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mathbattle.Database.playerRankings;
import com.example.mathbattle.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    Context context;

    ArrayList<playerRankings> list;


    public MyAdapter(Context context, ArrayList<playerRankings> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rankingitem,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        playerRankings user = list.get(position);
        holder.name.setText(user.getName());
        holder.score.setText(user.getScore());

    }

    @Override
    public int getItemCount() {
       return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,score;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_name);
            score = itemView.findViewById(R.id.txt_score);


        }
    }
}
