package orm.java.Java_ORM.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private long id;
    private String pagamento;
    private double valor;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;
    @OneToOne
    private Cliente cliente;

    public Pedido() {}

    public Pedido(Cliente cliente, String pagamento, double valor) {
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public String getPagamento() {
        return pagamento;
    }

    public double getValor() {
        return valor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}