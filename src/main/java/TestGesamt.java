import java.util.ArrayList;
import java.util.Map;

public class TestGesamt {

    /**
     * Methode fuehrt eine Suche mit den verschiedenen Sucharten durch und gibt die gefunden Artikel aus
     */
    public static void main (String[] args){
        //Input Artikel
        //WAPOId ist die ID der Washington Post
        String WAPOId ="34d4708d7cce27237b991c02c98eeeb5";
        String WAPOId2 = "ecb715f2-efd4-11e2-9008-61e94a7ea20d";


        System.out.println("Der Basis Artikel hat die ID: "+ WAPOId );



        //--------------------------Test SUCHE MIT DocFreq--------------------------

        System.out.println("---------------TEST MIT DOC FREQ---------------");
        SearchWithDocFreq searchWithDocFreq;
        ArrayList<String> arrayList;
        searchWithDocFreq = new SearchWithDocFreq();
        arrayList = searchWithDocFreq.search(WAPOId);
        searchWithDocFreq.search(WAPOId2);
        System.out.println("Gefundene Artikel:");
        System.out.println(arrayList);




        //--------------------------Test SUCHE MIT CORENLP--------------------------

        System.out.println("---------------TEST MIT CORENLP---------------");
        SearchWithCoreNLP searchWithCoreNLP = new SearchWithCoreNLP();
        searchWithCoreNLP.startClient();
        Map ausgabe = searchWithCoreNLP.search(WAPOId);
        Map ausgabe2 = searchWithCoreNLP.search(WAPOId2);
        System.out.println("Gefundene Artikel:");
        System.out.println(ausgabe);
        System.out.println(ausgabe2);
        searchWithCoreNLP.closeClient();


    }

}
