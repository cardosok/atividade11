package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;


public class Function {

    @FunctionName ("funcaocriarcidade")
    public Cidade criar (@HttpTrigger (name = "restcriarcidade", methods = {HttpMethod.POST}, route = "cidade") Cidade c) {
        c.setId(new Long(1));

        return c;
    }

    
    @FunctionName ("funcaolercidade")
    public List<Cidade> ler(@HttpTrigger (name = "restlercidade", methods = {HttpMethod.GET}, route = "cidade") String x) {

        return Stream.of(
            new Cidade(),
            new Cidade(),
            new Cidade()
        ).collect(Collectors.toList());
    }

    @FunctionName ("funcaoalterarcidade")
    public Cidade alterar (
        @HttpTrigger (
            name = "restalterarcidade",
            methods = {HttpMethod.PUT},
            route = "cidade"
        )
        Cidade c) {
        c.setNome( c.getNome() + 10);

        return c;
    }

    @FunctionName ("funcaoapagarcidade")
    public int apagar (
        @HttpTrigger (
            name = "restapagarcidade",
            methods = {HttpMethod.DELETE},
            route = "cidade/{id}"
        )
        @BindingName ("id") Long id) {
        System.out.println(String.format("Id: %d", id));

        return 200;
   }
}

class Cidade{
    Long id;
    String nome;
    Estado estado;

    Cidade(){
    }

    Cidade(Long id,String nome,Estado estado){        
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    

}

class Estado{
    Long id;
    String nome;

    Estado(){}

    Estado(Long id,String nome){
        this.id = id;
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }    
}
