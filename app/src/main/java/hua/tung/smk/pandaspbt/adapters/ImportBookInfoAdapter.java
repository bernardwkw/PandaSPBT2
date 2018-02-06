package hua.tung.smk.pandaspbt.adapters;

import android.content.ClipData;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hua.tung.smk.pandaspbt.R;
import hua.tung.smk.pandaspbt.databinding.ItemBookInfoBinding;

/**
 * Created by User on 21/12/2017.
 */

public class ImportBookInfoAdapter extends RecyclerView.Adapter{


    @Override
    public ImportBookInfoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBookInfoBinding itemBookInfoBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_book_info,
                        parent,false );

        return new ;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ItemBookInfoBinding itemBookInfoBinding = ItemBookInfoBinding.inflate(, R.layout.item_book_info,view,false );

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
