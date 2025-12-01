import java.util.Scanner;

public class AppFolhaPagamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Calculadora de Tributos (INSS e IRPF) ---");
        System.out.print("Informe o Nome do Contribuinte: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF do Contribuinte: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe o Salário Bruto: R$ ");
        double salarioBruto = 0.0;
        try {
            salarioBruto = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.err.println("Erro: Salário bruto deve ser um valor numérico.");
            scanner.close();
            return;
        }

        System.out.println("\n--- Seleção do Tipo de Contribuinte ---");
        System.out.println("1 - Funcionário CLT");
        System.out.println("2 - Estagiário");
        System.out.println("3 - Prestador de Serviço (PJ)");
        System.out.print("Escolha o tipo (1, 2 ou 3): ");
        int opcao = scanner.nextInt();

        Contribuinte contribuinte;

        switch (opcao) {
            case 1:
                contribuinte = new FuncionarioCLT(nome, cpf, salarioBruto);
                break;
            case 2:
                contribuinte = new Estagiario(nome, cpf, salarioBruto);
                break;
            case 3:
                contribuinte = new PrestadorServico(nome, cpf, salarioBruto);
                break;
            default:
                System.err.println("Opção inválida. Encerrando o programa.");
                scanner.close();
                return;
        }

        System.out.println("\n------------------------------------");
        System.out.println("Realizando cálculos...");
        System.out.printf("INSS Calculado: R$ %.2f\n", contribuinte.calcularINSS());
        System.out.printf("IRPF Calculado: R$ %.2f\n", contribuinte.calcularIRPF());
        System.out.printf("Salário Líquido: R$ %.2f\n", contribuinte.calcularSalarioLiquido());
        System.out.println("------------------------------------");

        contribuinte.exibirResumo();

        scanner.close();
    }
}
