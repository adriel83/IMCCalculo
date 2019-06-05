package com.example.calculoimc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
//TODO: Máscara na Altura, PS: Não se acessa um botão de uma activity em outra activity.....duh.
public class MainActivity extends AppCompatActivity {
//    Button bt;
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
        altura = findViewById(R.id.inputAltura);
//        bt = findViewById(R.id.idCalculaIMC);
        peso = findViewById(R.id.inputPeso);
        altura.addTextChangedListener(watcher);
        peso.addTextChangedListener(watcher);
        tituloResultado = findViewById(R.id.txResultado);
        mas = findViewById(R.id.radioMasculino);
        fem = findViewById(R.id.radioFeminino);
        rd = findViewById(R.id.radioGroup);
        txIdeal = findViewById(R.id.txIdeal);
    }
    public void calculaIMC(){
        pessoa.setAltura(Double.valueOf(altura.getText().toString()));
        pessoa.setPeso(Double.valueOf(peso.getText().toString()));
        Double imc = (pessoa.getPeso())/Math.pow(2, pessoa.getAltura());
        pessoa.setImc(imc);
        tituloResultado.setVisibility(View.VISIBLE);
        if(imc <= 17){
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nMuito abaixo do peso");
            spannable.setSpan(new ForegroundColorSpan(Color.RED),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(imc > 17 && imc <= 18.49){
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nAbaixo do peso");
            spannable.setSpan(new ForegroundColorSpan(Color.YELLOW),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(imc >= 18.5 && imc <= 24.99){
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nPeso Normal");
            spannable.setSpan(new ForegroundColorSpan(Color.GREEN),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(imc >= 25 && imc <= 29.99){
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nAcima do peso");
            spannable.setSpan(new ForegroundColorSpan(Color.YELLOW),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(imc >= 30 && imc <= 34.99){
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nObesidade I");
            spannable.setSpan(new ForegroundColorSpan(Color.RED),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(imc >= 35 && imc <= 39.99){
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nObesidade II (severa)");
            spannable.setSpan(new ForegroundColorSpan(Color.rgb(200, 0 ,0)),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(imc >= 40){
            String texto1 = "IMC:" + Double.toString(pessoa.getImc());
            Spannable spannable = new SpannableString(texto1 + "\nObesidade III (mórbida)");
            spannable.setSpan(new ForegroundColorSpan(Color.rgb(175, 0 ,0)),texto1.length(), spannable.length(),  Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tituloResultado.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        if(rd.getCheckedRadioButtonId() == mas.getId()){
            double ps = (72.7 * pessoa.getAltura() -58);
            ps = (double) Math.round(ps * 100) / 100;
            txIdeal.setText("Peso Ideal:"+String.valueOf(ps));
            txIdeal.setVisibility(View.VISIBLE);
        }
        if(rd.getCheckedRadioButtonId() == fem.getId()){
            double ps = (62.1 * pessoa.getAltura() - 44.7);
            ps = (double) Math.round(ps * 100) / 100;
            txIdeal.setText("Peso Ideal:"+String.valueOf(ps));
            txIdeal.setVisibility(View.VISIBLE);
        }
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(bt.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

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
//                bt.setEnabled(true);
            }else{
//                bt.setEnabled(false);
            }
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater in = getMenuInflater();
        in.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.idConsultaIMC:
//                    Intent it = new Intent(this, PesquisaActivity.class);
//                    startActivity(it);
                return true;

            case R.id.idCalculaIMC:
                calculaIMC();
        }
        return super.onOptionsItemSelected(item);
    }

}
