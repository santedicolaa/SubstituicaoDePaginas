import java.util.LinkedList;

public class Otimo {
    private LinkedList quadros;
    private int acertos;
    private int faltas;
    private int numeroDeQuadros;

    public Otimo(int frames) {
        this.acertos = 0;
        this.faltas = 0;
        this.numeroDeQuadros = frames;
        this.quadros = new LinkedList();

    }

    public int getPageFoundCount() {
        return acertos;
    }

    public int getPageFaultCount() {
        return faltas;
    }

    public void calcular(String[] stringArray) {
        int i;

        String[] arrayAux = new String[stringArray.length];

        for (i = 0; i < stringArray.length; i++) {
            arrayAux[i] = stringArray[i].substring (0, stringArray[i].length() - 1);
        }

        for (i = 0; i < arrayAux.length; i++) {
            if (!quadros.contains(arrayAux[i])) {
                this.faltas++;
                if (quadros.size() < numeroDeQuadros) {
                    
                    quadros.add(arrayAux[i]);
                }
                else {
                    int aux = 0;
                    int j = 0;
                    int k, indice = 0;
                    boolean interruption = false;

                    while(j < numeroDeQuadros){
                        k = i+1;
                        while(k < arrayAux.length){
                            if(quadros.get(j) != arrayAux[k]){
                                k++;
                            }
                            
                            else{
                                interruption = true;
                                if(k > aux){
                                    aux = k;
                                    indice = j;
                                }
                                break;
                            }
                        }

                        if(!interruption){
                            indice = j;
                            break;
                        }
                        j++;
                    }
                    quadros.remove(indice);
                    quadros.add(indice,arrayAux[i]);
                }
            }

            else {
                this.acertos++;
            }
        }
    }
}
