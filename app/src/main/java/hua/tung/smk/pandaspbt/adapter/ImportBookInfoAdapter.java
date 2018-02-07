package hua.tung.smk.pandaspbt.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hua.tung.smk.pandaspbt.BR;
import hua.tung.smk.pandaspbt.R;
import hua.tung.smk.pandaspbt.databinding.ItemBookInfoBinding;

/**
 * Created by User on 21/12/2017.
 */

//https://medium.com/google-developers/android-data-binding-recyclerview-db7c40d9f0e4

public abstract class ImportBookInfoAdapter extends RecyclerView.Adapter<ImportBookInfoAdapter.MyViewHolder>{

    TextView textView;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemBookInfoBinding itemBookInfoBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_book_info, parent, false);
        return new MyViewHolder(itemBookInfoBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Object object = getObjForPosition(position);
        holder.bind(object);

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ItemBookInfoBinding bookInfoBinding;

        public MyViewHolder(View view) {
            super(view);
            this.bookInfoBinding = DataBindingUtil.bind(view);
        }

        public void bind(Object obj) {
            bookInfoBinding.setVariable(BR.bookInfo, obj);
            bookInfoBinding.executePendingBindings();
        }

    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);
}
