package com.andreap.toomanybuffs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.*;
import android.widget.*;
import android.graphics.*;

/**
 * Created by Abhi on 23 Sep 2017 023.
 */

public class AttacksAdapter extends RecyclerView.Adapter<AttacksAdapter.CustomViewHolder> {
   
    public ArrayList<AttackInfo> attacks;
    static int row_index = -1;
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name, attackBasedOn, damageBasedOn, critical;
        
        RelativeLayout row_linearlayout;
        RecyclerView rv2;

        public CustomViewHolder(View view) {
            super(view);
            row_linearlayout=(RelativeLayout)itemView.findViewById(R.id.entryrelativelayout);
            rv2=(RecyclerView)itemView.findViewById(R.id.attacksRecyclerView1);
        
            name = (TextView) view.findViewById(R.id.attackname);
            attackBasedOn = (TextView) view.findViewById(R.id.attackbasedon);
            damageBasedOn = (TextView) view.findViewById(R.id.damagebasedon);
            critical = (TextView) view.findViewById(R.id.critical);
            
            
        }
    }

    public AttacksAdapter(ArrayList<AttackInfo> attacks) {
        this.attacks = attacks;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.attackentry, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        AttackInfo attack = attacks.get(position);
        holder.name.setText(attack.name);
        holder.attackBasedOn.setText("Attacks on: "+attack.attackBasedOn);
        holder.damageBasedOn.setText("Damage on: "+attack.damageBasedOn);
        holder.critical.setText(attack.critical);
        
        holder.row_linearlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                    row_index=position;
                    notifyDataSetChanged();
                }
            });
        if(row_index==position){
            holder.row_linearlayout.setBackgroundColor(Color.parseColor("#B3F5FC"));
            
        }
        else
        {
            holder.row_linearlayout.setBackgroundColor(Color.parseColor("#fafafa"));
            
        }
        
    }

    @Override
    public int getItemCount() {
        if (attacks.get(0).nattacks == 0)
        {
            return 0;
        }
        else
        {
            return attacks.size();
        }     
    }

    
    
}
