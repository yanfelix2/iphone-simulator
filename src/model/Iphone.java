package model;


import interfaces.AparelhoTelefonico;
import interfaces.NavegadorInternet;
import interfaces.ReprodutorMusical;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

   private boolean ligado = false; // Para saber se o aparelho está ligado
   private boolean statusReprodutor = false; // Para saber se está com uma musica tocando, de padrão não está
   private String musicaSelecionada; // Para saber a musica selecionada
   private String urlSelecionada;
   private String numeroSelecionado; // Para saber o número digitado para ligar
   private boolean statusLigacao = false;
   private boolean recebendoChamada = false;
   private int chamadasPerdidas = 0; // Para contar chamadas perdidas ( nao atendidas )
   private int abas = 0; // Contar abas adicionadas





    public void ligarAparelho(){
        if (ligado == false){
            ligado = true;
            System.out.println("Aparelho ligado com sucesso!");
        }else {
            System.out.println("O aparelho já está ligado.");
        }
    }

    public void desligarAparelho(){
        if (ligado){
            ligado = false;
            System.out.println("Aparelho desligado com sucesso!");
        }else {
            System.out.println("Aparelho já está desligado.");
        }
    }

    @Override
    public void selecionarMusica(String musica){
        if (this.ligado){
            musicaSelecionada = musica;
            System.out.println("Música selecionada: " + musica);
        }else {
            System.out.println("O aparelho está delisgado.");
        }

    };

    @Override
    public void tocar(){
        if (!ligado){
            System.out.println("Aparelho está desligado...");
        } else if (musicaSelecionada == null) {
            System.out.println("Selecione uma música antes de reproduzir");
        }else if (statusReprodutor){
            System.out.println("A música já está tocando: " + musicaSelecionada);
        } else {
            statusReprodutor = true;
            System.out.println("Tocando a música selecionada: " + musicaSelecionada);
        }
    };

    @Override
    public void pausar(){
        if (!ligado) {
            System.out.println("O aparelho está desligado.");
        }else if (!statusReprodutor){
            System.out.println("A música já está pausada.");
        }else {
            statusReprodutor = false;
            System.out.println("Pausando música...");
        }
    };



    @Override
    public void ligar(String numero){
        if (!ligado){
            System.out.println("O aparelho está desligado.");
        } else if (recebendoChamada) {
            System.out.println("Você não pode ligar, você está recebendo uma chamada.");

        } else if (statusLigacao) {
            System.out.println("Você já está em uma ligação...");
        }else {
            numeroSelecionado = numero;
            statusLigacao = true;
            System.out.println("Ligando para o número: " + numeroSelecionado);
        }
    };

    @Override
    public void encerrarLigacao(){
        if (!ligado){
            System.out.println("O aparelho está desligado.");
        } else if (!statusLigacao){
            System.out.println("Você não está em uma ligação.");
        }else {
            statusLigacao = false;
            System.out.println("Chamada encerrada.");
        }

    }
    @Override
    public void receberChamada(String numero){
       if (!ligado){
           System.out.println("Aparelho desligado. Não foi possível receber a chamada");
       }if (recebendoChamada || statusLigacao){
           chamadasPerdidas++;
           System.out.println("Você perdeu uma chamada de " + numero);
        }else {
           recebendoChamada = true;
            System.out.println("\uD83D\uDD0AChamando você do número: " + numero);
        }


    };

    @Override
    public void atender(){
        if (ligado && recebendoChamada){
            statusLigacao = true;
            recebendoChamada = false;
            System.out.println("Chamada atendida com sucesso.");
        }else {
            System.out.println("Impossível atender a chamada.");
        }
    };

    @Override
    public void ignorarChamada(){
        if (recebendoChamada && ligado){
            recebendoChamada = false;
            chamadasPerdidas++;
            System.out.println("❌Chamada ignorada. Enviando para o correio de voz...\uD83D\uDCE8");
        }else {
            System.out.println("Nenhuma chamada para ignorar");
        }
    }

    @Override
    public void iniciarCorreioVoz(){
        if (!ligado){
            System.out.println("O aparelho está desligado.");
        } else if (recebendoChamada) {
            System.out.println("Você não pode acessar o correio de voz enquanto estiver recebendo uma chamada.");
        } else if (statusLigacao) {
            System.out.println("Você não pode acessar o correio de voz enquanto estiver em chamada.");
        } else {
            System.out.println("✉\uFE0FAcessando correio de voz...✉\uFE0F");
            System.out.println("\uD83D\uDC4EVocê tem " + chamadasPerdidas + " chamadas perdidas.\uD83D\uDC4E");
        }
    };




    @Override
    public void exibirPagina(String url){
        if (ligado){
            urlSelecionada = url;
            System.out.println("Acessando url: " + urlSelecionada);
        }else {
            System.out.println("O aparelho está desligado.");
        }
    };

    @Override
    public void adicionarNovaAba(){
        if (ligado){
            abas++;
            System.out.println("Nova aba adicionada, quantidade de abas: " + abas);
        }else {
            System.out.println("O aparelho está desligado");
        }
    };

    @Override
    public void atualizarPagina(){
        if (ligado){
            System.out.println("Recarregando a pagina, url atual: " + urlSelecionada);
        }else {
            System.out.println("O aparelho está desligado.");
        }

    };






}
