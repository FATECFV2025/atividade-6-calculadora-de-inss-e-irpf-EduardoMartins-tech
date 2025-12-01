public class PrestadorServico extends Contribuinte {

    private static final double ALIQUOTA_IRRF = 0.10;

    public PrestadorServico(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public String getTipoContribuinte() {
        return "Prestador de Serviço (PJ)";
    }

    @Override
    public double calcularINSS() {
        return 0.0;
    }

    @Override
    public double calcularIRPF() {
        return this.salarioBruto * ALIQUOTA_IRRF;
    }

    @Override
    public double calcularSalarioLiquido() {
        return this.salarioBruto - calcularIRPF();
    }
}