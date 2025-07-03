package interfaces;

public interface AparelhoTelefonico {
    void ligar(String numero);
    void encerrarLigacao();
    void atender();
    void receberChamada(String numero);
    void ignorarChamada();
    void iniciarCorreioVoz();


}
