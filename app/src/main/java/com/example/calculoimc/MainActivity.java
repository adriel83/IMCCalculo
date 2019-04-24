package com.example.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rd;
    Button bt;
    EditText altura;
    EditText massa;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rd = findViewById(R.id.radioGenero);
        bt = findViewById(R.id.botaoCalcula);
        altura = findViewById(R.id.inputAltura);
        massa = findViewById(R.id.inputMassa);
        resultado = findViewById(R.id.resultado);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaIMC();
            }
        });
    }
    public void calculaIMC(){
/*        if(rd.getCheckedRadioButtonId() == R.id.radioFeminino){

        }*/
        Double floatAltura = Double.valueOf(altura.getText().toString());
        Double floatMassa = Double.valueOf(massa.getText().toString());
        Double imc = (floatAltura/Math.pow(2, floatAltura));
        resultado.setText(imc.toString());
    }
}
