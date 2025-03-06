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
import java.util.List;

public class AdapterLatihan extends RecyclerView.Adapter<AdapterLatihan.ViewHolder> {
    private Context context;
    private List<ModelLatihan> latihanList;

    public AdapterLatihan(Context context, List<ModelLatihan> latihanList) {
        this.context = context;
        this.latihanList = latihanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_latihan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelLatihan latihan = latihanList.get(position);
        holder.tvTitle.setText(latihan.getTitle());
        holder.tvSubtitle.setText(latihan.getSubtitle());

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, latihan.getActivityClass());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return latihanList.size();
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

