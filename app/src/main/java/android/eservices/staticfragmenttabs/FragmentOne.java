package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentOne extends Fragment implements View.OnClickListener {

    public static final String TAB_NAME = "ADD TO COUNTER";
    View view;

    public FragmentOne() {
        //TODO

    }

    public static FragmentOne newInstance() {
        //TODO
        FragmentOne f1 = new FragmentOne();
        return f1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO
        Button b;
        view = inflater.inflate(R.layout.fragment_one, container, false);
        b = (Button) view.findViewById(R.id.button_increment);
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
        passData(1);
    }

    public interface OnDataPass {
        void onDataPass(int data);
    }

    OnDataPass dataPasser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    public void passData(int data) {
        dataPasser.onDataPass(data);
    }


    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}
