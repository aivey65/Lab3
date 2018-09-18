import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        System.out.println(countOneWord("Hamlet", urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(final String word) {
        String[] myWord = word.split("\\s+");
        return myWord.length;
    }

    public static int countOneWord(final String word, final String text) {
        String[] arrayOfText = text.split("\\s+");
        int count = 0;
        for (int i = 0; i < arrayOfText.length; i++) {
            if (arrayOfText[i].toLowerCase().equals(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}
