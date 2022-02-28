package pl.com.kamil.widgetprobakolejna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    String text ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSave = findViewById(R.id.button);
        Button buttonLoad = findViewById(R.id.button2);
        EditText textNote = findViewById(R.id.editTextTextPersonName);
        TextView textView = findViewById(R.id.textView);
        Context context = this;
        MainActivityViewModel viewmodel =new ViewModelProvider(this).get(MainActivityViewModel.class);
        textView.setText(viewmodel.text);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.setText();
                textView.setText(viewmodel.text);

                String filename = "note";
                File file = new File(context.getFilesDir(), filename);
                String tekst = text;
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(tekst);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String text = "";
                    String filename = "note";
                    File file = new File(context.getFilesDir(), filename);
                    Scanner sc = new Scanner(file);
                    while(sc.hasNext()){
                        text += sc.nextInt();
                    }
                    textView.setText(text);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}