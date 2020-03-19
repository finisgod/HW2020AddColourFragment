package com.example.myapplication;


import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private List<ListViewNumber> mNumbers;
    private ItemClickListener mClickListener;


    ListViewAdapter(@NonNull List<ListViewNumber> numbers, ItemClickListener clickListener) {
        this.mNumbers = numbers;
        this.mClickListener = clickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListViewNumber current = mNumbers.get(position);
        if (current != null) {
            holder.getListItemView().setText(current.toString());
            ListViewNumber validCurrent = mNumbers.get(holder.getAdapterPosition());
            holder.bind(validCurrent, mClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return mNumbers.size();
    }
}