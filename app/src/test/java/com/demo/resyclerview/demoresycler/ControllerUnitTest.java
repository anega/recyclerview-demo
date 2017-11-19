package com.demo.resyclerview.demoresycler;

import com.demo.resyclerview.demoresycler.data.DataSourceInterface;
import com.demo.resyclerview.demoresycler.data.ListItem;
import com.demo.resyclerview.demoresycler.logic.Controller;
import com.demo.resyclerview.demoresycler.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {
    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;
    Controller controller;
    private static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Check out content like Fragmented Podcast to expose yourself to the knowledge",
            R.color.RED
    );

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }

    @Test
    public void onGetListDataSuccessful() {
        // Set up any data we need for the Test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        // Set up our Mocks to return the Data we want
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        // Call the method we are testing
        controller.getListFromDataSource();

        // Check how the tested class responds to the data it receives
        // or test it behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}