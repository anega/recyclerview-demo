package com.demo.resyclerview.demoresycler.view;

import com.demo.resyclerview.demoresycler.data.ListItem;

import java.util.List;

/**
 * Created by anega on 11/19/17.
 */

public interface ViewInterface {
    void startDetailActivity(String dateAndTime, String message, int colorResource);
    void setUpAdapterAndView(List<ListItem> listOfData);
}
