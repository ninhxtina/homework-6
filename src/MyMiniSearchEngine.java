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
        //insert key (string, list<list>integer>>
        //hash key string into num
        //indexes = hash, parse words correctly into the map
        //word > document + location

        //indexes = new Map<String,List<List<Integer>>>();

        indexes = new HashMap<>();

        //parse strings from texts to map
        for(int i = 0; i < texts.size(); i++) {
            String[] words = texts.get(i).split("\\s");
        }

    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        //if it can't find a match, return an empty list
        if(keyPhrase == null) {
            return new ArrayList<>();
        }

        Hashtable<String, ArrayList<String>> ht = new Hashtable<String, ArrayList<String>>();
        while (true) {
            String[] result = keyPhrase.split("\\s"); //tokenizes the string into separate strings
            //based on spaces only
            for (int i = 0; i < result.length; i++) {
                if (!ht.containsKey(result[i])) {
                    ArrayList<String> temp = new ArrayList<String>(1);
                    temp.add(keyPhrase);
                    ht.put(result[i], temp);//assigns a key to anon arraylist that stores the value
                } else {
                    ArrayList<String> temp = (ArrayList<String>) ht.get(result[i]);
                    temp.add(keyPhrase);
                }
            }
            return (List<Integer>) ht; //hashtable can't cast to list
        }
    }
}



