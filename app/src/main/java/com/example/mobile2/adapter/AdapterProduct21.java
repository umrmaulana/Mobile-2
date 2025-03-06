package com.example.mobile2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile2.R;
import com.example.mobile2.latihan.Latih2_1;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdapterProduct21 extends RecyclerView.Adapter<AdapterProduct21.ViewHolder> {
    private List<Latih2_1.Product11> product11List;
    private Context context;
    private String formatRupiah(String harga) {
        try {
            double hargaDouble = Double.parseDouble(harga);
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            return formatRupiah.format(hargaDouble).replace(",00", ""); // Menghilangkan ",00" jika tidak perlu
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Rp. 0";
        }
    }


    public AdapterProduct21(Context context, List<Latih2_1.Product11> product11List) {
        this.context = context;
        this.product11List = product11List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_latih2_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Latih2_1.Product11 product11 = product11List.get(position);
        holder.textViewMerk.setText(product11.getMerk());
        holder.textViewHargaBeli.setText(formatRupiah(product11.getHargaBeli()));
        holder.textViewStok.setText(product11.getStok());
        String imageName = product11.getFoto();
        int imageResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        if (imageResId != 0) {
            holder.imageViewProduct.setImageResource(imageResId);
        } else {
            holder.imageViewProduct.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    public int getItemCount() {
        return product11List.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textViewMerk;
        TextView textViewHargaBeli;
        TextView textViewStok;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
            textViewMerk = itemView.findViewById(R.id.textViewMerk);
            textViewHargaBeli = itemView.findViewById(R.id.textViewHargaBeli);
            textViewStok = itemView.findViewById(R.id.textViewStok);
        }
    }
}

