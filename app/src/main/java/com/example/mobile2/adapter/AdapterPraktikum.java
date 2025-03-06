package com.example.mobile2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobile2.R;
import com.example.mobile2.latihan.ModelLatihan;
import com.example.mobile2.praktikum.ModelPraktikum;

import java.util.List;

public class AdapterPraktikum extends RecyclerView.Adapter<AdapterPraktikum.ViewHolder> {
    private Context context;
    private List<ModelPraktikum> praktikumList;

    public AdapterPraktikum(Context context, List<ModelPraktikum> praktikumList) {
        this.context = context;
        this.praktikumList = praktikumList;
    }

    @NonNull
    @Override
    public AdapterPraktikum.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_praktikum, parent, false);
        return new AdapterPraktikum.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPraktikum.ViewHolder holder, int position) {
        ModelPraktikum praktikum = praktikumList.get(position);
        holder.tvTitle.setText(praktikum.getTitle());
        holder.tvSubtitle.setText(praktikum.getSubtitle());

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, praktikum.getActivityClass());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return praktikumList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubtitle = itemView.findViewById(R.id.tv_subtitle);
            cardView = (CardView) itemView;
        }
    }
}
