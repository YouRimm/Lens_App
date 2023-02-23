package com.example.lens;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CommActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm);

        String[] items = {"후기1", "후기2", "후기3", "후기4", "후기5", "후기6", "후기7"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView board = (ListView) findViewById(R.id.list_com);
        board.setAdapter(adapter);

        //리스트의 아이템 클릭되는 부분 //구현?
        board.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String item = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(CommActivity.this, item, Toast.LENGTH_SHORT).show();
                    }
                }//OnItemClickListener
        );//OnItemClickListener

        Button page_write = (Button) findViewById(R.id.btn_write);
        page_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate
}