package apppractice.cs.skku.pa_1.Fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

import apppractice.cs.skku.pa_1.App;
import apppractice.cs.skku.pa_1.EditActivity;
import apppractice.cs.skku.pa_1.ListViewAdapter;
import apppractice.cs.skku.pa_1.ListViewItem;
import apppractice.cs.skku.pa_1.PopupActivity;
import apppractice.cs.skku.pa_1.ScheduleActivity;
import apppractice.cs.skku.pa_1.pageAdapter.ContentsPageAdapter;
import apppractice.cs.skku.pa_1.R;

import static android.app.Activity.RESULT_OK;

public class DoFragment extends Fragment {
    public DoFragment() {}

    ListView listview;
    ListViewAdapter adapter = new ListViewAdapter();
    private TextView tv;
    private TextView tv2;
    private TextView tv3;
    String text1;
    String text2;
    String text3;
    int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


     View view = (View) inflater.inflate(R.layout.fragment_do, container, false);

     Button add = (Button) view.findViewById(R.id.add_btn);
     Button update = (Button) view.findViewById(R.id.update_btn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cnt = ((App)getActivity().getApplicationContext()).do_getCnt();
                for(int i = 0; i<cnt;i++) {
                    text1 = ((App) getActivity().getApplicationContext()).do_getTitle(i);
                    text2 = ((App) getActivity().getApplicationContext()).do_getSub(i);
                    text3 = ((App) getActivity().getApplicationContext()).do_getTime(i);

                    ((App) getActivity().getApplicationContext()).do_setTitle("", cnt);
                    ((App) getActivity().getApplicationContext()).do_setSub("", cnt);
                    ((App) getActivity().getApplicationContext()).do_setTime("", cnt);

                    if (text1.equals("")) {
                        return;
                    }
                    else{
                        adapter.addItem(text1, text2, text3);
                        listview.setAdapter(adapter);
                    }
                }
                ((App) getActivity().getApplicationContext()).do_setCnt(0);
            }
        });

     add.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getActivity(), PopupActivity.class);
             startActivityForResult(intent, 1);
        }});



        listview = (ListView) view.findViewById(R.id.list);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // get item


                tv = (TextView)v.findViewById(R.id.textView1);
                tv2 = (TextView)v.findViewById(R.id.textView2);
                tv3 = (TextView)v.findViewById(R.id.textView3);

                String titleStr = tv.getText().toString();
                String descStr = tv2.getText().toString();
                String dateStr = tv3.getText().toString();

                pos = position;
                int check = 0;

                Intent intent = new Intent(getActivity(), EditActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("data1", titleStr);
                bundle.putString("data2", descStr);
                bundle.putString("data3", dateStr);
                bundle.putInt("pos", pos);
                bundle.putInt("check", check);
                intent.putExtras(bundle);

                startActivityForResult(intent, 2);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    String text1 = bundle.getString("data1");
                    String text2 = bundle.getString("data2");
                    String text3 = bundle.getString("data3");
                    adapter.addItem(text1, text2, text3);
                    listview.setAdapter(adapter);
                }
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    text1 = bundle.getString("data1");
                    text2 = bundle.getString("data2");
                    text3 = bundle.getString("data3");
                }
                tv.setText(text1);
                tv2.setText(text2);
                tv3.setText(text3);

            } else if (resultCode == 2) {
                adapter.delItem(pos);
                adapter.notifyDataSetChanged();
            }
        }
    }
}

