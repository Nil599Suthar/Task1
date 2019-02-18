package com.example.sutharnil.task1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class about_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.about_fragment,container,false);

        TextView textView1=(TextView)view.findViewById(R.id.textView3);
        TextView textView2=(TextView)view.findViewById(R.id.textView4);
        TextView textView3=(TextView)view.findViewById(R.id.textView5);
        TextView textView4=(TextView)view.findViewById(R.id.textView6);

        Bundle b =this.getArguments();
        String f=b.getString("ftext");
        String f1=b.getString("stext");
        String f2=b.getString("ttext");
       String f3=b.getString("rtext");
        textView1.setText(f1);
        textView2.setText(f);
        textView3.setText(f2);
       textView4.setText(f3);
        return view;

    }
}
