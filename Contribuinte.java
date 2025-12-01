public abstract class Contribuinte implements CalculadoraTributo {

    private String nome;
    private String cpf;
    protected double salarioBruto;

    public Contribuinte(String nome, String cpf, double salarioBruto) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBruto = salarioBruto;
    }

    public void exibirResumo() {
        double inss = calcularINSS();
        double irpf = calcularIRPF();
        double salarioLiquido = calcularSalarioLiquido();

        System.out.println("\n*** Resumo da Folha de Pagamento ***");
        System.out.println("-> Nome: " + this.nome);
        System.out.println("-> Tipo de Contribuinte: " + getTipoContribuinte());
        System.out.println("------------------------------------");
        System.out.printf("   Salário Bruto: R$ %.2f\n", this.salarioBruto);
        System.out.printf("   (-) INSS: R$ %.2f\n", inss);
        System.out.printf("   (-) IRPF: R$ %.2f\n", irpf);
        System.out.println("------------------------------------");
        System.out.printf("   Salário Líquido: R$ %.2f\n", salarioLiquido);
        System.out.println("************************************");
    }

    public abstract String getTipoContribuinte();

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public double getSalarioBruto() { return salarioBruto; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setSalarioBruto(double salarioBruto) { this.salarioBruto = salarioBruto; }
}