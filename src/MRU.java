import java.util.LinkedList;

public class MRU {


    private LinkedList<String> frames;
    private int acertos, faltas, qtd_frames;

    public MRU(int frames) {
        this.acertos = 0;
        this.faltas = 0;
        this.frames = new LinkedList();
        this.qtd_frames = frames;
    }

    public int getAcertos() { return acertos; }

    public int getFaltas() { return faltas;  }

    public void MRU(String[] arrayEntrada) {

        String[] arrayAux = new String[arrayEntrada.length];
        int i;

        for (i = 0; i < arrayEntrada.length; i++) {
            arrayAux[i] = arrayEntrada[i].substring (0, arrayEntrada[i].length() - 1);
        }

        for(i = 0; i<arrayAux.length;i++){
            int tmp = frames.indexOf(arrayAux[i]);
            if (tmp == -1) {
                if (frames.size() < qtd_frames) {
                    frames.add(arrayAux[i]);
                } else {

                    frames.remove(0);
                    frames.add(arrayAux[i]);
                }
                faltas++;
            } else {
                frames.remove(tmp);
                frames.add(arrayAux[i]);
                acertos++;
            }
        }
    }
}
