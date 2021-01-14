/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author anton
 */
public class Contato {
    
//    private int id_contato;
    private String nome;
    private String email;

    public Contato(){}
    
//    public Contato(int id_contato, String nome, String email) {
//        super();
//        this.id_contato = id_contato;
//        this.nome = nome;
//        this.email = email;
//    }
    
    public Contato(String nome,String email){
        super();
        this.nome = nome;
        this.email = email;
    }

//    public int getId_contato() {
//        return id_contato;
//    }
//
//    public void setId_contato(int id_contato) {
//        this.id_contato = id_contato;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
