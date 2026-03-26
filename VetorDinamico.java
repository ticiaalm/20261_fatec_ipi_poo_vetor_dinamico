public class VetorDinamico {
    private int quantidade;
    private int capacidade;
    private int [] elementos;

    public VetorDinamico () {
        quantidade = 0;
        capacidade = 4;
        elementos = new int [capacidade];
    }

    public void adicionar (int e) {
        if (estaCheio()) {
            aumentarCapacidade();
        }
        elementos [quantidade] = e;
        quantidade++;
    }

    public void aumentarCapacidade () {
        var novo = new int [capacidade * 2];
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