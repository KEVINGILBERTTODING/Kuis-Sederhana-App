package com.example.kuissederhanaapp;

public class SoalEssayy {
    public String pertanyaan[] = {
            "Bahasa inggris balon?",
            "Sebutan kakak laki-laki dalam bahasa inggris?",
            "Ibu Kota negara Korea Selatan?",
            "bahasa inggris ibu adalah?",
            "Gudeg adalah makanan khas dari mana?",
            "Bandara Husein Sastranegara berada di mana?",
            "Bulan apa Indonesia merdeka?",
            "Joglo adalah rumah adat dari provinsi apa?",
            "Presiden RI ke-3?",
            "Wakil presiden RI pertama?",
    };

    //membuat array untuk jawaban benar
    private String jawabanBenar[] = {
            "Baloon",
            "Brother",
            "Seoul",
            "Mother",
            "Yogyakarta",
            "Bandung",
            "Agustus",
            "Jawa Tengah",
            "B.J Habibie",
            "Moh. Hatta",
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}

