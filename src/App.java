import java.awt.Dimension;
import java.util.regex.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // Java regex může být použit k úpravě nebo hledání textu
        // Java nemá build in regular express classu, takze se prida package java.util.regex, která má classy
        /*  Pattern Class - definuje patern znaků (zde se píše regulární výraz)
            Matcher Class - používá se k hledání dané skupiny znaků za použití pattern
            PatternSyntaxException Class - Indikuje syntax error v regularnim vyrazu 
         */
        String line = "aaaaaaaaaaaaaaaabc aaabc";
        Pattern p = Pattern.compile("a*b",Pattern.CASE_INSENSITIVE); // compile - zkompiluje dany regular expression, prvni parametr udava pattern, ktery se bude prohledavat, druhy parametr je flag. Ten podrobneji udava searchovani (CASE_INSENSTIVE bude ignorovat velka a mala pismena pri hledani)
        Matcher m = p.matcher(line); // matcher hleda pattern ve stringu, vraci matcher objekt, ktery ma informace o prohledavani
        boolean b  = m.find(); // find vraci true pokud se patern najde ve stringu a false pokud nenajde
        System.out.println(b);
        System.out.println(p.flags());
        line = m.replaceAll("ahoj"); //vsecny shody vymeni za dany parametr, firstAll jenom prvni shodu
        System.out.println(line);
        Gui gui = new Gui();
        gui.setSize(new Dimension(350,200));
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}
