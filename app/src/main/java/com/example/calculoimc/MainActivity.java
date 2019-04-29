package com.example.calculoimc;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText altura;
    EditText massa;
    TextView resultado;
    TextView tituloResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.botaoCalcula);
        altura = findViewById(R.id.inputAltura);
        massa = findViewById(R.id.inputMassa);
        altura.addTextChangedListener(watcher);
        massa.addTextChangedListener(watcher);
        resultado = findViewById(R.id.resultado);
        tituloResultado = findViewById(R.id.txResultado);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaIMC();
            }
        });
    }
    public void calculaIMC(){
        Double floatAltura = Double.valueOf(altura.getText().toString());
        Double floatMassa = Double.valueOf(massa.getText().toString());
        Double imc = (floatMassa)/Math.pow(2, floatAltura);
        Double imcRound = (double) Math.round(imc * 100) / 100;
        resultado.setText(imcRound.toString());
        resultado.setVisibility(View.VISIBLE);
        tituloResultado.setVisibility(View.VISIBLE);
        if(imcRound <= 17){
            resultado.setTextColor(Color.GRAY);
            resultado.setBackgroundColor(Color.WHITE);
            tituloResultado.setText("Muito abaixo do peso");
        }
        if(imcRound > 17 && imcRound <= 18.49){
            resultado.setTextColor(Color.YELLOW);
            resultado.setShadowLayer(1.6f,1.5f,1.3f,Color.BLACK);
            tituloResultado.setText("Abaixo do peso");
        }
        if(imcRound >= 18.5 && imcRound <= 24.99){
            resultado.setTextColor(Color.GREEN);
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Peso Normal");
        }
        if(imcRound >= 25 && imcRound <= 29.99){
            resultado.setTextColor(Color.YELLOW);
            resultado.setShadowLayer(1.6f,1.5f,1.3f,Color.BLACK);
            tituloResultado.setText("Acima do peso");
        }
        if(imcRound >= 30 && imcRound <= 34.99){
            resultado.setTextColor(Color.RED);
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade I");
        }
        if(imcRound >= 35 && imcRound <= 39.99){
            resultado.setTextColor(Color.rgb(200, 0 ,0));
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade II (severa)");
        }
        if(imcRound >= 40){
            resultado.setTextColor(Color.rgb(175, 0 ,0));
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade III (mórbida)");
        }
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(bt.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

    }
    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        { }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {}
        @Override
        public void afterTextChanged(Editable s) {
            if (!(altura.getText().toString().length() == 0 || massa.getText().toString().length() == 0)) {
                bt.setEnabled(true);
            }else{
                bt.setEnabled(false);
            }
        }
    };
}
