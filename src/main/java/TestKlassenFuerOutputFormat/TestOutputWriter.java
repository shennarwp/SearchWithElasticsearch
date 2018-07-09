package TestKlassenFuerOutputFormat;

import OutputFormatTrec_Eval.Output;
import OutputFormatTrec_Eval.OutputWriter;

import java.io.IOException;

/**
 * Diese Klasse dient zum Testen der beiden Klassen "Output" und "OutputWriter"
 * Dabei werden von uns vorgegebene Daten im TREC-Output-Format auf der Standard-Ausgabe ausgegeben UND
 * in einer Datei gespeichert.
 */
public class TestOutputWriter {

    private final String pfadname = ".\\src\\main\\java\\TestKlassenFuerOutputFormat\\testOutput.txt";

    public void start() throws IOException {
        Output output1 = new Output(1, "abc",1.5);
        Output output2 = new Output(1, "def",1.2);
        Output output3 = new Output(2, "ghi",1.0);

        Output[] outputArray1 = new Output[2];
        Output[] outputArray2 = new Output[1];
        outputArray1[0] = output1;
        outputArray1[1] = output2;
        outputArray2[0] = output3;
        OutputWriter outputWriter = new OutputWriter();

        outputWriter.receive(outputArray1);
        outputWriter.receive(outputArray2);
        outputWriter.printToSTDOUT();
        outputWriter.writeToFile(pfadname);
    }


    public static void main (String[] args) throws IOException {
        new TestOutputWriter().start();


    }



}
