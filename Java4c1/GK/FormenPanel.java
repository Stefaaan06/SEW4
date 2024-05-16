package Java4c1.GK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormenPanel extends JPanel {
    private JButton formDreieck, formRaute, formRechteck, farbeRot, farbeGruen, farbeBlau, fuellungHohlGefuellt;
    private JTextField hoehe, breite;
    private FormenGrafik grafik;
    private JLabel status;

    public FormenPanel() {
        setLayout(new BorderLayout());

        // linker Bereich
        grafik = new FormenGrafik(1, Color.BLACK, 100, 100, false);
        grafik.setBackground(Color.LIGHT_GRAY);
        add(grafik, BorderLayout.LINE_START);

        // rechter Bereich
        status = new JLabel("  Status: Bereit");
        status.setOpaque(true);
        status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        add(status, BorderLayout.PAGE_END);

        JPanel panelMitte = new JPanel(new GridLayout(5, 1));

        // input felder
        formRaute = new JButton("Raute");
        formDreieck = new JButton("Dreieck");
        formRechteck = new JButton("Rechteck");
        farbeRot = new JButton("Rot");
        farbeBlau = new JButton("Blau");
        farbeGruen = new JButton("Grün");
        fuellungHohlGefuellt = new JButton("Hohl");
        hoehe = new JTextField("100", 5);
        breite = new JTextField("100", 5);

        // Form
        JPanel panelReiheForm = new JPanel();
        panelReiheForm.add(new JLabel("  Form:    "));
        panelReiheForm.add(formDreieck);
        panelReiheForm.add(formRaute);
        panelReiheForm.add(formRechteck);
        panelMitte.add(panelReiheForm);
        // Höhe
        JPanel panelReiheHoehe = new JPanel();
        panelReiheHoehe.add(new JLabel("Höhe:    "));
        panelReiheHoehe.add(hoehe);
        panelMitte.add(panelReiheHoehe);
        // Breite
        JPanel panelReiheBreite = new JPanel();
        panelReiheBreite.add(new JLabel("Breite:    "));
        panelReiheBreite.add(breite);
        panelMitte.add(panelReiheBreite);
        // Farbe
        JPanel panelReiheFarbe = new JPanel();
        panelReiheFarbe.add(new JLabel("Farbe:    "));
        panelReiheFarbe.add(farbeRot);
        panelReiheFarbe.add(farbeBlau);
        panelReiheFarbe.add(farbeGruen);
        panelMitte.add(panelReiheFarbe);
        // Füllung
        JPanel panelReiheFuellung = new JPanel();
        panelReiheFuellung.add(new JLabel("Füllung:    "));
        panelReiheFuellung.add(fuellungHohlGefuellt);
        panelMitte.add(panelReiheFuellung);

        add(panelMitte, BorderLayout.CENTER);

        // Action Listener für Buttons
        ActionListener buttonListener = e -> {
            if (e.getSource() == formDreieck)
                grafik.setForm(1);
            else if (e.getSource() == formRaute)
                grafik.setForm(2);
            else if (e.getSource() == formRechteck)
                grafik.setForm(0);
            else if (e.getSource() == farbeRot)
                grafik.setFarbe(Color.RED);
            else if (e.getSource() == farbeGruen)
                grafik.setFarbe(Color.GREEN);
            else if (e.getSource() == farbeBlau)
                grafik.setFarbe(Color.BLUE);
            else if (e.getSource() == fuellungHohlGefuellt) {
                boolean hohl = !grafik.isHohl();
                fuellungHohlGefuellt.setText(hohl ? "Gefüllt" : "Hohl");
                grafik.setHohl(hohl);
            }

            updateStatus("Letzte Änderung: " + ((JButton) e.getSource()).getText());
        };

        formDreieck.addActionListener(buttonListener);
        formRaute.addActionListener(buttonListener);
        formRechteck.addActionListener(buttonListener);
        farbeRot.addActionListener(buttonListener);
        farbeGruen.addActionListener(buttonListener);
        farbeBlau.addActionListener(buttonListener);
        fuellungHohlGefuellt.addActionListener(buttonListener);

        // Document Listener für Textfelder
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            private void update() {
                try {
                    int width = Integer.parseInt(breite.getText());
                    int height = Integer.parseInt(hoehe.getText());
                    grafik.setWidth(width);
                    grafik.setHeight(height);
                    updateStatus("Höhe und Breite wurden geändert");
                } catch (NumberFormatException ex) {
                    updateStatus("Fehler bei der Eingabe! Höhe und Breite auf 0 gesetzt");
                    grafik.setWidth(0);
                    grafik.setHeight(0);
                }
            }
        };

        hoehe.getDocument().addDocumentListener(documentListener);
        breite.getDocument().addDocumentListener(documentListener);
    }

    private void updateStatus(String message) {
        status.setText("  Status: " + message);
    }
}
