public class FuncionarioCLT extends Contribuinte {

    private static final double ALIQUOTA_INSS = 0.10;
    private static final double TETO_INSS = 700.00;
    private static final double ALIQUOTA_IRPF = 0.15;
    private static final double DEDUCAO_IRPF = 500.00;

    public FuncionarioCLT(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public String getTipoContribuinte() {
        return "Funcionário CLT";
    }

    @Override
    public double calcularINSS() {
        double inss = this.salarioBruto * ALIQUOTA_INSS;
        return Math.min(inss, TETO_INSS);
    }

    @Override
    public double calcularIRPF() {
        double inss = calcularINSS();
        double baseCalculo = this.salarioBruto - inss - DEDUCAO_IRPF;

        if (baseCalculo <= 0) {
            return 0.0;
        }

        return baseCalculo * ALIQUOTA_IRPF;
    }

    @Override
    public double calcularSalarioLiquido() {
        return this.salarioBruto - calcularINSS() - calcularIRPF();
    }
}