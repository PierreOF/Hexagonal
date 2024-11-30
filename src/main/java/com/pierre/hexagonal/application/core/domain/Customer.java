package com.pierre.hexagonal.application.core.domain;

public class Customer {

    private String id;

    private String name;

    private Adress adress;

    private String cpf;

    private Boolean isValidCpf;

    public Customer(){
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Adress adress, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
