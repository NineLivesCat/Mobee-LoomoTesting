package com.test.loomo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    TextView address;
    Button submit;
    Socket s = null;
    PrintWriter writer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = (TextView)findViewById(R.id.IP);
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackGroundTask b1 = new BackGroundTask();
                b1.execute();
            }
        });
    }

    class BackGroundTask extends AsyncTask<String, Void, Void> {

        Handler h = new Handler();
        @Override
        protected Void doInBackground(String... voids) {
            try {
                if(s == null){
                    //change it to your IP
                    s = new Socket(address.getText().toString(),6000);
                    writer = new PrintWriter(s.getOutputStream());
                }
                writer.write("Testing1...");
                writer.flush();
                writer.write("Testing2...");
                writer.flush();
                writer.write("Testing3...");
                writer.flush();
                writer.write("Testing4...");
                writer.flush();
                writer.write("Testing5...");
                writer.flush();
                //writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}