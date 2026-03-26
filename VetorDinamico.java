public class VetorDinamico {
    private int quantidade;
    private int capacidade;
    private int [] elementos;
    private static final int CAP_MINIMA = 4;

    public VetorDinamico () {
        quantidade = 0;
        capacidade = CAP_MINIMA;
        elementos = new int [capacidade];
    }

    public void adicionar (int e) {
        if (estaCheio()) {
            redimensionar (2);
        }
        elementos [quantidade] = e;
        quantidade++;
    }

    public void remover () {
        if (!estaVazio()) {
            quantidade--;
            if (capacidade >  CAP_MINIMA && quantidade == capacidade / 4) {
                redimensionar (0.5);
            }
        }
    }

    private void redimensionar (double fator) {
        var novo = new int [(int)(capacidade * fator)];
        for (int i = 0; i < quantidade; i++) {
            novo[i] = elementos[i];
        }
        capacidade = novo.length;
        elementos = novo;
    }

    public boolean estaVazio () {
        return quantidade == 0;
    }

    public boolean estaCheio () {
        return quantidade == capacidade;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("");
        sb.append("Qtde: ").append(quantidade);
        sb.append("\n").append("Cap: ").append(capacidade);
        sb.append("\n");
        if (!estaVazio()) {
            for (int i = 0; i < quantidade; i++) {
                sb.append(elementos[i]).append(" ");
            }
        }
        return sb.toString();
    }
}