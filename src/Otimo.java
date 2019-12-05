import java.util.LinkedList;

public class Otimo {
    private LinkedList<String> quadros;
    private LinkedList<Integer> delta;
    private int acertos;
    private int faltas;
    private int numeroDeQuadros;

    public Otimo(int frames) {
        this.acertos = 0;
        this.faltas = 0;
        this.numeroDeQuadros = frames;
        this.quadros = new LinkedList<>();
        this.delta = new LinkedList<>();

    }

    public int getPageFoundCount() {
        return acertos;
    }

    public int getPageFaultCount() {
        return faltas;
    }

    public int calcularDelta (String[] array, int ini, String num){
        int delta = 0;
        for(int i = ini; i<array.length; i++){
            if(num.equals(array[i])){
                return delta;
            }
            delta++;
        }
        return delta+1;
    }

    public void rodar(String[] stringEntrada) {
        int i, j, aux;

        String[] arrayAux = new String[stringEntrada.length];

        for (i = 0; i < stringEntrada.length; i++) {
            arrayAux[i] = stringEntrada[i].substring (0, stringEntrada[i].length() - 1);
        }

        for (i = 0; i<arrayAux.length; i++){
            if(!quadros.contains(arrayAux[i])){
                this.faltas++;

                if(quadros.size() < numeroDeQuadros){
                    System.out.println("Falta! Entra o "+arrayAux[i]);
                    quadros.add(arrayAux[i]);
                }

                else{
                    int ini_delta = i+1;
                    delta.clear();
                    if(ini_delta>=arrayAux.length){
                        System.out.println("Falta! Sai o "+quadros.get(0)+" e entra o "+arrayAux[i]);
                        quadros.remove(0);
                        quadros.add(0,arrayAux[i]);
                    }

                    else{
                        for(j=0;j<quadros.size();j++){
                            delta.add(calcularDelta(arrayAux,ini_delta,quadros.get(j)));
                        }

                        aux = 0;
                        for(j = 0; j<delta.size();j++){
                            if(delta.get(j) > aux){
                                aux = j;
                            }
                        }

                        delta.clear();
                        System.out.println("Falta! Sai o "+quadros.get(aux)+" e entra o "+arrayAux[i]);
                        quadros.remove(aux);
                        quadros.add(aux,arrayAux[i]);
                    }
                }
            }
            
            else{
                System.out.println("Acerto! Permanece o "+arrayAux[i]);
                this.acertos++;
            }
        }
    }
}
