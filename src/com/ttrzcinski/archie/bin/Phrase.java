package com.ttrzcinski.archie.bin;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single phrase, which will be processed.
 *
 * Created by theadmin on 13.10.17.
 */
public class Phrase {
    //Constrains

    //Variables
    /**
     * Represents, if output comments should be presented in methods, while processing class.
     */
    private boolean flagNoComments;
    /**
     * Given content as a phrase to analyze.
     */
    private String content;
    /**
     * Types, to which content is matching.
     */
    private List<String> types;

    //Constructors
    private Phrase() {
        ;//Blocked constructor, forcing to use params
    }

    /**
     * Encapsulates given content and returns this as a object.
     *
     * @param content given content
     * @param noComment true mean blocking output comments, false lets them through
     */
    public Phrase(String content, boolean noComment) {
        this.initIt(content, noComment);
    }

    /**
     * Encapsulates given content and returns this as a object.
     *
     * @param content given content
     */
    public Phrase(String content) {
        this.initIt(content, false);
    }

    //Inner methods
    /**
     * Initializes new object with given params.
     *
     * @param content given content
     * @param noComment true mean blocking output comments, false lets them through
     */
    private void initIt(String content, boolean noComment) {
        //Sets flag for commenting to given setting
        this.flagNoComments = noComment;
        //Check of entered value
        if (content == null) {
            consoleFlaggedO("Is it really so hard to pass one value?");
            this.content = "";
        } else {
            //Set the value
            this.content = content.trim();
            //Process entered phrase
            this.processItAgain();
        }
    }

    /**
     * Throws given comment to console, if flag lets to.
     *
     * @param val
     */
    private void consoleFlaggedO(String val) {
        if (this.flagNoComments) consoleFlaggedO(val);
    }

    /**
     * Assures, that the content will not throw NPE.
     */
    private void assureNN_phrase() {
        if (this.content == null) this.content = "";
    }

    /**
     * Assure, that the content will not throw NPE.
     */
    private void assureNN_types() {
        if (this.types == null) this.types = new ArrayList<String>();
    }

    /**
     * Clears types - result of sentence analysis.
     */
    public void clearTypes() {
        this.types = new ArrayList<String>();
    }

    /**
     * Checks, if the content starts with any of given beginnings.
     *
     * @param listOfBeginnings given beginnings
     * @return true, if it start with one of them, false otherwise
     */
    public boolean startsWithAnyOf(String[] listOfBeginnings) {
        //Prepare the result flag
        boolean result = false;
        //Check entered argument
        if ((listOfBeginnings == null) || (listOfBeginnings != null && listOfBeginnings.length > 0)) {
            consoleFlaggedO("Hmm.. and I should compare with what?");
        } else if (listOfBeginnings.length > 0) {
            //Mark, that those still might be empty
            boolean wasEmptyAlready = false;
            //Iterate through given
            for (String beginning : listOfBeginnings) {
                //Check, if the beginning has any content
                if (beginning.trim().length() > 0) {
                    //Check, if the beginning is THE beginning
                    if (this.content.startsWith(beginning)) {
                        //Mark a match
                        result = true;
                        //forced exit as it was found
                        break;
                    }
                } else {
                    //Show sarcastic comment about empty beginning
                    consoleFlaggedO(wasEmptyAlready ? "Empty beginning.. useless, like the user." :
                            "Another empty.. what a waste of my time.");
                    wasEmptyAlready = true;
                }
            }
        } else {
            consoleFlaggedO("Mhm.. and I should compare it with what?");
        }
        //Return the result
        consoleFlaggedO(result ? "Well, at least one match.." : "No match at all.");
        return result;
    }

    /**
     * Checks, if array of words contains given word.
     *
     * @param words array of words
     * @param given given word
     * @return true, if it does, false otherwise
     */
    public boolean containsAny(String[] words, String given) {
        //TODO check NN on words
        //TODO check NN on given

        boolean result = false;
        for (String word : words) {
            if (given.equalsIgnoreCase(word)) {
                result = true;
                break;
            }
        }
        return result;
    }

    //TODO Check, how those methods are compiled.. maybe you should simplify as the compiler does.
    public void processItAgain() {
        //Assure, that content won't be null.
        this.assureNN_phrase();
        this.clearTypes();
        //Check ending of given content
        if (this.content.endsWith("?!")) {
            types.add("DIGRESSION");
        } else if (this.content.endsWith("?")) {
            types.add("QUESTION");
        } else if (this.content.endsWith("!")) {
            types.add("SHOUT");
        } else if (this.content.endsWith("..")) {
            types.add("TBC");
        } else if (this.content.endsWith(":-)")) {
            types.add("EMOTICON");
        } else if (this.content.endsWith(".")) {
            types.add("SENTENCE");
        }
        //Check beginning of given content
        if (this.content.startsWith("No")) {
            types.add("Negation");
        }
        //Check the parts inside
        types.add(this.content.contains(",") ? "COMPLEX" : "SIMPLE");
    }

    //Interface methods

    //Accessors
    /**
     * Returns kept content
     *
     * @return kept content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Sets content to given content.
     *
     * @param val given content
     */
    public void setContent(String val) {
        this.content = val;
        //Process entered phrase
        this.processItAgain();
    }

    /**
     * Checks, if flag of not commenting is set.
     *
     * @return true, if is, false otherwise
     */
    public boolean isFlagNoComments() {
        return this.flagNoComments;
    }

    public void setFlagNoComments(boolean val) {
        this.flagNoComments = val;
    }
}
