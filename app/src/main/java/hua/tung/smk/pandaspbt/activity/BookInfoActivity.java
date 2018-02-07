package hua.tung.smk.pandaspbt.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import hua.tung.smk.pandaspbt.R;
import hua.tung.smk.pandaspbt.db.BookInfo;
import hua.tung.smk.pandaspbt.db.BookInfoDao;
import hua.tung.smk.pandaspbt.db.DaoSession;

public class BookInfoActivity extends AppCompatActivity {

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        daoSession =  ((App)getApplication()).getDaoSession();
        getData();
    }

    private List<BookInfo> bookInfoList;

    private void getData(){

        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        Query<BookInfo> bookInfoQuery = bookInfoDao.queryBuilder()
                .orderAsc(BookInfoDao.Properties.Form)
                .build();

        bookInfoList = bookInfoQuery.list();
        if(bookInfoList.size()>0){

        }
    }
}
