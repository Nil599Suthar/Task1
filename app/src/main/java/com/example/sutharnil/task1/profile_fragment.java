package com.example.sutharnil.task1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class profile_fragment extends Fragment {
    String r;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.profile_fragment,container,false);

        final TextView textview= (TextView)view.findViewById(R.id.tv1);
        final EditText editText= (EditText) view.findViewById(R.id.et1);
        final EditText editText1= (EditText) view.findViewById(R.id.editText2);
        final RadioGroup radioGroup= (RadioGroup) view.findViewById(R.id.rgp);
        final RadioButton radioButton1= (RadioButton) view.findViewById(R.id.rb1);
        final RadioButton radioButton2= (RadioButton) view.findViewById(R.id.rb2);
        Button submit= (Button) view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text =textview.getText().toString();
                String text1 =editText.getText().toString();
                String text2 =editText1.getText().toString();

                if (radioButton1.isChecked())
                {
                     r = radioButton1.getText().toString();
                }else {
                     r = radioButton2.getText().toString();

                }



                Bundle b = new Bundle();
                b.putString("ftext",text);
                b.putString("stext",text1);
                b.putString("ttext",text2);
                b.putString("rtext",r);

                FragmentManager fragmentManager =getActivity().getFragmentManager();
               // Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                Fragment frag=new about_fragment();
                frag.setArguments(b);
                fragmentTransaction.replace(R.id.framelayout,frag);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;

    }
}
