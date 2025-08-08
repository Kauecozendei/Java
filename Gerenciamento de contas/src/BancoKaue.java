import java.util.Scanner;

public class BancoKaue {
    public static void main(String[] args) {
        ContaBanco pessoa1 = new ContaBanco();

        pessoa1.setNumConta(00001);

        pessoa1.setDono("Kauê");
        pessoa1.abrirConta("CC");
        pessoa1.depositar(300);
        pessoa1.pagarMensalidade();
        pessoa1.estadoAtual();


        ContaBanco pessoa2 = new ContaBanco();

        pessoa2.setNumConta(00002);
        pessoa2.setDono("Luiza");
        pessoa2.abrirConta("CP");
        pessoa2.depositar(500);
        pessoa2.sacar(100);
        pessoa2.pagarMensalidade();
        pessoa2.estadoAtual();

        ContaBanco pessoa3 = new ContaBanco();

        pessoa3.setNumConta(00003);
        pessoa3.setDono("Gabriel");
        pessoa3.abrirConta("CP");
        pessoa3.sacar(150);
        pessoa3.pagarMensalidade();
        pessoa3.fecharConta();
        pessoa3.estadoAtual();

    }
}