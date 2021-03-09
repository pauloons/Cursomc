package com.alexandre.cursos.dto;

import java.io.Serializable;
import  com.alexandre.cursos.domain.Cliente;
import com.alexandre.cursos.services.validation.ClienteUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80,message = "O tamanho deve ser entre 5 e 80 caracteres")
    public  String nome;

    @Email
    @NotEmpty(message = "É necessario informar um email válido")
    public String email;

    public ClienteDTO(){

    }
    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
