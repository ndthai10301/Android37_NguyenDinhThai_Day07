package com.example.btvnday07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddInformation extends AppCompatActivity {
    String mName;
    EditText tvName;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);
        setTitle("Add Information");
        tvName=findViewById(R.id.tvName);
        btnSave=findViewById(R.id.btnSave);
        final Intent intent = getIntent();
        mName = intent.getStringExtra("name");
        if (mName.equals("")) btnSave.setText("Add");
        else {
            btnSave.setText("Update");
            tvName.setText(mName);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("nameAdd", tvName.getText().toString());

                //trả về kết quả Result cho mainActivity
                setResult(RESULT_OK, intent1);
                finish();
            }
        });

    }
}
