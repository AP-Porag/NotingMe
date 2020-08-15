package com.example.notingme.model;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notingme.NoteDetails;
import com.example.notingme.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> titels;
    List<String> content;

    public Adapter(List<String>titel,List<String>content){
        this.titels = titel;
        this.content = content;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_note_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.noteTitel.setText(titels.get(position));
        holder.noteContent.setText(content.get(position));
        final int code = getRandomColor();
        holder.mcardView.setCardBackgroundColor(holder.view.getResources().getColor(code,null));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NoteDetails.class);
                intent.putExtra("titel",titels.get(position));
                intent.putExtra("content",content.get(position));
                intent.putExtra("code",code);
                v.getContext().startActivity(intent);
            }
        });

    }

    private int getRandomColor() {

        List<Integer>colorCode = new ArrayList<>();

        colorCode.add(R.color.colorOne);
        colorCode.add(R.color.colorTwo);
        colorCode.add(R.color.colorThree);
        colorCode.add(R.color.colorFour);
        colorCode.add(R.color.colorFive);
        colorCode.add(R.color.colorSix);
        colorCode.add(R.color.colorseven);
        colorCode.add(R.color.colorEight);
        colorCode.add(R.color.colorNine);
        colorCode.add(R.color.colorTen);
        colorCode.add(R.color.colorEleven);
        colorCode.add(R.color.colorTwelve);
        colorCode.add(R.color.colorThirteen);
        colorCode.add(R.color.colorFourteen);
        colorCode.add(R.color.colorFifteen);
        colorCode.add(R.color.colorSixteen);

        Random randomColor  = new Random();
        int number =  randomColor.nextInt(colorCode.size());
        return colorCode.get(number);
    }

    @Override
    public int getItemCount() {
        return titels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitel,noteContent;
        View view;
        CardView mcardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            noteTitel = itemView.findViewById(R.id.noteTitelXML);
            noteContent = itemView.findViewById(R.id.noteDescXML);
            mcardView = itemView.findViewById(R.id.noteCardXML);
            view = itemView;
        }
    }
}
