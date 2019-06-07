package apppractice.cs.skku.pa_1.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import apppractice.cs.skku.pa_1.App;
import apppractice.cs.skku.pa_1.EditActivity;
import apppractice.cs.skku.pa_1.ListViewAdapter;
import apppractice.cs.skku.pa_1.ListViewItem;
import apppractice.cs.skku.pa_1.R;

import static android.app.Activity.RESULT_OK;


public class DoneFragment extends Fragment {
    public DoneFragment() {
    }

    ListView listView;
    ListViewAdapter adapter = new ListViewAdapter();
    String text1;
    String text2;
    String text3;
    TextView tv;
    TextView tv2;
    TextView tv3;
    int pos;
    int check;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = (View) inflater.inflate(R.layout.fragment_done, container, false);
        listView = (ListView)view.findViewById(R.id.list);

        Button update = (Button)view.findViewById(R.id.update_btn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cnt = ((App)getActivity().getApplicationContext()).done_getCnt();
                for(int i = 0; i<cnt;i++) {
                    text1 = ((App) getActivity().getApplicationContext()).done_getTitle(i);
                    text2 = ((App) getActivity().getApplicationContext()).done_getSub(i);
                    text3 = ((App) getActivity().getApplicationContext()).done_getTime(i);

                    ((App) getActivity().getApplicationContext()).done_setTitle("", cnt);
                    ((App) getActivity().getApplicationContext()).done_setSub("", cnt);
                    ((App) getActivity().getApplicationContext()).done_setTime("", cnt);

                    if (text1.equals("")) {
                        return;
                    }
                    else{
                        adapter.addItem(text1, text2, text3);
                        listView.setAdapter(adapter);
                    }
                }
                ((App) getActivity().getApplicationContext()).done_setCnt(0);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                check = 2;

                Intent intent = new Intent(getActivity(), EditActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("data1", titleStr);
                bundle.putString("data2", descStr);
                bundle.putString("data3", dateStr);
                bundle.putInt("pos", pos);
                bundle.putInt("check",check);
                intent.putExtras(bundle);

                startActivityForResult(intent, 2);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                if(bundle != null) {
                    text1 = bundle.getString("data1");
                    text2 = bundle.getString("data2");
                    text3 = bundle.getString("data3");
                }
                tv.setText(text1);
                tv2.setText(text2);
                tv3.setText(text3);
            }
            else if(resultCode == 2){
                adapter.delItem(pos);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
