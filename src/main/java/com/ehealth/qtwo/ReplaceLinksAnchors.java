package com.ehealth.qtwo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abdulhakim on 7/23/16.
 *
 * This program simply takes a string and replace all internet url with html anchors
 *
 */
public class ReplaceLinksAnchors {

    // Pattern for recognizing a URL, based off RFC 3986
    private static final Pattern urlPattern = Pattern.compile(
            "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                    + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                    + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);


    public String convertWebsitesToAnchors(String str) {

        /*
        *Takes the string and replace all internet urls with proper html links
        *
        * */
        //System.out.println(str);
        String[] arrStr = str.split("\\s+");
        String newStr = "";
        for (String s : arrStr) {
            Matcher match = urlPattern.matcher(s);
            if (match.matches()) {
                String p = " <a href=\"" + s + "\">" + s + "</a>";
                newStr += p + " ";

            } else {
                newStr += " " + s;
            }
        }
       // System.out.println(newStr);
        return newStr;

    }

    public static void main(String[] args) {
        String theStr;
   /*
   * Collect the passed strings  via args array
   *
   * */
        if (args.length != 0) {
            theStr = args[0];
            //Instantiate Object
            ReplaceLinksAnchors rp = new ReplaceLinksAnchors();
            //Inform the user
            System.out.println("The resulting string below with achnored links: ");
            //Call the convertWebsitesToAnchor method and print the returned value
            System.out.println(rp.convertWebsitesToAnchors(theStr));
        } else {
            System.out.println("No string provided");
            System.exit(0);
        }

    }
}
