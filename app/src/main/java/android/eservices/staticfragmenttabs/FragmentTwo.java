package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment implements View.OnClickListener {

    public static final String TAB_NAME = "ADD TO COUNTER";
    View view;

    public FragmentTwo() {
        //TODO

    }

    public static FragmentTwo newInstance() {
        //TODO
        FragmentTwo f2 = new FragmentTwo();
        return f2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO
        Button b;
        view = inflater.inflate(R.layout.fragment_two, container, false);
        b = (Button) view.findViewById(R.id.button_decrement);
        b.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View view) {
        passData(-1);
    }

    FragmentOne.OnDataPass dataPasser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (FragmentOne.OnDataPass) context;
    }

    public void passData(int data) {
        dataPasser.onDataPass(data);
    }


//TODO add listener to button and transmit the information to parent Activity
//TODO read the Android doc, as suggested, to do it the right way

}