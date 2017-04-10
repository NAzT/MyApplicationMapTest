package com.example.nat.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.nat.myapplication.adapter.MyPagerAdapter;
import com.example.nat.myapplication.protocol.OnFragmentInteractionListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private TextView mTextMessage;
    Fragment frag = null;
    public static final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
                default:
//                    mTextMessage.setText("Other");
            }

//            if (frag != null) {
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.add(R.id.content, frag, frag.getTag());
//                ft.commit();
//                Log.d(TAG, "Fragment beginTransaction: ");
//            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViewPager(mViewPager);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.requestTransparentRegion(viewPager);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
