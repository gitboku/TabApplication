package com.example.kouhei.tabapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.tabContent);

        // "FragmenteTab"は自分で実装するクラス
        // addTab()の第一引数がTabSpec、第二引数は表示するFragmentをclass名で渡す。第三引数はFragmentで読み込むデータをBundleで渡す。
        // TabSpecはタブの情報
        // setIndicator()はタブのView
        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("Tab 1", getDrawable(R.drawable.ic_spa_black_24dp)),
                FragmentTab.class,
                null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("Tab 2", getDrawable(R.drawable.ic_sentiment_satisfied_black_24dp)),
                FragmentTab.class,
                null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("Tab 3", getDrawable(R.drawable.ic_android_black_24dp)),
                SupportMapFragment.class,
                null);
    }
}
