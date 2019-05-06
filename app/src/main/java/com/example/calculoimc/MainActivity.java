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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
//TODO: Máscara na Altura.
public class MainActivity extends AppCompatActivity {
    Button bt;
    RadioGroup rd;
    RadioButton mas;
    RadioButton fem;
    EditText altura;
    EditText massa;
    TextView resultado;
    TextView tituloResultado;
    TextView pesoIdeal;
    TextView txIdeal;
    Pessoa pessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pessoa = new Pessoa();
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.botaoCalcula);
        altura = findViewById(R.id.inputAltura);
        massa = findViewById(R.id.inputPeso);
        altura.addTextChangedListener(watcher);
        massa.addTextChangedListener(watcher);
        resultado = findViewById(R.id.resultado);
        tituloResultado = findViewById(R.id.txResultado);
        mas = findViewById(R.id.radioMasculino);
        fem = findViewById(R.id.radioFeminino);
        rd = findViewById(R.id.radioGroup);
        pesoIdeal = findViewById(R.id.resuIdeal);
        txIdeal = findViewById(R.id.txIdeal);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaIMC();
            }
        });
    }
    public void calculaIMC(){
        pessoa.setAltura(Double.valueOf(altura.getText().toString()));
        pessoa.setPeso(Double.valueOf(massa.getText().toString()));
        Double imc = (pessoa.getPeso())/Math.pow(2, pessoa.getAltura());
        pessoa.setImc(imc);
        resultado.setText(Double.toString(pessoa.getImc()));
        resultado.setVisibility(View.VISIBLE);
        tituloResultado.setVisibility(View.VISIBLE);
        if(imc <= 17){
            resultado.setTextColor(Color.GRAY);
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Muito abaixo do peso");
        }
        if(imc > 17 && imc <= 18.49){
            resultado.setTextColor(Color.YELLOW);
            resultado.setShadowLayer(1.6f,1.5f,1.3f,Color.BLACK);
            tituloResultado.setText("Abaixo do peso");
        }
        if(imc >= 18.5 && imc <= 24.99){
            resultado.setTextColor(Color.GREEN);
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Peso Normal");
        }
        if(imc >= 25 && imc <= 29.99){
            resultado.setTextColor(Color.YELLOW);
            resultado.setShadowLayer(1.6f,1.5f,1.3f,Color.BLACK);
            tituloResultado.setText("Acima do peso");
        }
        if(imc >= 30 && imc <= 34.99){
            resultado.setTextColor(Color.RED);
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade I");
        }
        if(imc >= 35 && imc <= 39.99){
            resultado.setTextColor(Color.rgb(200, 0 ,0));
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade II (severa)");
        }
        if(imc >= 40){
            resultado.setTextColor(Color.rgb(175, 0 ,0));
            resultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade III (mórbida)");
        }
        if(rd.getCheckedRadioButtonId() == mas.getId()){
            double ps = (72.7 * pessoa.getAltura() -58);
            ps = (double) Math.round(ps * 100) / 100;
            pesoIdeal.setText(String.valueOf(ps));
            pesoIdeal.setVisibility(View.VISIBLE);
            txIdeal.setVisibility(View.VISIBLE);
        }
        if(rd.getCheckedRadioButtonId() == fem.getId()){
            double ps = (62.1 * pessoa.getAltura() - 44.7);
            ps = (double) Math.round(ps * 100) / 100;
            pesoIdeal.setText(String.valueOf(ps));
            pesoIdeal.setVisibility(View.VISIBLE);
            txIdeal.setVisibility(View.VISIBLE);
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
