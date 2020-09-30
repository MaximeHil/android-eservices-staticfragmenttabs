package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends FragmentActivity implements FragmentOne.OnDataPass {

    private ViewPager viewPager;
    private int currentCounter;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.currentCounter = 0;
        setupViewPagerAndTabs();
        TextView counter_message = findViewById(R.id.counter_textview);
        counter_message.setText(String.valueOf(getCurrentCounter()));
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {

        //TODO we want two fragments with layouts : fragment_one, fragment_two.
        viewPager = findViewById(R.id.tab_viewpager);

        //TODO set adapter to viewpager and handle fragment change inside
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);

    }

    @Override
    public void onDataPass(int data) {
        setCurrentCounter(getCurrentCounter() + data);
        TextView counter_message = findViewById(R.id.counter_textview);
        counter_message.setText(String.valueOf(getCurrentCounter()));
    }

    /**
     * A simple pager adapter that represents 5 ViewPageFragment objects, in
     * sequence.
     */
    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return new FragmentOne();
            } else{
                return new FragmentTwo();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    public int getCurrentCounter() {
        return currentCounter;
    }

    public void setCurrentCounter(int currentCounter) {
        this.currentCounter = currentCounter;
    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}
