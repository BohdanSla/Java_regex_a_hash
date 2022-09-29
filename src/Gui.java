

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {
    private JLabel mail,heslo,znovuHeslo;
    private JTextField novyMail;
    private JPasswordField novyHeslo,potvrzeniNovehoHesla;
    private JPanel panelNaKomponenty;
    private JButton zrusit,potvrdit,zmenitUdaje,zavrit;

    private Regex regex;

    private Dimension dimension;
    
    public Gui() {
        super("aplikace");
 
        regex = new Regex();

        setLayout(new GridLayout(1,2));

        zmenitUdaje = new JButton("změnit údaje");
        zmenitUdaje.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showOptionDialog(null, panelNaKomponenty,
            "Změnit údaje", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, new Object[] {},
            null);
            }

        });
        add(zmenitUdaje);

        zavrit = new JButton("Zavřít aplikaci");
        zavrit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                UkladaniUdaju writer = new UkladaniUdaju();
                writer.ulozUdajeUzivatele();
                System.exit(0);
            }

        });
        add(zavrit);


        panelNaKomponenty = new JPanel();
        panelNaKomponenty.setPreferredSize(new Dimension(350,200));
        panelNaKomponenty.setLayout(new GridLayout(4,2));

        mail = new JLabel("Zadej Mail:");
        panelNaKomponenty.add(mail);

        novyMail = new JTextField();
        panelNaKomponenty.add(novyMail);

        heslo = new JLabel("Zadej Heslo:");
        panelNaKomponenty.add(heslo);

        novyHeslo = new JPasswordField();
        panelNaKomponenty.add(novyHeslo);

        znovuHeslo = new JLabel("Heslo znovu:");
        panelNaKomponenty.add(znovuHeslo);

        potvrzeniNovehoHesla = new JPasswordField();
        panelNaKomponenty.add(potvrzeniNovehoHesla);

        zrusit = new JButton("Zrušit");
        zrusit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.getRootFrame().dispose();
            }});
        panelNaKomponenty.add(zrusit);

        potvrdit = new JButton("Potvrdit");
        potvrdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                boolean jeZmenenMail = false,jeZmenenoHeslo = false;
                if (!novyMail.getText().isEmpty()) {
                    jeZmenenMail = regex.zkontrolujMail(novyMail.getText());
                }
                if(novyHeslo.getPassword().length != 0 && potvrzeniNovehoHesla.getPassword().length != 0) {
                    jeZmenenoHeslo = regex.zkontrolujHeslo(novyHeslo.getPassword(), potvrzeniNovehoHesla.getPassword());
                }
                if (jeZmenenoHeslo && jeZmenenMail) {
                    JOptionPane.showMessageDialog(null, "Heslo a mail byly změněny");
                    JOptionPane.getRootFrame().dispose();
                } else if(jeZmenenoHeslo && novyMail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Heslo bylo změněno");
                    JOptionPane.getRootFrame().dispose();
                } else if(jeZmenenMail && novyHeslo.getPassword().length == 0 && potvrzeniNovehoHesla.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Mail byl změněn");
                    JOptionPane.getRootFrame().dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Mail nebo heslo nejsou validní");
                }
            }});
        panelNaKomponenty.add(potvrdit);
        
    }
}
