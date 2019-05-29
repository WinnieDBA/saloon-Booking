package com.winnienjeri.firebasedatabaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Tabone extends Fragment {
    Button move;


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
      View root= inflater.inflate(R.layout.tab_one,container,false);
      move= root.findViewById(R.id.btnnext);
      move.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getContext(),MainActivity.class);
              startActivity(intent);

          }
      });
      return root;
    }
}
