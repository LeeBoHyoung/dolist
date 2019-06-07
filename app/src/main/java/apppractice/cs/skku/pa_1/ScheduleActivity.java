package apppractice.cs.skku.pa_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import apppractice.cs.skku.pa_1.pageAdapter.ContentsPageAdapter;
import apppractice.cs.skku.pa_1.R;

public class ScheduleActivity extends AppCompatActivity {
    private Context mycontext;
    private TabLayout mytab;
    private ViewPager mViewPager;
    private ContentsPageAdapter mContentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_main);
        mycontext = getApplicationContext();

        mytab = (TabLayout) findViewById(R.id.layout_tab);
        mytab.addTab(mytab.newTab().setText("DO"));
        mytab.addTab(mytab.newTab().setText("DOING"));
        mytab.addTab(mytab.newTab().setText("DONE"));

        mViewPager = (ViewPager)findViewById(R.id.pager_content);
        mContentPageAdapter = new ContentsPageAdapter(getSupportFragmentManager(), mytab.getTabCount());
        mViewPager.setAdapter(mContentPageAdapter);
        mViewPager.setOffscreenPageLimit(2);


        mViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(mytab));
        mytab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(mycontext).inflate(R.layout.custom_tab, null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);
        return tabView;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}