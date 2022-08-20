package com.example.a3hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText editGmail;
    private EditText editTheme;
    private EditText editMessage;
//    private MaterialButton btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editGmail = findViewById(R.id.edit_gmail);
        editTheme = findViewById(R.id.edit_theme);
        editMessage = findViewById(R.id.edit_message);
        //btnSend.findViewById(R.id.btn_send);
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, editGmail.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, editTheme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, editMessage.getText());
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }
}