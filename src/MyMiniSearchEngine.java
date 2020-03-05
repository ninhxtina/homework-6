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

        List<Integer> location = new ArrayList<>();

        for(int i = 0; i < result.length; i++) {
            if(!indexes.containsKey(keyPhrase)) {

            } else {
                return new ArrayList<>(); //return empty list if no matches
            }
        }
        return location;
    }
}



