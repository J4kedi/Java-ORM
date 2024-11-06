package orm.java.Java_ORM.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private long id;
    private IPagamentoStrategy metodoPagamento;

    public Cliente () {}
    
    public Cliente (String nome, String senha, String email, Date dtNasc, String cpf) {
        super(nome, senha, email, dtNasc, cpf);
    }
}
