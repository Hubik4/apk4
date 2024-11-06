package com.example.kosci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button rzut;
    private Button reset;
    private TextView kosc1, kosc2, kosc3, kosc4, kosc5;
    private TextView wynik, wynik_gry, liczba_rzutow;
    private int liczbaRzutow = 0;
    private int wynikGry = 0;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Ustawienie layoutu z XML


        rzut = findViewById(R.id.rzut);
        reset = findViewById(R.id.reset);
        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);
        wynik = findViewById(R.id.wynik);
        wynik_gry = findViewById(R.id.wynik_gry);
        liczba_rzutow = findViewById(R.id.liczba_rzutow);


        rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liczbaRzutow++;
                liczba_rzutow.setText("Liczba rzutów: " + liczbaRzutow);

                // Rzut 5 kośćmi i zaktualizowanie wyników
                int[] wyniki = new int[5];
                int sumaRzutu = 0;
                wyniki[0] = random.nextInt(6) + 1;
                wyniki[1] = random.nextInt(6) + 1;
                wyniki[2] = random.nextInt(6) + 1;
                wyniki[3] = random.nextInt(6) + 1;
                wyniki[4] = random.nextInt(6) + 1;

                // Obliczenie sumy wyników rzutów
                for (int i = 0; i < 5; i++) {
                    sumaRzutu += wyniki[i];
                }

                // Aktualizacja wyświetlanych wyników rzutów
                kosc1.setText(String.valueOf(wyniki[0]));
                kosc2.setText(String.valueOf(wyniki[1]));
                kosc3.setText(String.valueOf(wyniki[2]));
                kosc4.setText(String.valueOf(wyniki[3]));
                kosc5.setText(String.valueOf(wyniki[4]));

                // Wyświetlanie wyniku tego losowania i wyniku gry
                wynik.setText("Wynik tego losowania: " + sumaRzutu);
                wynikGry += sumaRzutu;
                wynik_gry.setText("Wynik gry: " + wynikGry);
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Resetowanie gry
                kosc1.setText("?");
                kosc2.setText("?");
                kosc3.setText("?");
                kosc4.setText("?");
                kosc5.setText("?");
                wynik.setText("Wynik losowania:");
                wynik_gry.setText("Wynik gry: ");
                liczba_rzutow.setText("Liczba rzutów: 0");
                liczbaRzutow = 0;
                wynikGry = 0;
            }
        });
    }
}
