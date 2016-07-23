package com.ehealth.qtwo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abdulhakim on 7/23/16.
 */
public class ReplaceLinksAnchors {
    private static final String URL_REG = "^((https?|http?|ftp?)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";

    // Pattern for recognizing a URL, based off RFC 3986
    private static final Pattern urlPattern = Pattern.compile(
            "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                    + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                    + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);


    public String convertWebsitesToAnchors(String str) {

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

        if (args.length != 0) {
            theStr = args[0];
            ReplaceLinksAnchors rp = new ReplaceLinksAnchors();
            System.out.println("The resulting string below with achnored links: ");
            System.out.println(rp.convertWebsitesToAnchors(theStr));
        } else {
            System.out.println("No string provided");
            System.exit(0);
        }

    }
}
