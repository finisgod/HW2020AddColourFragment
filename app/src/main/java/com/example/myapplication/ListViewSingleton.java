package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

class ListViewSingleton {
    private List<ListViewNumber> mData;

    private static final ListViewSingleton sInstance = new ListViewSingleton();

    static ListViewSingleton getInstance() {
        return sInstance;
    }

    private ListViewSingleton() {
        mData = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            mData.add(new ListViewNumber(i));
        }
    }

    List<ListViewNumber> getData() {
        return mData;
    }

    void addNumber(int i) {
        mData.add(new ListViewNumber(i));
    }

    void restoreState(int size) {
        if (size > 100 && mData.size() == 100) {
            for (int i = 101; i <= size; i++) {
                mData.add(new ListViewNumber(i));
            }
        }
    }

}