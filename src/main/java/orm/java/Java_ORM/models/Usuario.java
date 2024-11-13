package orm.java.Java_ORM.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private long id;
    @Column(length = 60, nullable = false)
    private String nome;
    @Column(length = 50)
    private String senha;
    @Column(length = 50)
    private String email;
    @Temporal(TemporalType.DATE)
    private LocalDate dtNasc;
    private boolean isLogin;
    @Column(length = 20, unique = true)
    private String cpf;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Endereco> enderecos;    
    
    public Usuario() {}

    public Usuario(String nome, String senha, String email, LocalDate dtNasc, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.dtNasc = dtNasc;
        this.cpf = cpf;
    }

    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public void rmEndereco(Endereco endereco) {
        enderecos.remove(endereco);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    @Override
    public String toString() {
        return "----------------------" +         
             "\nID: " + id + 
             "\nUsuario: " + nome + 
             "\nCPF: " + cpf +
             "\n----------------------";
    }
}
