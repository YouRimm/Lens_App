package com.example.lens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);


        final String[] mid = {"컬러렌즈", "렌즈액", "렌즈액", "렌즈액", "렌즈액", "렌즈액", "렌즈액",
                };

        ListView list = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_multiple_choice, mid);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_LONG).show();
            }
        });

    /*private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.activity_listview_item, null);
            }

            // ImageView 인스턴스
            ImageView imageView = (ImageView)v.findViewById(R.id.imageView);

            // 리스트뷰의 아이템에 이미지를 변경한다.
            if("Seoul".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_clear2);
            else if("Busan".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_all);
            else if("Daegu".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_glass);
            else if("Jeju".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_color);


            TextView textView = (TextView)v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            final String text = items.get(position);
            Button button = (Button)v.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            });

            return v;
        }

    }*/

    }
}