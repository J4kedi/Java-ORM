package orm.java.Java_ORM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import orm.java.Java_ORM.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT cpf FROM Cliente c WHERE c.cpf = :cpf")
    String encontrarCpfCliente(String cpf);

    long deleteByCpf(String cpf);
}
