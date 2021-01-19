package com.aplicatie.idealpicture;

public class HelperDetaliiComenzi {
    String id,nume,prenume,email,adresa,telefon,sedinta;



    public HelperDetaliiComenzi(String id, String nume, String prenume, String email, String adresa, String telefon, String sedinta) {
        this.id =id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.adresa = adresa;
        this.telefon = telefon;
        this.sedinta = sedinta;

    }

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getSedinta() {
        return sedinta;
    }
}


