package orm.java.Java_ORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import orm.java.Java_ORM.repository.ClienteRepository;

@SpringBootApplication
public class JavaOrmApplication implements CommandLineRunner {
	@Autowired
	private ClienteRepository clienteRepositorio;

	public static void main(String[] args)  {
		SpringApplication.run(JavaOrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(clienteRepositorio);
		principal.exibeMenu();		
	}
}
