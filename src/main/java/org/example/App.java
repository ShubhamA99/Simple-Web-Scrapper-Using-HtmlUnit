package org.example;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App 
{
    public static void main( String[] args ) throws IOException {


        try (WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);

            HtmlPage page = webClient.getPage("www.example.com/pagename"); // Replace with your target URL

            // Replace "example-class" with the actual class name you want to scrape
            final String className = "classname";

            // Find all elements with the specified class name
            DomNodeList<DomElement> elements = page.getElementsByTagName("a");

            ArrayList<Map<String,String>> arr = new ArrayList<>();
            // Iterate over the elements and extract the links
            for (DomElement element : elements) {
                String classAttribute = element.getAttribute("class");
                if (classAttribute != null && classAttribute.contains(className)) {
                    Map<String,String> NameLink = new HashMap<String,String>();
                   String name =  element.getTextContent();
                    String link = element.getAttribute("href");
                    System.out.println("---------------------------");
                    System.out.println(name);
                    System.out.println(link);
                    NameLink.put("Name",name);
                    NameLink.put("Link",link);
                    arr.add(NameLink);
                    System.out.println("---------------------------");
                }
                System.out.println(arr);
            }
            System.out.println(elements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
