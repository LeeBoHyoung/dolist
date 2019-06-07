package apppractice.cs.skku.pa_1.pageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import apppractice.cs.skku.pa_1.Fragment.DoFragment;
import apppractice.cs.skku.pa_1.Fragment.DoingFragment;
import apppractice.cs.skku.pa_1.Fragment.DoneFragment;

public class ContentsPageAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public ContentsPageAdapter(FragmentManager fm, int PageCount){
        super(fm);
        this.mPageCount = PageCount;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                DoFragment doFragment = new DoFragment();
                return doFragment;

            case 1:
                DoingFragment doingFragment = new DoingFragment();
                return doingFragment;

            case 2:
                DoneFragment doneFragment = new DoneFragment();
                return doneFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return mPageCount;
    }
}
