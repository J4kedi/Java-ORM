package orm.java.Java_ORM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import orm.java.Java_ORM.models.Cliente;
import orm.java.Java_ORM.repository.ClienteRepository;

public class Principal {
    private Scanner input = new Scanner(System.in);    
    private ClienteRepository repositorio;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);


    public Principal(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var op = -1;
        
        while(op != 0) {
            var menu = """
                    *********** MENU ***********

                    1. Cadastrar cliente
                    2. Listar todos os clientes
                    3. Excluir Cliente 
                    4.   
                    ----------------------------
                    0. Sair      
                    ****************************
                    """;
    
            System.out.println(menu);       
            System.out.print("Digite sua opção: ");

            op = input.nextInt();
            input.nextLine();

            switch (op) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    apagarCliente();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        System.out.println("Saindo...");
    }

    public void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        var nome = input.nextLine();
        System.out.print("Digite o email do cliente: ");
        var email = input.nextLine();
        System.out.print("Digite a senha do cliente: ");
        var senha = input.nextLine();
        System.out.print("Digite a data de nascimento do cliente: ");
        LocalDate dtNasc = LocalDate.parse(input.nextLine(), formatter);
        System.out.print("Digite o cpf do cliente: ");
        var cpf = input.nextLine();

        if(cpfExiste(cpf)) {
            System.err.println("Cliente já existente no sistema!!");
            return;
        }

        Cliente cliente = new Cliente(nome, senha, email, dtNasc, cpf);
        repositorio.save(cliente);

        System.out.println(cliente + "\nCadastrado com sucesso!");
    }
    
    public void listarClientes() {
        repositorio.findAll().forEach(System.out::println);
    }

    public void apagarCliente() {
        System.out.print("Digite o cpf do cliente: ");
        var cpf = input.nextLine();

        if(!cpfExiste(cpf)) {
            System.err.println("CPF não encontrado!!");
            return;
        }

        repositorio.deleteByCpf(cpf);

        System.out.println("Cliente Excluído com sucesso");
    }

    private boolean cpfExiste(String cpf) {
        if(repositorio.encontrarCpfCliente(cpf) == null) {
            return false;
        }
        return true;
    }
}
