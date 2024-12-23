package com.ecommerce.carro.loja.de.carro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


//NOTA IMPORTANTE, AQUI EU PODERIA USAR O LOMBOK PARA FAZER O GETTER E SETTER E VÁRIOS OUTROS
//CONSTRUCTOS, MAS N VOU FAZER, POIS ACREDITO QUE A CAMADA DE NEGÓCIO FICA FRÁGIL POIS
//FICA DEPENDENTE DE UMA FERRAMENTE EXTERNA

@Entity
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
                            }
        )
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; //Meio de identificação de cada usuario

    //Itens basicos para cadastro e movimentação dos dados em sistema
    @NotNull
    private String Name;
    @NotNull
    private String Lastname;

    @NotNull
    @Email
    @Column (nullable = false, unique = true)
    private String Email;

    @NotNull
    private String Password;

    public UserModel(){

    }

    public UserModel(String Name, String Lastname, String Email, String Password){
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

    public void setId(long l) {
    }
}