import java.util.List;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
public class GerenciadorDeMusicas {
    public static void main(String[] args) {
        /* tipo base e tipo paramétrico
        generics java 5+ */
        List<Musica> musicas = new ArrayList<>();
        int opcao;
        String menu = "0 - Sair\n1 - Cadastrar música\n2 - Avaliar música\n3 - Ver a lista de músicas\n4 - Ver a lista ordenada por avaliação";
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1: {
                    var titulo = JOptionPane.showInputDialog("Título?");
                    var musica = new Musica(titulo);
                    musicas.add(musica);
                    break;
                }
                case 2: {
                    var titulo = JOptionPane.showInputDialog("Titulo?");
                    var avaliacao = Integer.parseInt(JOptionPane.showInputDialog("Nota?"));
                    for (int i = 0; i < musicas.size(); i++) {
                        if (musicas.get(i).getTitulo().equals(titulo)) {
                            musicas.get(i).setAvaliacao(avaliacao);
                            JOptionPane.showMessageDialog(null, "Música avaliada!");
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    Collections.sort(musicas);
                    JOptionPane.showMessageDialog(null, musicas);
                    break;
                }
                case 4: {
                    Collections.sort(musicas, new CriterioAvaliacaoComparator());
                    JOptionPane.showMessageDialog(null, musicas);
                    break;
                }
            }
        } 
        while (opcao != 0);
    }
}