public class Uzivatel {
    private static Uzivatel instance;
    private String mail,heslo;

    private Uzivatel() {};

    public static Uzivatel getInstance() {
        if (instance == null) {
            instance = new Uzivatel();
        }
        return instance;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHeslo() {
        return this.heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }


}
