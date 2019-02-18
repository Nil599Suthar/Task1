package com.example.sutharnil.task1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class setting_fragment extends Fragment {

    private  settextonclick settext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.setting_fragment,container,false);
        Button send=(Button)view.findViewById(R.id.btnsend);

        final Intent intent = new Intent(getActivity(), Main2Activity.class);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Button clicked", Toast.LENGTH_SHORT).show();

                String textname1 ="Data pass Fragment to activity";
                settext.text(textname1);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


            if (getActivity() instanceof settextonclick) {
                settext =(settextonclick) getActivity();
            } else {
                throw new RuntimeException(getActivity().toString()
                        + " must implement OnFragmentInteractionListener");
            }


    }

    @Override
    public void onDetach() {
        super.onDetach();
        settext=null;
    }

    public interface settextonclick{
        public void  text(String textname);
    }
}
