package com.example.mobile2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.mobile2.R;
import com.example.mobile2.latihan.Latih1_1;

import java.util.List;
public class AdapterStudent11 extends RecyclerView.Adapter<AdapterStudent11.ViewHolder>{
    private List<Latih1_1.Student11> student11List;
    private Context context;

    public AdapterStudent11(Context context, List<Latih1_1.Student11> student11List) {
        this.context = context;
        this.student11List = student11List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student_11, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Latih1_1.Student11 student11 = student11List.get(position);
        holder.textViewNim.setText(student11.getNim());
        holder.textViewNama.setText(student11.getNama());
        Glide.with(context).load(student11.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return student11List.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewNim;
        TextView textViewNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewNim = itemView.findViewById(R.id.textViewNim);
            textViewNama = itemView.findViewById(R.id.textViewNama);
        }
    }
}

