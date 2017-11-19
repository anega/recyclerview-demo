package com.demo.resyclerview.demoresycler.data;

public class ListItem {
    private final String mDateTime;
    private final String mMessage;
    private final int mColorResource;

    public ListItem(String dateTime, String message, int colorResource) {
        this.mDateTime = dateTime;
        this.mMessage = message;
        this.mColorResource = colorResource;
    }

    public String getDateTime() {
        return mDateTime;
    }

    public String getMessage() {
        return mMessage;
    }

    public int getColorResource() {
        return mColorResource;
    }
}
