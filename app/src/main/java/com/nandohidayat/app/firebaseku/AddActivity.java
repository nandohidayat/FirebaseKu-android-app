package com.nandohidayat.app.firebaseku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {
    public static final String KD_BARANG = "com.nandohidayat.app.firebaseku.kdbrg";

    EditText editKdBrg;
    EditText editNmBrg;
    EditText editSatuan;
    EditText editHrgBeli;
    EditText editHrgJual;
    EditText editStok;
    EditText editStokMin;
    Button buttonAdd;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        databaseReference = FirebaseDatabase.getInstance().getReference("barangs");

        editKdBrg = (EditText) findViewById(R.id.kdbrg);
        editNmBrg = (EditText) findViewById(R.id.nmbrg);
        editSatuan = (EditText) findViewById(R.id.satuan);
        editHrgBeli = (EditText) findViewById(R.id.hrgbeli);
        editHrgJual = (EditText) findViewById(R.id.hrgjual);
        editStok = (EditText) findViewById(R.id.stok);
        editStokMin = (EditText) findViewById(R.id.stokmin);
        buttonAdd = (Button) findViewById(R.id.btnadd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBarang();
            }
        });
    }

    private void addBarang() {
        String KdBrg = editKdBrg.getText().toString().trim();
        String NmBrg = editNmBrg.getText().toString().trim();
        String Satuan = editSatuan.getText().toString().trim();
        double HrgBeli = Double.parseDouble(editHrgBeli.getText().toString().trim());
        double HrgJual = Double.parseDouble(editHrgJual.getText().toString().trim());
        int Stok = Integer.parseInt(editStok.getText().toString().trim());
        int StokMin = Integer.parseInt(editStokMin.getText().toString().trim());

        String id = databaseReference.push().getKey();

        Barang barang = new Barang(KdBrg, NmBrg, Satuan, HrgBeli, HrgJual, Stok, StokMin);

        databaseReference.child(id).setValue(barang);

        Toast.makeText(this, "Successfully Added", Toast.LENGTH_LONG).show();

        Intent intent = new Intent();
        setResult(1, intent);
        finish();
    }
}
