package com.example.android_application_onepiece;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application_onepiece.R;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {
    private ArrayList<DataModel> dataSet;
    public CustomAdapter(ArrayList<DataModel> dataSet)
    {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textViewName;
        TextView textViewDescripton;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewDescripton = (TextView) itemView.findViewById(R.id.textViewDescription);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewLuffy);

        }

    }

    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        // אומרים לו לאיזה לייאות אנחנו רוצים לפנות
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent,false);
        // רוכשים את אותו view שבתוך הלייאות

        MyViewHolder myViewHolder = new MyViewHolder(view);

        // מחזירים בשביל הפונקציה הבאה של הביינד ויו הולדר ומעבירה גם את הליסט פוזישן
        return myViewHolder;
    }


    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder viewHolder, int position) //ליסט פוזישן זה המקום במערך שאנחנו רוצים להפוך אותו לקארד ולזרוק לתןך הריסייקל ויו
    {


        // שליפת נתונים שרוצים לזרוק על גבי הקארד
        TextView textViewName = viewHolder.textViewName;
        TextView textViewDescription = viewHolder.textViewDescripton;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;
        // מכניס את הנתונים לתוך המערך שלנו
        textViewName.setText(dataSet.get(position).getName());
        textViewDescription.setText(dataSet.get(position).getType());
        imageView.setImageResource(dataSet.get(position).getImage());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Check", String.valueOf(viewHolder.getAdapterPosition()));
                Bundle bundle = new Bundle();
                bundle.putInt("id",viewHolder.getAdapterPosition());
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_detailFragment,bundle);
            }
        });
    }

    public int getItemCount() {return dataSet.size();}



}

