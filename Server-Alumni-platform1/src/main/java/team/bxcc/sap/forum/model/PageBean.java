package team.bxcc.sap.forum.model;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PageBean<T>{
    private int allPage;


    private String uid;



    private int curPage;
    private List<T> list;
    public PageBean(){}//一旦设置了有参构造函数就不能再使用无参构造函数，所以这里必须显式写出来。
    public PageBean(int allPage,int curPage){
        this.allPage=allPage;
        this.curPage=curPage;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    @Override
    public String toString() {
        return "PageBean{" +
                "allPage=" + allPage +
                ", curPage=" + curPage +
                ", list=" + list +
                '}';
    }
}
