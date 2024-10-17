package com.example.android;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = findViewById(R.id.progressBar);


        Button myBtn = findViewById(R.id.longBtn);
        myBtn.setOnClickListener(view -> {
            Toast.makeText(this, "You have successfully logged in \uD83E\uDEE0", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        });

        Thread thread = new Thread(() -> {
            ProgressBar myHoriBar = findViewById(R.id.horiProg);
            for(int i = 0; i<=10;i++){
                myHoriBar.incrementProgressBy(i*10);
                SystemClock.sleep(1000);
            }

        });

        Button myBarBtn = findViewById(R.id.startBar);

        myBarBtn.setOnClickListener(view -> {
            thread.start();
        });


//On Long Click Event Listener
        myBtn.setOnLongClickListener(v -> {
            // Show a Toast message when the button is long-clicked
            Toast.makeText(MainActivity.this, "Don't Long Click me pall", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.VISIBLE);
            return true; // Return true to indicate the event is consumed
        });


        Button submit = findViewById(R.id.submitBtn);

        submit.setOnClickListener(view -> {
            TextView display = findViewById(R.id.showText);
            String msg = "Hurray! Finally you have submitted your work";
            display.setText(msg);

            //Checkbox for CitizenShip
            CheckBox myCheckBox = findViewById(R.id.checkState);

            if (myCheckBox.isChecked()) {
                Toast.makeText(this, "Kenya Hatuhami \uD83E\uDD23", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wee Mzee, wewe ni wa wapi?", Toast.LENGTH_LONG).show();
            }

        });


    }

    public void handleSend(View view) {


        RadioButton male,female,gay;

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        gay = findViewById(R.id.gay);


        if(male.isChecked()){
            Toast.makeText(this, "Rada Mzee", Toast.LENGTH_SHORT).show();
        } else if (female.isChecked()) {
            Toast.makeText(this, "Hello lovely lady", Toast.LENGTH_SHORT).show();
        }
        else if(gay.isChecked()){
            Toast.makeText(this, "Why are you gay", Toast.LENGTH_SHORT).show();
        }

    }




}