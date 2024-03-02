package com.example.invoicedocument;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_price, edt_VAT;
    Button btn;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_price = findViewById(R.id.edt_price);
        edt_VAT = findViewById(R.id.vat_id);
        btn = findViewById(R.id.btn_id);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int price = Integer.valueOf(edt_price.getText().toString());
                int vat = Integer.valueOf(edt_VAT.getText().toString());

                int total_price = ((price*vat)/100)+price;

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_dialog);

                ImageView carpi = dialog.findViewById(R.id.carpi);
                TextView explanation = dialog.findViewById(R.id.textView);
                Button btn = dialog.findViewById(R.id.button);

                explanation.setText("Entered price:" + price + "\n" + "Ratio vat:" + vat + "\n" + "Total Price:" + total_price);

                carpi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Document examined", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();


            }
        });
    }
}