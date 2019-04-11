/*
* CS2852
* Fall 2018
* Lab 4 - AutoCompleter Interface
* Created: 9/29/2018
*/
package iliescua;

import java.io.File;

/**
 * Interface that the other classes implement in order to
 * read in the dictionary and display all of the keywords
 */
public interface AutoCompleter {
    /**
     * loads the dictionary file
     * @param filename file name of the dictionary file
     */
    void initialize(File filename);

    /**
     * returns a list of all the prefix matches in the dictionary
     * @param prefix used to search for all words with the same prefix
     */
    void allThatBeginWith(String prefix);

    /**
     * calculates and returns the number of nanoseconds
     * required by the last call to the prior two methods
     * @return time it took to find searches or load file
     */
    Long getLastOperationTime();
}
