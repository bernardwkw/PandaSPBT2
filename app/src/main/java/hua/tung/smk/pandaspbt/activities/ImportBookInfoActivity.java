package hua.tung.smk.pandaspbt.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.greendao.query.Query;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hua.tung.smk.pandaspbt.R;
import hua.tung.smk.pandaspbt.Utils.Conts;
import hua.tung.smk.pandaspbt.db.BookInfo;
import hua.tung.smk.pandaspbt.db.BookInfoDao;
import hua.tung.smk.pandaspbt.db.DaoSession;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ImportBookInfoActivity extends AppCompatActivity {

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_excel);

        daoSession = ((App) getApplication()).getDaoSession();

        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        Query<BookInfo> bookInfoQuery = bookInfoDao.queryBuilder()
                .orderAsc(BookInfoDao.Properties.Form)
                .build();
        List<BookInfo> bookInfoList = bookInfoQuery.list();
        for(BookInfo bookInfo: bookInfoList){
            Log.e("book tittle", bookInfo.getBook_name());
        }

        File bookInfoPath = new File(Conts.APP_PATH + Conts.IMPORT_BOOK_INFO);
        if (!bookInfoPath.exists()){
            bookInfoPath.mkdirs();
        }else {
            File[] list = bookInfoPath.listFiles();

            for (File filename : list){

                try {
                    read(bookInfoPath+"/"+filename.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void read(String inputFile) throws IOException {

        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();

        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            //w.getNumberOfSheets();
            // Loop over first 10 column and lines
            ArrayList<String> columnName = new ArrayList<>();
            for (int j = 0; j < sheet.getRows(); j++) {
                BookInfo bookInfo = new BookInfo();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    CellType type = cell.getType();

                    if (j == 0){
                        columnName.add(i, cell.getContents());
                        Log.e("name", cell.getContents());
                    }else {

                        if(i==0){// id

                            bookInfo.setBook_info_id(Long.parseLong(cell.getContents()));

                        }else if (i==1){// book_code

                            bookInfo.setBook_code(cell.getContents());

                        }else if(i==2){// book_name

                            bookInfo.setBook_name(cell.getContents());

                        }else if (i==3){// book_price

                            bookInfo.setBook_price(cell.getContents());

                        }else if (i==4){// book publisher

                            bookInfo.setBook_publisher(cell.getContents());

                        }else if (i==5){// form

                            bookInfo.setForm(cell.getContents());

                        }else if (i==6){// book_symbol

                            bookInfo.setBook_symbol(cell.getContents());

                        }
                    }

                }
                bookInfoDao.insertOrReplace(bookInfo);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
