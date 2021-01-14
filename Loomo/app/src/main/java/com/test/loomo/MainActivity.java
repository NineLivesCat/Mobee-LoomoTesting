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
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    TextView address;
    Button submit;
    Socket s = null;
    PrintWriter writer = null;
    BufferedReader br = null;
    InputStreamReader isr;
    Thread t;
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
                //address.setText("message");
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
                    writer.write("Connected\n");
                    writer.flush();
                    address.setText("message");
                    /*t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                isr = new InputStreamReader(s.getInputStream());
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                            // Start reading
                            while (true) {
                                br = new BufferedReader(isr);
                                try{
                                    //address.setText(message);
                                    String message = br.readLine().toString();
                                    address.setText(message);
                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }
//                                Thread.sleep(10);
                            }
                        }
                    });
                    t.start();*/
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


    }


    }
