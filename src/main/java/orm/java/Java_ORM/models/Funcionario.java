package orm.java.Java_ORM.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public abstract class Funcionario extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "funcionario_id")
    private Long id;
    private int cargaHoraria;
    private int entradaSaida;
    private double salario;

    public Funcionario () {}

    public Funcionario (String nome, String senha, String email, Date dtNasc, String cpf, int cargaHoraria, double salario) {
        super(nome, senha, email, dtNasc, cpf);
        this.cargaHoraria  = cargaHoraria;
        this.entradaSaida = 0;
        this.salario = salario;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getEntradaSaida() {
        return entradaSaida;
    }

    public double getSalario() {
        return salario;
    }
}
