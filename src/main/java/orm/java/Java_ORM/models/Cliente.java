package orm.java.Java_ORM.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {
    @Column(length = 20)
    private String metodoPagamento;

    public Cliente () {}
    
    public Cliente (String nome, String senha, String email, LocalDate dtNasc, String cpf) {
        super(nome, senha, email, dtNasc, cpf);
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
