import java.util.LinkedList;

public class SC {
    private LinkedList<String> frames;
    private LinkedList<Integer> bitR;
    private int acertos;
    private int faltas;
    private int qtd_frames;


    public SC(int frames){
        this.acertos = 0;
        this.faltas = 0;
        this.qtd_frames = frames;
        this.frames = new LinkedList<>();
        this.bitR = new LinkedList<>();
    }

    public int getAcertos() { return acertos; }

    public int getFaltas() { return faltas;  }

    public void secondChance(String [] arrayEntrada, int zeresima){
        int time = zeresima;
        String[] arrayAux = new String[arrayEntrada.length];
        int i;

        for (i = 0; i < arrayEntrada.length; i++) {
            arrayAux[i] = arrayEntrada[i].substring (0, arrayEntrada[i].length() - 1);
        }

        for (i = 0; i<arrayAux.length; i++){
            time--;

            if(!frames.contains(arrayAux[i])){
                this.faltas++;

                if(frames.size() < qtd_frames){
                    System.out.println("Falta! Entra o "+arrayAux[i]);
                    frames.add(arrayAux[i]);
                    bitR.add(1);
                }

                else{
                    int j = 0;
                    while(j<bitR.size()){
                        if(bitR.get(j)==1){
                            frames.add(frames.get(j));
                            bitR.add(0);
                            frames.remove(j);
                            bitR.remove(j);
                            j++;
                        }
                        else {
                            System.out.println("Falta! Sai o "+ frames.get(j) +" e entra o "+arrayAux[i]);
                            frames.remove(j);
                            bitR.remove(j);
                            frames.add(arrayAux[i]);
                            bitR.add(1);
                            break;
                        }
                    }
                }
            }

            else {
                System.out.println("Acerto! Permanece o "+arrayAux[i]);
                bitR.remove(frames.indexOf(arrayAux[i]));
                bitR.add(frames.indexOf(arrayAux[i]),1);
                this.acertos++;
            }


            if(time == 0){
                for(int k = 0; k<bitR.size();k++){
                    bitR.remove(k);
                    bitR.add(k,0);
                }
                time = zeresima;
            }
        }
    }


}
