package com.example.fragmentbundleexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.w3c.dom.Text;

public class Fragment1 extends Fragment {

    private View view;
    private TextView tv_frag1;
    private Button btn_move;
    private String result;


    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1,container,false);

        tv_frag1 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);


        if (getArguments() != null){ //getArguments가 빈값이 아닐때만 실행
            result = getArguments().getString("fromfrag2"); //프래그먼트1로부터 setArgument된 데이터를 받아옴.
            tv_frag1.setText(result);
        }

        btn_move.setOnClickListener(new View.OnClickListener() { //프래그먼트2로 이동
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); //무언가를 담을 수 있는 보따리 or 꾸러미
                bundle.putString("fromfrag1","안드로이드 프래그먼트1");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                transaction.replace(R.id.frameLayout,fragment2);  //intent로 따졌을 때 startactivity같은 역할
                transaction.commit(); //저장

            }
        });



        return view;
    }
}
