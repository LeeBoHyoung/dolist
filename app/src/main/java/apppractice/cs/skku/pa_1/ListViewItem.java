package apppractice.cs.skku.pa_1;

public class ListViewItem {
    private String titleStr ;
    private String descStr ;
    private String dateStr ;

    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }
    public void setDate(String date){ dateStr = date; }

    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
    public String getDate(){ return this.dateStr;
    }
}