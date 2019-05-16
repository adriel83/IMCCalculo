package com.example.calculoimc;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
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
    EditText peso;
    TextView tituloResultado;
    TextView txIdeal;
    Pessoa pessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pessoa = new Pessoa();
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.botaoCalcula);
        altura = findViewById(R.id.inputAltura);
        peso = findViewById(R.id.inputAltura);
        altura.addTextChangedListener(watcher);
        peso.addTextChangedListener(watcher);
        tituloResultado = findViewById(R.id.txIdeal);
        mas = findViewById(R.id.radioMasculino);
        fem = findViewById(R.id.radioFeminino);
        rd = findViewById(R.id.radioGroup);
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
        pessoa.setPeso(Double.valueOf(peso.getText().toString()));
        Double imc = (pessoa.getPeso())/Math.pow(2, pessoa.getAltura());
        pessoa.setImc(imc);
        tituloResultado.setVisibility(View.VISIBLE);
        if(imc <= 17){
//            tituloResultado.setTextColor();
            tituloResultado.setShadowLayer(0,0,0,Color.WHITE);
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nMuito abaixo do peso");
            spannable.setSpan(new ForegroundColorSpan(Color.RED),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(imc > 17 && imc <= 18.49){
            tituloResultado.setTextColor(Color.YELLOW);
            tituloResultado.setShadowLayer(1.6f,1.5f,1.3f,Color.BLACK);
            tituloResultado.setText("Abaixo do peso");
        }
        if(imc >= 18.5 && imc <= 24.99){
            tituloResultado.setTextColor(Color.GREEN);
            tituloResultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Peso Normal");
        }
        if(imc >= 25 && imc <= 29.99){
            tituloResultado.setTextColor(Color.YELLOW);
            tituloResultado.setShadowLayer(1.6f,1.5f,1.3f,Color.BLACK);
            tituloResultado.setText("Acima do peso");
        }
        if(imc >= 30 && imc <= 34.99){
            tituloResultado.setTextColor(Color.RED);
            tituloResultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade I");
        }
        if(imc >= 35 && imc <= 39.99){
            tituloResultado.setTextColor(Color.rgb(200, 0 ,0));
            tituloResultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade II (severa)");
        }
        if(imc >= 40){
            tituloResultado.setTextColor(Color.rgb(175, 0 ,0));
            tituloResultado.setShadowLayer(0,0,0,Color.WHITE);
            tituloResultado.setText("Obesidade III (mórbida)");
        }
//        if(rd.getCheckedRadioButtonId() == mas.getId()){
//            double ps = (72.7 * pessoa.getAltura() -58);
//            ps = (double) Math.round(ps * 100) / 100;
//            pesoIdeal.setText(String.valueOf(ps));
//            pesoIdeal.setVisibility(View.VISIBLE);
//            txIdeal.setVisibility(View.VISIBLE);
//        }
//        if(rd.getCheckedRadioButtonId() == fem.getId()){
//            double ps = (62.1 * pessoa.getAltura() - 44.7);
//            ps = (double) Math.round(ps * 100) / 100;
//            pesoIdeal.setText(String.valueOf(ps));
//            pesoIdeal.setVisibility(View.VISIBLE);
//            txIdeal.setVisibility(View.VISIBLE);
//        }
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
            if (!(altura.getText().toString().length() == 0 || peso.getText().toString().length() == 0)) {
                bt.setEnabled(true);
            }else{
                bt.setEnabled(false);
            }
        }
    };
}
