package Util;

import java.util.*;
import java.util.Map.Entry;
import java.lang.Math;

import static TestKlassenFuerQueries.SearchWithLowLevelAPI.getDocsCount;
import static TestKlassenFuerQueries.SearchWithLowLevelAPI.getWordsFrequencies;

public class util {

    public static final long docsCount = getDocsCount();



    /**
     * Methode Splitten einen String in Teilwoerter und gibt ein Array zurueck.
     * Tokenization mittles White-Space
     * @param string String, welcher zerteilt werden soll
     * @return Gibt ein Array mit den Teilwoerten zurueck
     */
    public static String[] StringToArrayTokenization(String string){
        return string.split("\\s");

    }

    /**
     * Methode Nimmt eine WAPOId entgegen, berechnet IDF und gibt den Wert
     * zurueck
     * @param WAPOId Die ID im Index der WAPO entgegen
     * @return Gibt eine HashMap zurueck mit dem Wort als String und der errechneten IDF
     */
    public static HashMap calculateIDF(String WAPOId){
        HashMap<String,int[]> mapDocFreq;
        Iterator it;
        HashMap<String,Double> idf = new HashMap<String, Double>();


        mapDocFreq = getWordsFrequencies(WAPOId, "contents.contentString");

        //it = mapDocFreq.entrySet().iterator();

        for (Map.Entry<String, int[]> entry : mapDocFreq.entrySet()) {
            String key = entry.getKey();
            int[] value = entry.getValue();

            //idf = log(1 + |D|/df)
            //|D| : anzahl alle Dokumente im Index, df : doc_freq
            double idfValue = Math.log(1 + (docsCount/(double)value[0]));
            idf.put(key, idfValue);
        }
        return idf;


    }

    /**
     * Methode nimmt HashMap aus calcuteIDF entgegen und sortiert diese basierend auf idf-Ranking
     * @param idf nimmt HashMap idf entgegen
     * @return gibt sortierte HashMap tmp zurueck
     */

    public static HashMap<String, Double> sortedMap(HashMap<String, Double> idf)
    {
        Set<Entry<String, Double>> set = idf.entrySet();
        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return idf;
    }
}