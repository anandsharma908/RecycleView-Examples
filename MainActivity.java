package com.example.muneeb.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < Data.nameArray.length; i++) {
            data.add(new DataModel(
                    Data.nameArray[i],
                    Data.contactArray[i]
            ));
        }

        adapter = new Adapter(data);
        recyclerView.setAdapter(adapter);
    }


    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            getItem(v);
        }

        private void getItem(View v)
        {
            int itemS=recyclerView.getChildAdapterPosition(v);
            RecyclerView.ViewHolder viewHolder =recyclerView.findViewHolderForAdapterPosition(itemS);
            TextView Name = (TextView) viewHolder.itemView.findViewById(R.id.Name);
            String SelectedName=(String) Name.getText();

            Toast.makeText(MainActivity.this, SelectedName, Toast.LENGTH_SHORT).show();
        }

    }

}
