package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainFragment extends Fragment {
    private ListViewAdapter mListViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OnItemSelectedListener callback;

    void setOnItemSelectedListener(OnItemSelectedListener callback) {
        this.callback = callback;
    }

    public MainFragment() {
        //
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ItemClickListener clickListener = new ItemClickListener() {
            @Override
            public void onItemClick(ListViewNumber item) {
                callback.onItemSelected(item);
            }
        };

        RecyclerView mRecyclerView = view.findViewById(R.id.list_view);
        Button mAddButton = view.findViewById(R.id.button_add);

        final int columns = getResources().getInteger(R.integer.columns_count);
        mLayoutManager = new GridLayoutManager(getContext(), columns);

        mListViewAdapter = new ListViewAdapter(ListViewSingleton.getInstance().getData(), clickListener);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mListViewAdapter);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ListViewNumber> list = ListViewSingleton.getInstance().getData();
                ListViewNumber prev = list.get(list.size() - 1);
                ListViewSingleton.getInstance().addNumber(prev.getmNumber() + 1);
                mListViewAdapter.notifyItemInserted(list.size() - 1);
            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}