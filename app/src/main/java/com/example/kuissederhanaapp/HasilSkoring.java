package com.example.kuissederhanaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class HasilSkoring extends AppCompatActivity {
    TextView mtvHasilAkhir;
    Button mbtnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_skoring);
        mtvHasilAkhir = (TextView)
                findViewById(R.id.tvSkorAkhir);
        mbtnMenu = (Button) findViewById(R.id.btnMenu);
        setSkor();
        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HasilSkoring.this,
                        MainActivity.class);
                startActivity(i);
            }
        });
    }
    //method untuk mengatur skor yang akan ditampilkan pada textview
    public void setSkor(){
        //hasil lemparan (putExtra) dari activity sebelumnya  ditampung dalam variabel lokal
        String activity =
                getIntent().getStringExtra("activity");
        String skorPilGan =
                getIntent().getStringExtra("skorAkhir");
        String skorEssay =
                getIntent().getStringExtra("skorAkhir2");
        if(activity.equals("PilihanGanda")){ //jika var activity  bernilai PilihanGanda
            //dipastikan activity sebelumnya datang dari kelas  KuisPilihanGanda
            //maka skornya diatur dari skorPilGan
            mtvHasilAkhir.setText("SKOR : "+skorPilGan);
        }else{
            //dipastikan activity sebelumnya datang dari kelas  KuisEssay
            //maka skornya diatur dari skorEssay
            mtvHasilAkhir.setText("SKOR : "+skorEssay);
        }
    }
    //ini adalah method bawaan dari Android Studio
    //fungsi : memberi aksi ketika tombol back pada hp diklik
    public void onBackPressed(){
        Toast.makeText(this, "Tidak bisa kembali, silahkan tekan  menu", Toast.LENGTH_SHORT).show();
                //jadi yang awalnya klik tombol back maka akan kembali ke activity sebelumnya
                //kali ini ketika tombol back diklik maka
                //hanya muncul Toast
    }
}