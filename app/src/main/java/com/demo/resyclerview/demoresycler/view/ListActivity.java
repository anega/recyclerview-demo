package com.demo.resyclerview.demoresycler.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.resyclerview.demoresycler.R;
import com.demo.resyclerview.demoresycler.data.FakeDataSource;
import com.demo.resyclerview.demoresycler.data.ListItem;
import com.demo.resyclerview.demoresycler.logic.Controller;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface {
    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private List<ListItem> listOfData;
    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rv_list_activity);
        layoutInflater = getLayoutInflater();
        controller = new Controller(this, new FakeDataSource());
    }

    @Override
    public void startDetailActivity(String dateAndTime, String message, int colorResource) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_DATE_AND_TIME, dateAndTime);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_COLOR, colorResource);

        startActivity(intent);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ListItem currItem = listOfData.get(position);
            holder.coloredCircle.setBackgroundResource(currItem.getColorResource());
            holder.message.setText(currItem.getMessage());
            holder.dataAndTime.setText(currItem.getDateTime());
        }

        @Override
        public int getItemCount() {
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private View coloredCircle;
            private TextView dataAndTime;
            private TextView message;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);

                this.coloredCircle = itemView.findViewById(R.id.iv_list_item_circle);
                this.dataAndTime = itemView.findViewById(R.id.tv_date_time);
                this.message = itemView.findViewById(R.id.tv_message);
                this.container = itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                ListItem listItem = listOfData.get(this.getAdapterPosition());
                controller.onListItemClick(listItem);
            }
        }
    }
}
