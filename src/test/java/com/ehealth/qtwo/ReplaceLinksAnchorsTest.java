package com.ehealth.qtwo;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by abdulhakim on 7/23/16.
 */

public class ReplaceLinksAnchorsTest {

    @Test
    public  void shouldPrintStringWithAnchors(){

        ReplaceLinksAnchors rpl = new ReplaceLinksAnchors();
   String testStr = "Hello, Sir, please click on the link www.example.com/confirmation?user1 and visit our website at www.example.com";
        String testResult = "Hello, Sir, please click on the link <a href=\"www.example.com/confirmation?user1\">www.example.com/confirmation?user1</a>  and visit our website at <a href=\"www.example.com\">www.example.com</a> ";

        Assert.assertEquals(StringUtils.strip(testResult), StringUtils.strip(rpl.convertWebsitesToAnchors(testStr)));
    }
}
