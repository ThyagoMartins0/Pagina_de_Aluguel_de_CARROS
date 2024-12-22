package com.ecommerce.carro.loja.de.carro.model;

import jakarta.persistence.*;


//NOTA IMPORTANTE, AQUI EU PODERIA USAR O LOMBOK PARA FAZER O GETTER E SETTER E VÁRIOS OUTROS
//CONSTRUCTOS, MAS N VOU FAZER, POIS ACREDITO QUE A CAMADA DE NEGÓCIO FICA FRÁGIL POIS
//FICA DEPENDENTE DE UMA FERRAMENTE EXTERNA

@Entity
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
                            }
        )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; //Meio de identificação de cada usuario

    //Itens basicos para cadastro e movimentação dos dados em sistema
    private String Name;
    private String Lastname;

    @Column (nullable = false)
    private String Email;

    private String Password;

    public User(){

    }

    public User(String Name, String Lastname, String Email, String Password){
        this.Name = Name;
        this.Lastname = Lastname;
        this.Email = Email;
        this.Password = Password;
    }

    //CONSTRUINDO OS GETTERS AND SETTERS

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}