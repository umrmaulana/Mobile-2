package com.example.mobile2.fragment;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.mobile2.MenuLatihan;
import com.example.mobile2.MenuPraktikum;
import com.example.mobile2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private String nama, email, foto;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        AppCompatImageButton btnLatihan = view.findViewById(R.id.btnLatihan);
        Bundle bundle = getArguments();
        if (bundle != null) {
            nama = bundle.getString("nama");
            email = bundle.getString("email");
            foto = bundle.getString("foto");
        }
        TextView tvNama = view.findViewById(R.id.tv_nama);
        TextView tvEmail = view.findViewById(R.id.tv_email);
        ImageView imgFoto = view.findViewById(R.id.img_foto);
        tvNama.setText(nama);
        tvEmail.setText(email);
        if (foto != null && !foto.isEmpty()) {
            Glide.with(this)
                    .load(foto)
                    .into(imgFoto);
        } else {
            imgFoto.setImageResource(R.drawable.ic_launcher_foreground);
        }
        btnLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuLatihan.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        AppCompatImageButton btnPraktikum = view.findViewById(R.id.btnPraktikum);
        btnPraktikum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuPraktikum.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().finish();
                    }
                });
        return view;
    }
}