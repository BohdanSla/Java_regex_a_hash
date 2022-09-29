import java.util.regex.*;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Regex {
    private Uzivatel uzivatel;

    public Regex() {
        uzivatel = Uzivatel.getInstance();
    }

    public boolean zkontrolujMail(String mail) {
        if(uzivatel.getMail() != null)
            if (uzivatel.getMail().equals(mail)) {
                return false;
            }

        Pattern patern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]{1,64}@[a-zA-Z0-9.-]{1,253}\\.[a-zA-Z]{2,}$");
        Matcher matcher = patern.matcher(mail);

        
        if (matcher.find()) {
            uzivatel.setMail(mail);
            return true;
        } else {
            return false;
        }
    }
    public boolean zkontrolujHeslo(char[] heslo,char[] hesloPotvrzeni) {
        String hesloKontrola = String.valueOf(heslo);

        if(uzivatel.getHeslo() != null) {
            if(BCrypt.checkpw(hesloKontrola, uzivatel.getHeslo())) {
                return false;
            }
        }
        if (heslo.length != hesloPotvrzeni.length) {
            return false;
        } else {
            for (int i = 0; i < heslo.length; i++) {
                if(Character.compare(heslo[i], hesloPotvrzeni[i])!= 0) {
                    return false;
                }
            }
        }
        Pattern patern = Pattern.compile("^(?=.*[a-ž])(?=.*[A-Ž])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{12,}$");
        Matcher matcher = patern.matcher(hesloKontrola);

        for (int i = 0; i < heslo.length; i++) {
            heslo[i] = hesloPotvrzeni[i] = 0;
        }
        
        if(matcher.find()) {
            uzivatel.setHeslo(BCrypt.hashpw(hesloKontrola, BCrypt.gensalt()));
            return true;
        } else {
            return false;
        }
    }
}
