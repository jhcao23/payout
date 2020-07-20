package technology.touchmars.util;

import java.util.ArrayList;
import java.util.List;

// the easiest way to read csv file is invoke a python program to parse it LOL.
public class CsvReader {

    public static final char DOUBLE_QUOTE = '"';
    public static final char DOUBLE_QUOTE_BACK = '\"';
    public static final char CSV_SEPARATOR = ',';
    
    public static List<String> readLine(String line) {
        return readLine(line, CSV_SEPARATOR, DOUBLE_QUOTE);
    }

    public static List<String> readLine(String line, char sep, char quote) {
        List<String> sol = new ArrayList<String>();
        if (line==null || line.trim().isEmpty()) {
            return sol;
        }

        if (sep == ' ') {
            sep = CSV_SEPARATOR;
        }
        if (quote == ' ') {
            quote = DOUBLE_QUOTE;
        }

        StringBuilder b = new StringBuilder();
        boolean withinQuote = false;
        boolean hasDoubleQuote = false;
        boolean start = false;

        for (char c: line.toCharArray()) {
            if (withinQuote) {
                start = true;
                if (c == quote) {
                    withinQuote = false;
                    hasDoubleQuote = false;
                } else {
                    // allow empty double quote inside
                    if (c == DOUBLE_QUOTE_BACK) {
                        if (!hasDoubleQuote) {
                            b.append(c);
                            hasDoubleQuote = true;
                        }
                    } else {
                        b.append(c);
                    }
                }

            } else {
                if (c == quote) {
                    withinQuote = true;
                    // allow empty double quote
//                    System.out.println(b.toString());
                    if (b.length()>0 && b.charAt(0)!=DOUBLE_QUOTE && quote==DOUBLE_QUOTE_BACK){
                        b.append(DOUBLE_QUOTE);
                    }
                    // double quotes
                    if (start) {
                        b.append(DOUBLE_QUOTE);
                    }
                } else if (c == sep) {
                    sol.add(b.toString().trim());
                    b = new StringBuilder();
                    start = false;
                } else if (c == '\r') {
                    continue;
                } else if ( c== '\n') {
                    break;
                } else {
                    b.append(c);
                }
            }
        }

        sol.add(b.toString().trim());
        return sol;
    }

    public static void main(String[] args) {

        List<String> list = CsvReader.readLine("mbrown@myco.com,\"100,50\",,,EUR,ID001,Here is your payment, PAYPAL");
//        List<String> list = CsvReader.readLine("'10'|'AU'|'Aus\"\"tralia'", '|', '\'');
        for (String l:list) {
            System.out.println(l);
        }
    }
}
