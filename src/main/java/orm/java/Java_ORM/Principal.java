package orm.java.Java_ORM;

import java.util.Scanner;

import orm.java.Java_ORM.models.Cliente;
import orm.java.Java_ORM.repository.ClienteRepository;

public class Principal {
    private Scanner input = new Scanner(System.in);    
    private ClienteRepository repositorio;

    public Principal(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var op = -1;
        
        while(op != 0) {
            var menu = """
                    *** MENU ***
                    1. Cadastrar cliente
                    2. Listar todos os clientes
                    3. Excluir Cliente 
                    4.   
                    ------------
                    0. Sair      
                    ************
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
        System.out.print("Digite o cpf do cliente: ");
        var cpf = input.nextLine();

        if(cpfExiste(cpf)) {
            System.err.println("Cliente já existente no sistema!!");
            return;
        }

        Cliente cliente = new Cliente(nome, cpf);
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
