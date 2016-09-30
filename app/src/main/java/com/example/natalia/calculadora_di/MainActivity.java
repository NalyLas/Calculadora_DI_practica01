package com.example.natalia.calculadora_di;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView pantalla;
    Double memory=0.00;
    Double bubble=0.00;
    Double resultado=0.00;
    String signo="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pantalla=(TextView) findViewById(R.id.tvPantalla);
    }

    public void leeNum(View view){
            TextView num = (TextView) findViewById (view.getId());
            String act = pantalla.getText().toString();

        if(pantalla.getText().toString().equals("0")){
                pantalla.setText(num.getText());
            }else if(num.getText().toString().equals(".") && !act.contains(".")){
                pantalla.append(".");
            }else if(pantalla.getText().toString().equals("Infinity")){
                pantalla.setText(num.getText());
            }else{
                pantalla.append(num.getText());
            }

    }


    public void leeSigno(View view){
            TextView sign = (TextView) findViewById (view.getId());
            signo = sign.getText().toString();
            if(pantalla.getText().toString().equals("")){
                pantalla.setText("0");
            }
            if(bubble==0){
                bubble = Double.parseDouble(pantalla.getText().toString());
            }else{
                if(signo.equals("+")){
                    bubble += Double.parseDouble(pantalla.getText().toString());
                }else if(signo.equals("-")){
                    bubble -= Double.parseDouble(pantalla.getText().toString());
                }else if(signo.equals("x")){
                    bubble *= Double.parseDouble(pantalla.getText().toString());
                }else if(signo.equals("/")){
                    bubble /= Double.parseDouble(pantalla.getText().toString());
                }

            }

            pantalla.setText("");
    }

    public void leeMemoria(View view){
        TextView mem = (TextView) findViewById (view.getId());
        String m;
        if(mem.getText().equals("M")){
            if(pantalla.getText().toString().equals("0") || pantalla.getText().toString().equals("")){
                m = memory.toString();
                pantalla.setText(m);
            }else{
                memory = Double.parseDouble(pantalla.getText().toString());
                pantalla.setText("");
            }
        }
    }

    public void borraMemoria(View view){
        memory = 0.00;
    }

    public void borrarTodo(View view){
            bubble = 0.00;
            resultado = 0.00;
            pantalla.setText("0");
    }

    public void borrar(View view){
        if(pantalla.getText().toString().equals("0") || pantalla.getText().toString().equals("") ){
            pantalla.setText("0");
        }else{
            String numeros = pantalla.getText().toString();
            numeros = numeros.substring(0,numeros.length()-1);
            pantalla.setText(numeros+"");
        }

    }

    public void calcular(View view){
        String res;
        if(signo.equals("+")){
                resultado = bubble + Double.parseDouble(pantalla.getText().toString());
            }else if(signo.equals("-")){
                resultado = bubble - Double.parseDouble(pantalla.getText().toString());
            }else if(signo.equals("x")){
                resultado = bubble * Double.parseDouble(pantalla.getText().toString());
            }else if(signo.equals("/")){
                resultado = bubble / Double.parseDouble(pantalla.getText().toString());
            }
            bubble = 0.00;
            res = resultado.toString();
            pantalla.setText(res);

    }


}
