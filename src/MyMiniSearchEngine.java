import java.util.*;

/** By: Christina Ninh
 * (https://www.daniweb.com/programming/software-development/threads/127733/help-to-design-a-simple-search-engine-in-java)
 */
public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private Map<String, List<List<Integer>>> indexes;

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.
    private void index(List<String> texts) {
        //homework

        indexes = new HashMap<>();

        //parse strings from texts to map
        for(int i = 0; i < texts.size(); i++) {
            String[] words = texts.get(i).split("\\s");

            //word > document + location
            for (int j = 0; j < words.length; j++) {
                if (!indexes.containsKey(words[j])) {
                    List<List<Integer>> arr = new ArrayList<>();
                    for (int k = 0; k < texts.size(); k++) {
                        arr.add(new ArrayList<Integer>());
                    }
                    indexes.put(words[j], arr);
                }
                indexes.get(words[j]).get(i).add(j);
            }
        }
        System.out.println(indexes);

    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        String[] result = keyPhrase.split("\\s"); //tokenizes the line into separate strings based on spaces only

        //key is case sensitive, finds all solutions for key
        result[0] = stringHelper(result[0]);
        List<List<Integer>> location = indexes.get(result[0]);

        for(int i = 1; i < result.length; i++) {
            result[i] = stringHelper(result[i]);
            List<List<Integer>> temp = indexes.get(result[i]);
            if(temp == null) {
                return new ArrayList<>();
                for(int j = 0; j < location.size(); j++) {
                    if(location.get(j).isEmpty()) {
                        temp.get(j).clear();
                    } else {
                        for(int k = 0; k < temp.get(j).size(); k++) {
                            int m = 0;
                            while(location.get(j).get(m) < temp.get(j).get(k)) {
                                m++;
                                if(m >= location.get(j).size()) {
                                    break;
                                }
                                if( m > 0) {
                                    --m;
                                }
                                if(location.get(j).get(m) != (temp.get(j).get(k)-1)) {
                                    temp.get(j).remove(k);
                                    k--;
                                }
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(); //placeholder
    }

    //strips the strings down to the conditions we want
    public static String stringHelper (String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z]", "");
        return s;
    }
}



