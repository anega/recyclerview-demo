package com.demo.resyclerview.demoresycler.logic;

import com.demo.resyclerview.demoresycler.data.DataSourceInterface;
import com.demo.resyclerview.demoresycler.data.ListItem;
import com.demo.resyclerview.demoresycler.view.ViewInterface;

/**
 * Created by anega on 11/19/17.
 */

public class Controller {
    private ViewInterface mView;
    private DataSourceInterface mDataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.mView = view;
        this.mDataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        mView.setUpAdapterAndView(
                mDataSource.getListOfData()
        );
    }

    public void onListItemClick(ListItem testItem) {
        mView.startDetailActivity(
                testItem.getDateTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}
