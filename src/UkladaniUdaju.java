import java.io.*;


public class UkladaniUdaju {
    Uzivatel uzivatel;
    public void ulozUdajeUzivatele() {
        try {
            uzivatel = Uzivatel.getInstance();
            if(uzivatel.getHeslo() != null || uzivatel.getMail() != null) {     
                File soubor = new File("C:\\Users\\Bohdan Slawisch\\Desktop\\programování škola\\JAVA\\projekty\\3.D\\regularnivyrazy\\udaje.csv");
                soubor.createNewFile();
                FileWriter writer = new FileWriter(soubor);
                writer.write(uzivatel.getMail()+ ";" + uzivatel.getHeslo());
                writer.close();
            }

        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
