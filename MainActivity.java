package com.example.ejercicio_clase_java;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText nombre, valorcredito;
    RadioButton vivenda, educacion, libre, c1, c2, c3;
    CheckBox manejo;
    Button calcular, limpiar;
    TextView cuota, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar objetos instanciados

         nombre = findViewById(R.id.etnombre);
         valorcredito = findViewById(R.id.etvlrcredito);
         vivenda = findViewById(R.id.rbvivienda);
         educacion = findViewById(R.id.rbeducacion);
         libre = findViewById(R.id.rblibreinv);
         manejo = findViewById(R.id.cbcuotam);
         c1 = findViewById(R.id.rbc1);
         c2 = findViewById(R.id.rbc2);
         c3 = findViewById(R.id.rbc3);
         cuota = findViewById(R.id.tvvlrdeuda);
         total = findViewById(R.id.tvtotalpagar);
         calcular = findViewById(R.id.btncalcular);
         limpiar = findViewById(R.id.btnlimpiar);

         limpiar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 nombre.setText("");
                 valorcredito.setText("");
                 vivenda.setChecked(false);
                 educacion.setChecked(false);
                 libre.setChecked(false);
                 c1.setChecked(false);
                 c2.setChecked(false);
                 c3.setChecked(false);
                 manejo.setChecked(false);
                 total.setText("");
                 cuota.setText("");
                 nombre.requestFocus();

                 //calcular.setOnClickListener(this);

             }//onClick
         });//setonclicklistener


         calcular.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String mvalorcredito = valorcredito.getText().toString().trim();
                 String mnombre = nombre.getText().toString().trim();
                 double xvalorcredito = parseDouble(mvalorcredito);
                 double totalapagar = 0, ttp = 0, tot = 0;



                     if (!mnombre.equals("") && !mvalorcredito.equals("")){

                         double svalorcredito = parseDouble(valorcredito.getText().toString().trim());
                         String snombre = nombre.getText().toString().trim();


                         if (mnombre.isEmpty()){
                             Toast.makeText(getApplicationContext(), "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
                         }
                         else{

                             if (xvalorcredito >= 4000000 && xvalorcredito <= 100000000) {

                                 if (vivenda.isChecked()) {

                                     if (c1.isChecked()) {

                                         totalapagar = xvalorcredito / 12;
                                         ttp = totalapagar + (totalapagar * 0.5);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 12;

                                     }//c1
                                     if (c2.isChecked()) {

                                         totalapagar = xvalorcredito / 24;
                                         ttp = totalapagar + (totalapagar * 0.5);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 24;

                                     }//c2
                                     if (c3.isChecked()) {

                                         totalapagar = xvalorcredito / 36;
                                         ttp = totalapagar + (totalapagar * 0.5);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 36;

                                     }//c3

                                 }//vivenda

                                 else if (educacion.isChecked()) {

                                     if (c1.isChecked()) {

                                         totalapagar = xvalorcredito / 12;
                                         ttp = totalapagar + (totalapagar * 0.7);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 12;

                                     }//c1
                                     if (c2.isChecked()) {

                                         totalapagar = xvalorcredito / 24;
                                         ttp = totalapagar + (totalapagar * 0.7);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 24;

                                     }//c2
                                     if (c3.isChecked()) {

                                         totalapagar = xvalorcredito / 36;
                                         ttp = totalapagar + (totalapagar * 0.7);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 36;

                                     }

                                 }//educacion

                                 else if (libre.isChecked()) {

                                     if (c1.isChecked()) {

                                         totalapagar = xvalorcredito / 12;
                                         ttp = totalapagar + (totalapagar * 1.5);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 12;

                                     }//c1
                                     if (c2.isChecked()) {

                                         totalapagar = xvalorcredito / 24;
                                         ttp = totalapagar + (totalapagar * 1.5);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 24;

                                     }//c2
                                     if (c3.isChecked()) {

                                         totalapagar = xvalorcredito / 36;
                                         ttp = totalapagar + (totalapagar * 1.5);
                                         if (manejo.isChecked()) {
                                             ttp = ttp + 8000;
                                         }
                                         tot = ttp * 36;

                                     }

                                 }//libre

                                 DecimalFormat cifra = new DecimalFormat("###,###,###,###.##");

                                 cuota.setText(cifra.format(ttp));

                                 DecimalFormat cifra1 = new DecimalFormat("###,###,###,###.##");

                                 total.setText(cifra1.format(tot));

                             }//validar min y max

                             else {
                                 Toast.makeText(getApplicationContext(), "Debe ingresar un valor valido", Toast.LENGTH_SHORT).show();
                             }

                         }


                     }
                     else{
                         Toast.makeText(getApplicationContext(),"Debe ingresar 2 valores",Toast.LENGTH_SHORT).show();
                     }






             } //void
         });//set onclick listener
    }//@Override On create
}//public class



