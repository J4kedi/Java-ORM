package orm.java.Java_ORM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orm.java.Java_ORM.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{}
