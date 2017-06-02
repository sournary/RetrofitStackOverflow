package com.example.sournary.retrofitstackoverflow.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sournary.retrofitstackoverflow.DetailActivity;
import com.example.sournary.retrofitstackoverflow.R;
import com.example.sournary.retrofitstackoverflow.model.Item;

import java.util.List;

/**
 * Created by sournary on 02/06/2017.
 */

public class StackexchangeAdapter extends RecyclerView.Adapter<StackexchangeAdapter.ItemHolder> implements View.OnClickListener {

    public static final String ITEM_EXTRA = "item";
    private List<Item> itemList;
    private Context mContext;
    private Item item;

    public StackexchangeAdapter(Context mContext, List<Item> itemList) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    public void updateData(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stackexchange, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        item = itemList.get(position);
        holder.onBindView(item.getOwner().getLink(), item.getOwner().getDisplayName());
        holder.mTitleTv.setOnClickListener(this);
        holder.mlinkTv.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onClick(View v) {
        showDetails(mContext);
    }

    private void showDetails(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(ITEM_EXTRA, item);
        mContext.startActivity(intent);
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        TextView mlinkTv;
        TextView mTitleTv;

        ItemHolder(View itemView) {
            super(itemView);
            mlinkTv = (TextView) itemView.findViewById(R.id.link);
            mTitleTv = (TextView) itemView.findViewById(R.id.title);
        }


        void onBindView(String link, String title) {
            mlinkTv.setText(link);
            mTitleTv.setText(title);
        }

    }


}
