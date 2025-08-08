public class ContaBanco {

    //    Constatntes
    private static final float SALDO_INICIAL_CC = 50f;
    private static final float SALDO_INICIAL_CP = 150f;
    private static final int MENSALIDADE_CC = 12;
    private static final int MENSALIDADE_CP = 20;

    //    Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    //    Constrtor
    public ContaBanco() {
        this.saldo = 0f;
        this.status = false;
    }

    //    Getters e Setters
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }

    //    Status da conta
    public void estadoAtual(){
        System.out.println("-------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + (isStatus() ? "Aberta" : "Fechada"));
        System.out.println("-------------------------------");
    }

    //    Ações
    public void abrirConta(String tipo) {
       this.setTipo(tipo.toUpperCase());
       this.setStatus(true);
       if (tipo.equalsIgnoreCase("CC")) {
           this.setSaldo(SALDO_INICIAL_CC);
       } else if (tipo.equalsIgnoreCase("CP")) {
           this.setSaldo(SALDO_INICIAL_CP);
       }

        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta(){
        if(saldo > 0){
            System.out.println("Conta com dinheiro: R$" + saldo);
        } else if (saldo < 0){
            System.out.println("Conta em débito: R$" + saldo);
        }else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float valor){
        if (!isStatus()){
            System.out.println("A conta está fechada!");
            return;
        }
        if (valor <= 0){
            System.out.println("Valor inválido para realizar o depósito!");
            return;
        }
        this.setSaldo(this.getSaldo() + valor);
        System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
    }

    public void sacar(float valor){
        if (!isStatus()){
            System.out.println("A conta está fechada!");
            return;
        }
        if (valor <= 0){
            System.out.println("Valor inválido para realizar o saque!");
            return;
        }
        if (this.getSaldo() >= valor){
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void pagarMensalidade(){
        int valor = 0;
        if (tipo.equalsIgnoreCase("CC")){
            valor = MENSALIDADE_CC;
        }else if(tipo.equalsIgnoreCase("CP")){
            valor = MENSALIDADE_CP;
        }

        if (!isStatus()){
            System.out.println("Conta fechada!");
            return;
        }
        this.setSaldo(this.getSaldo() - valor);
        System.out.println("Mensalidade de R$" + valor + " paga com sucesso por " + this.getDono());
    }
}
