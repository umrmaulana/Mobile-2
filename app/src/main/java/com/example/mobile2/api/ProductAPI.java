package com.example.mobile2.api;

import com.example.mobile2.adapter.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {
    @GET("get_product.php")
    Call<ProductResponse> getProducts();
}
