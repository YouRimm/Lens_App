package com.example.lens;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {

    Button btn_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        btn_post = (Button) findViewById(R.id.btn_post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(WriteActivity.this);
                dlg.setTitle("Lens앱");
                dlg.setMessage("후기가 작성되었습니다.");
                dlg.setIcon(R.drawable.acuvue1);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"등록이 완료되었습니다", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                });
                dlg.show();

            }
        });
    }//OnCreate
}