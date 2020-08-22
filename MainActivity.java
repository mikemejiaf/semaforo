package com.example.semaforo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etp, etf, eth;
    private TextView tv1;
    private Spinner spinner1;

    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni, sDayWeek;
    private String mDayWeek;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etp = (EditText)findViewById(R.id.txt_Placa);
        etf = (EditText)findViewById(R.id.txt_fecha);
        eth = (EditText)findViewById(R.id.txt_hora);
        tv1 = (TextView)findViewById(R.id.txt_result);
        spinner1 = (Spinner)findViewById(R.id.spinner);

        etf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            };
            });
        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        sDayWeek = C.get(Calendar.DAY_OF_WEEK);

        String [] opciones = {"Rojo","Amarillo","Verde"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>( this , android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    sDayWeek = C.get(Calendar.DAY_OF_WEEK);

                    switch (sDayWeek){
                        case 1: mDayWeek = "Dom";
                            break;
                        case 2: mDayWeek = "Lun";
                            break;
                        case 3: mDayWeek = "Mar";
                            break;
                        case 4: mDayWeek = "Mier";
                            break;
                        case 5: mDayWeek = "Jue";
                            break;
                        case 6: mDayWeek = "Vier";
                            break;
                        case 7: mDayWeek = "Sab";
                            break;
                    }
                    colocar_fecha();
                }
            };

    private void colocar_fecha() {
        etf.setText(mDayWeek + ", " + mDayIni + "-" + (mMonthIni + 1) + "-" + mYearIni+" ");
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }

    //Método para el botón
    public void onClickStart(View view)
    {
        String placa = etp.getText().toString();
        String hora = eth.getText().toString();
        String seleccion = spinner1.getSelectedItem().toString();
        String result = "";

        String ultimo = placa.substring(placa.length() -1);
        Integer ult = Integer.parseInt(ultimo);
        //tv1.setText(ultimo);
        //System.out.println(ult);
        String h = hora.substring(0,2);
        tv1.setText(h);

        if(placa.length() == 0){
            Toast.makeText(this, "Se debe ingresar la Placa", Toast.LENGTH_LONG).show();
        }
        if(placa.length() != 7){
            Toast.makeText(this, "Se debe ingresar 7 dígitos de la Placa", Toast.LENGTH_LONG).show();
        }

        if(seleccion.equals("Rojo")){
            if((ult == 1) || (ult == 2)){
                switch (mDayWeek){
                    case "Lun" : result = "Puede circular normalmente.";
                        break;
                    case "Mar" : result = "No puede circular.";
                        break;
                    case "Mier" : result = "No puede circular.";
                        break;
                    case "Jue" : result = "No puede circular.";
                        break;
                    case "Vier" : result = "No puede circular.";
                        break;
                    case "Sab" : result = "No puede circular.";
                        break;
                    case "Dom" : result = "No puede circular.";
                        break;
                }
            }else if((ult == 3) || (ult == 4)){
                switch (mDayWeek){
                    case "Lun" : result = "No puede circular.";
                        break;
                    case "Mar" : result = "Puede circular normalmente.";
                        break;
                    case "Mier" : result = "No puede circular.";
                        break;
                    case "Jue" : result = "No puede circular.";
                        break;
                    case "Vier" : result = "No puede circular.";
                        break;
                    case "Sab" : result = "No puede circular.";
                        break;
                    case "Dom" : result = "No puede circular.";
                        break;
                }
            } else if((ult == 5) || (ult == 6)) {
                switch (mDayWeek) {
                    case "Lun":
                        result = "No puede circular.";
                        break;
                    case "Mar":
                        result = "No puede circular.";
                        break;
                    case "Mier":
                        result = "Puede circular normalmente.";
                        break;
                    case "Jue":
                        result = "No puede circular.";
                        break;
                    case "Vier":
                        result = "No puede circular.";
                        break;
                    case "Sab":
                        result = "No puede circular.";
                        break;
                    case "Dom":
                        result = "No puede circular.";
                        break;
                }
            } else if((ult == 7) || (ult == 8)) {
                switch (mDayWeek) {
                    case "Lun":
                        result = "No puede circular.";
                        break;
                    case "Mar":
                        result = "No puede circular.";
                        break;
                    case "Mier":
                        result = "No puede circular.";
                        break;
                    case "Jue":
                        result = "Puede circular normalmente.";
                        break;
                    case "Vier":
                        result = "No puede circular.";
                        break;
                    case "Sab":
                        result = "No puede circular.";
                        break;
                    case "Dom":
                        result = "No puede circular.";
                        break;
                }
            } else if((ult == 9) || (ult == 0)) {
                switch (mDayWeek) {
                    case "Lun":
                        result = "No puede circular.";
                        break;
                    case "Mar":
                        result = "No puede circular.";
                        break;
                    case "Mier":
                        result = "No puede circular.";
                        break;
                    case "Jue":
                        result = "No puede circular.";
                        break;
                    case "Vier":
                        result = "Puede circular normalmente.";
                        break;
                    case "Sab":
                        result = "No puede circular.";
                        break;
                    case "Dom":
                        result = "No puede circular.";
                        break;
                }
            }

        } else if(seleccion.equals("Amarillo")){
            if((ult%2==0){
                if((mDayWeek == "Mar") || (mDayWeek == "Jue" || (mDayWeek == "Sab"))){
                    result = "Puede circular normalmente.";
                } else{
                    result = "No puede circular.";
                    }
            } else if((mDayWeek == "Lun") || (mDayWeek == "Mie" || (mDayWeek == "Vie"))){
                result = "Puede circular normalmente.";
            } else{
                result = "No puede circular.";
            }
        }
        else if(seleccion.equals("Verde")){
            result = "Puede circular normalmente.";
        }
        tv1.setText(result);
    }
}