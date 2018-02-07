package hua.tung.smk.pandaspbt.binder;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by User on 7/2/2018.
 */

public class BookInfo extends BaseObservable {

    private String book;

    @Bindable
    public String getBookInfo(){
        return book;
    }

    public void setBookInfo(){
//        notifyPropertyChanged(BR.book);
    }
}
