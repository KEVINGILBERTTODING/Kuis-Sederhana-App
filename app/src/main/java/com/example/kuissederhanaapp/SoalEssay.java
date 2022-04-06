package com.example.kuissederhanaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SoalEssay extends AppCompatActivity {

    //membuat variabel baru sesuai tipe
    TextView mtvSkor, mtvSoal;
    EditText edtJawaban;
    Button mbtnSubmit;
    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x; //menunjukkan konten sekarang
    String jawaban; //menampung jawaban benar
    //membuat objek dari kelas SoalPilihanGanda.java
    SoalEssayy soalEsy = new SoalEssayy();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_essay);
        //menyambungkan antara variabel KuisPilihanGanda.javadengan id activity_kuis_pilihan_ganda
        mtvSkor = (TextView) findViewById(R.id.tvSkor1);
        mtvSoal = (TextView) findViewById(R.id.tvSoal1);
        edtJawaban = (EditText)findViewById(R.id.edt_JwbnEssay) ;

        mbtnSubmit = (Button) findViewById(R.id.btnSubmit1);
        //set konten
        mtvSkor.setText(""+skor);
        setKonten();
        //menentukan aksi ketika button submit diklik
        mbtnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //aksinya disini
                //aksinya adalah ketika button tersebut diklik  maka
                //akan mengecek jawaban benar atau salah
                //kemudian konten akan berubah (next konten)
                cekJawaban();
            }
        });
    }
    //method untuk mengambil dan update konten dari  SoalPilihanGanda.java
    //kemudian disetting/ditempatkan pada tempat yang telah disediakan
    public void setKonten(){
        edtJawaban.setText("");
        arr = soalEsy.pertanyaan.length;
        if(x >= arr){ //jika nilai x melebihi nilai arr(panjang  array) maka akan pindah activity (kuis selesai)
            String jumlahSkor = String.valueOf(skor);
//menjadikan skor menjadi string
            Intent i = new Intent(SoalEssay.this, HasilSkoring.class);
            //waktu pindah activity, sekalian membawa nilai jumlahSkor yang ditampung dengan inisial skorAkhir
            //singkatnya skorAkhir = `jumlah`Skor
            //jika masih belum jelas silahkan bertanya
            i.putExtra("skorAkhir",jumlahSkor);
            i.putExtra("activity","PilihanGanda");
            startActivity(i);
        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalPilihanGanda
            mtvSoal.setText(soalEsy.getPertanyaan(x));

//            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(x));
//
//            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(x));
//
//            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(x));
            jawaban = soalEsy.getJawabanBenar(x);
        }
        x++;
    }
    public void cekJawaban(){

            if(edtJawaban.getText().toString().equals(jawaban)){
                skor = skor + 10;
                mtvSkor.setText(""+skor); //mtvSkor diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar",
                        Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah",
                        Toast.LENGTH_SHORT).show();
                setKonten();
            }

    //ini adalah method bawaan dari Android Studio
    //fungsi : memberi aksi ketika tombol back pada hp diklik
//    public void onBackPressed(){
//        Toast.makeText(this, "Selesaikan kuis",
//                Toast.LENGTH_SHORT).show();
        //jadi yang awalnya klik tombol back maka akan kembali  ke activity sebelumnya
        //kali ini ketika tombol back diklik maka
        //hanya muncul Toast
    }
}