package fopt.buch.absch441;

import java.util.HashMap;
import java.util.Random;

public class Model
{
    // Declaration of pair list
    private HashMap<String, String> vocabulary;

    private String[] keywords;

    public Model()
    {
        this.random = new Random(100);
        this.vocabulary = new HashMap<>();
        this.fillVocabulary();
        // Fill keyword from hast table.
        this.keywords = this.vocabulary.keySet().toArray(new String[0]);
    }

    private void fillVocabulary()
    {
        this.vocabulary.put("Katze", "cat");
        this.vocabulary.put("Hund", "dog");
        this.vocabulary.put("Auto", "car");
        this.vocabulary.put("Essen", "eat");
        this.vocabulary.put("Tanzen", "dance");
        this.vocabulary.put("Anrufen", "to call");

    }

    private String keyword;

    private Random random;

    public String choose()
    {
        int index = (int) (this.random.nextDouble() * 6);
        return this.keywords[index];

    }

    public String getResponse(String keyword)
    {
        return this.vocabulary.get(keyword);
    }

}
