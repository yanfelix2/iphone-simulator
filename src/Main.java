import model.Iphone;

public class Main {
    public static void main(String[] args) {

        // TODO: criar metodo para avançar musica, voltar musica, aumentar volume e diminuir o volume.

        Iphone iphone = new Iphone();

        System.out.println("===== METODOS PARA O REPRODUTOR MUSICAL =====");
        iphone.ligarAparelho();
        iphone.selecionarMusica("Djavan - Álibi(AoVivo)");
        iphone.tocar();
        iphone.pausar();


        System.out.println("===== METODOS PARA APARELHO TELEFONICO =====");
        iphone.receberChamada("(81)9707-1497");
        iphone.ignorarChamada();
        iphone.receberChamada("(81)9918-9012");
        iphone.ignorarChamada();
        iphone.receberChamada("(81)9854-5602");
        iphone.ligar("8199432341");
        iphone.ignorarChamada();
        iphone.iniciarCorreioVoz();

        System.out.println("===== METODOS PARA NAVEGADOR =====");
        iphone.exibirPagina("https://youtube.com");
        iphone.exibirPagina("https://github.com");
        iphone.atualizarPagina();
        iphone.adicionarNovaAba();
        iphone.adicionarNovaAba();
        iphone.exibirPagina("https://disney.com.br");
        iphone.atualizarPagina();
        iphone.adicionarNovaAba();












    }
}
