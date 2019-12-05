import java.util.LinkedList;

public class FIFO {
    private int INSERCAO = 0;
    private LinkedList<String> frames;
    private int acertos, faltas, qtd_frames;

    public FIFO(int frames) {
        this.acertos = 0;
        this.faltas = 0;
        this.frames = new LinkedList();
        this.qtd_frames = frames;
    }

    public int getAcertos() { return acertos; }

    public int getFaltas() { return faltas;  }

    public void fifo(String[] arrayEntrada) {

        String[] arrayAux = new String[arrayEntrada.length];
        int i;

        for (i = 0; i < arrayEntrada.length; i++) {
            arrayAux[i] = arrayEntrada[i].substring (0, arrayEntrada[i].length() - 1);
        }

        for(i=0;i<arrayAux.length;i++){
            if (!frames.contains(arrayAux[i])) {
                faltas++;
                if (frames.size() < qtd_frames) {
                    frames.add(arrayAux[i]);
                }
                else {
                    frames.remove(INSERCAO);
                    frames.add(INSERCAO, arrayAux[i]);
                    INSERCAO++;
                    if (INSERCAO == qtd_frames) {
                        INSERCAO = 0;
                    }
                }
            }
            else {
                acertos++;
            }
        }
    }
}
