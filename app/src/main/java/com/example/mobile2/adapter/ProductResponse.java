package com.example.mobile2.adapter;

import com.example.mobile2.latihan.Latih1_1;
import com.example.mobile2.latihan.Latih2_1;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;

public class ProductResponse {
    @SerializedName("result")
    private List<Latih2_1.Product11> result;

    public Collection<? extends Latih2_1.Product11> getResult() {
        return result;
    }
}
