package apppractice.cs.skku.pa_1;

import android.app.Application;

public class App extends Application {
    String doing_title[] = new String[10];
    String doing_sub[] = new String[10];
    String doing_time[] = new String[10];
    int doing_cnt = 0;

    String done_title[] = new String[10];
    String done_sub[] = new String[10];
    String done_time[] = new String[10];
    int done_cnt = 0;

    String do_title[] = new String[10];
    String do_sub[] = new String[10];
    String do_time[] = new String[10];
    int do_cnt = 0;

    public String doing_getTitle(int cnt) {
        return doing_title[cnt];
    }

    public void doing_setTitle(String title, int cnt) {
        this.doing_title[cnt] = title;
        this.doing_cnt++;
    }

    public String doing_getSub(int cnt) {
        return doing_sub[cnt];
    }

    public void doing_setSub(String sub, int cnt) {
        this.doing_sub[cnt] = sub;
    }

    public String doing_getTime(int cnt) {
        return doing_time[cnt];
    }

    public void doing_setTime(String time, int cnt) {
        this.doing_time[cnt] = time;
    }

    public int doing_getCnt(){
        return doing_cnt;
    }

    public void doing_setCnt(int cnt){
        this.doing_cnt = cnt;
    }


    public String done_getTitle(int cnt) {
        return done_title[cnt];
    }

    public void done_setTitle(String title, int cnt) {
        this.done_title[cnt] = title;
        this.done_cnt++;
    }

    public String done_getSub(int cnt) {
        return done_sub[cnt];
    }

    public void done_setSub(String sub, int cnt) {
        this.done_sub[cnt] = sub;
    }

    public String done_getTime(int cnt) {
        return done_time[cnt];
    }

    public void done_setTime(String time, int cnt) {
        this.done_time[cnt] = time;
    }

    public int done_getCnt(){
        return done_cnt;
    }

    public void done_setCnt(int cnt){
        this.done_cnt = cnt;
    }



    public String do_getTitle(int cnt) {
        return do_title[cnt];
    }

    public void do_setTitle(String title, int cnt) {
        this.do_title[cnt] = title;
        this.do_cnt++;
    }

    public String do_getSub(int cnt) {
        return do_sub[cnt];
    }

    public void do_setSub(String sub, int cnt) {
        this.do_sub[cnt] = sub;
    }

    public String do_getTime(int cnt) {
        return do_time[cnt];
    }

    public void do_setTime(String time, int cnt) {
        this.do_time[cnt] = time;
    }

    public int do_getCnt(){
        return do_cnt;
    }

    public void do_setCnt(int cnt){
        this.do_cnt = cnt;
    }
}
