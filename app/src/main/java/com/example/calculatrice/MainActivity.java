package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView operation;
    TextView resultat;
    String ope = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = findViewById(R.id.operation);
        resultat = findViewById(R.id.resultat);
    }

    public void setOperation(String getvalue) {
        ope = ope + getvalue;
        operation.setText(ope);

    }


    public void clearOnclick(View view) {
        operation.setText("");
        ope="";
        resultat.setText("");
        leftBracket = true;
    }

    boolean leftBracket = true;
    public void bracketsOnClick(View view) {
        if (leftBracket){
            setOperation("(");
            leftBracket=false;
        }
        else{
            setOperation(")");
            leftBracket=true;
        }

    }

    public void powerOfOnClick(View view) {
    }

    public void divisionOnClick(View view) {
        setOperation("/");

    }

    public void sevenOnClick(View view) {
        setOperation("7");
    }

    public void eightOnClick(View view) {
        setOperation("8");
    }

    public void nineOnClick(View view) {
        setOperation("9");
    }

    public void timesOnClick(View view) {
        setOperation("*");
    }

    public void fourOnClick(View view) {
        setOperation("4");
    }

    public void fiveOnClick(View view) {
        setOperation("5");
    }

    public void sixOnClick(View view) {
        setOperation("6");
    }

    public void minusOnClick(View view) {
        setOperation("-");
    }

    public void oneOnClick(View view) {
        setOperation("1");
    }

    public void twoOnClick(View view) {
        setOperation("2");
    }

    public void threeOnClick(View view) {
        setOperation("3");
    }

    public void plusOnClick(View view) {
        setOperation("+");
    }

    public void decimalOnClick(View view) {
        setOperation(".");
    }

    public void zeroOnClick(View view) {
        setOperation("0");
    }

    public void equalsOnClick(View view) {

        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        Toast.makeText(this, "TestToast", Toast.LENGTH_SHORT).show();
        try {
            result = (double)engine.eval(ope);
        } catch (ScriptException e)
        {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            resultat.setText(String.valueOf(result.doubleValue()));
    }
}



