package pl.com.kamil.wizytowkaaletymrazembezmenubotosyf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;
        MainActivityViewModel viewmodel =new ViewModelProvider(this).get(MainActivityViewModel.class);

        Button buttonSave = findViewById(R.id.button);
        Button buttonLoad = findViewById(R.id.button2);
        TextView textView = findViewById(R.id.textView);
        TextView imienazwiskotv = findViewById(R.id.textView3);
        TextView zawodtv = findViewById(R.id.textView4);
        TextView nrtelefonutv = findViewById(R.id.textView5);
        TextView emailtv = findViewById(R.id.textView6);
        TextView strinternetowatv = findViewById(R.id.textView7);
        TextView textView2 = findViewById(R.id.textView8);
        TextView textView3 = findViewById(R.id.textView9);
        TextView textView4 = findViewById(R.id.textView10);
        TextView textView5 = findViewById(R.id.textView11);
        TextView textView6 = findViewById(R.id.textView12);
        TextView textView7 = findViewById(R.id.textView13);
        EditText imienazwiskoin = findViewById(R.id.imienazwisko);
        EditText zawodin = findViewById(R.id.zawod);
        EditText nrtelefonuin = findViewById(R.id.nrtelefonu);
        EditText emailin = findViewById(R.id.email);
        EditText strinternetowain = findViewById(R.id.stronainternetowa);

        imienazwiskotv.setText(viewmodel.imienazwisko);
        zawodtv.setText(viewmodel.zawod);
        nrtelefonutv.setText(viewmodel.nrtelefonu);
        emailtv.setText(viewmodel.email);
        strinternetowatv.setText(viewmodel.stronainternetowa);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String imienazwiskoget = String.valueOf(imienazwiskoin.getText());
                String zawodget = String.valueOf(zawodin.getText());
                String nrtelefonuget = String.valueOf(nrtelefonuin.getText());
                String emailget = String.valueOf(emailin.getText());
                String strinernetowaget = String.valueOf(strinternetowain.getText());
                String filename = "note";
                File file = new File(context.getFilesDir(), filename);
                String tekst = imienazwiskoget+","+zawodget+","+nrtelefonuget+","+emailget+","+strinernetowaget;
                viewmodel.imienazwisko = imienazwiskoget;
                viewmodel.zawod = zawodget;
                viewmodel.nrtelefonu = nrtelefonuget;
                viewmodel.email = emailget;
                viewmodel.stronainternetowa = emailget;
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
                        text += sc.nextLine();
                    }
                    String[] dane = text.split(",");
                    imienazwiskotv.setText(dane[0]);
                    zawodtv.setText(dane[1]);
                    nrtelefonutv.setText(dane[2]);
                    emailtv.setText(dane[3]);
                    strinternetowatv.setText(dane[4]);
                    viewmodel.imienazwisko = dane[0];
                    viewmodel.zawod = dane[1];
                    viewmodel.nrtelefonu = dane[2];
                    viewmodel.email = dane[3];
                    viewmodel.stronainternetowa = dane[4];

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}