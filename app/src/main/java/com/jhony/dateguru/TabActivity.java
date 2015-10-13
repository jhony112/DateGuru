package com.jhony.dateguru;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import fragments.DatesFragment;
import fragments.GiftFragment;
import fragments.IntroFragment;
import fragments.XterFragment;

public class TabActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ActionBar action;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    com.google.android.gms.ads.AdView myAd;
    InterstitialAd mInterstitialAd;
    private int[] tabIcons = {
            R.drawable.menu1,
            R.drawable.menu01,
            R.drawable.menu2,
            R.drawable.menu4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
toolbar.setTitle("Guru");
myAd= (com.google.android.gms.ads.AdView) findViewById(R.id.adView);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //toolbar.setTitle("Guru");
//action=getActionBar();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        toolbar.setTitle("Summary");
                        break;
                    case 1:
                        toolbar.setTitle("Intro");
                        break;
                    case 2:
                        toolbar.setTitle("Facts");
                        break;
                    case 3:
                        toolbar.setTitle("Gifts");
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if(myAd.getVisibility()==View.INVISIBLE||myAd.getVisibility()==View.GONE){myAd.setVisibility(View.VISIBLE);}

            }
        });


    }
    @Override
    protected void onPause(){
        super.onPause();

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new IntroFragment(),null);
        adapter.addFragment(new XterFragment(), null);
        adapter.addFragment(new DatesFragment(), null);
        adapter.addFragment(new GiftFragment(), null);
        viewPager.setAdapter(adapter);

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[1]);
        tabLayout.getTabAt(1).setIcon(tabIcons[0]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);

        return true;
    }

    void LoadAds() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_settings) {
            Intent intent= new Intent(this,AboutActivity.class);
            startActivity(intent);
        } if (id == R.id.rating) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +  getBaseContext().getPackageName())));
        }

            if(id==android.R.id.home) {
                finish();
            }


        return super.onOptionsItemSelected(item);
    }
}
