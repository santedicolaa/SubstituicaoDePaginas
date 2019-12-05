import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] agrs) {
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a qtd de frames");
        String qtdeFramesInicial = scanner.nextLine();

        System.out.println("Qtde Frames inicial: " + qtdeFramesInicial);
        String qtdeFramesFinal = scanner.nextLine();

        System.out.println("Qtde Frames final: " + qtdeFramesFinal);

        System.out.println("Prossiga com a entrada: ");

        String referencia = scanner.nextLine();
        String[] stringReferencia = referencia.split("-");

        int qtdeFramesf = Integer.parseInt(qtdeFramesFinal);

        for (int qtdFramesi = Integer.parseInt(qtdeFramesInicial); qtdFramesi <= qtdeFramesf; qtdFramesi++) {
            //AlgoritmoDeSubstituicao mru = new MRU(qtdFramesi);
            //AlgoritmoDeSubstituicao fifo = new FIFO(qtdFramesi);
            //Otimo otimo = new Otimo(qtdFramesi);
            //otimo.otimo(stringReferencia);

            SC secondChance = new SC(qtdFramesi);
            secondChance.secondChance(stringReferencia, 8);

            //System.out.println("\nOtimo com "+qtdFramesi+" frames:");
            //System.out.println("Page Faltas: " + otimo.getFaltas());
            //System.out.println("Page Acertos: " + otimo.getAcertos());
            //System.out.println("\n");

            System.out.println("\nSC com "+qtdFramesi+" frames:");
            System.out.println("Page Faltas: " + secondChance.getFaltas());
            System.out.println("Page Acertos: " + secondChance.getAcertos());
            System.out.println("\n");

            /*for (int i = 0; i < (stringReferencia.length); i++) {
                //System.out.println(stringReferencia[i]);
                mru.inserir(stringReferencia[i]);
                fifo.inserir(stringReferencia[i]);

            }

            System.out.println("\nMRU com "+qtdFramesi+" frames:");
            System.out.println("Page Faults: " + mru.getPageFaultCount());
            System.out.println("Page Acertos: " + mru.getPageFoundCount());

            System.out.println("\n\nFifo com "+qtdFramesi+" frames:");
            System.out.println("Page Faults: " + fifo.getPageFaultCount());
            System.out.println("Page Acertos: " + fifo.getPageFoundCount());*/

        }

    }
}
