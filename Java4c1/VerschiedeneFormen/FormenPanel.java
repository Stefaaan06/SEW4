package Java4c1.VerschiedeneFormen;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormenPanel extends JPanel {
    private JRadioButton formDreieck, formRaute, formRechteck;
    private JCheckBox fuellungHohlGefuellt;
    private JSlider farbeRot, farbeGruen, farbeBlau;
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
        formRaute = new JRadioButton("Raute");
        formDreieck = new JRadioButton("Dreieck");
        formRechteck = new JRadioButton("Rechteck");
        ButtonGroup formGroup = new ButtonGroup();
        formGroup.add(formDreieck);
        formGroup.add(formRaute);
        formGroup.add(formRechteck);
        fuellungHohlGefuellt = new JCheckBox("Hohl");
        hoehe = new JTextField("100", 5);
        breite = new JTextField("100", 5);

        farbeRot = new JSlider(0, 255, 0);
        farbeGruen = new JSlider(0, 255, 0);
        farbeBlau = new JSlider(0, 255, 0);

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
        panelReiheFarbe.add(farbeGruen);
        panelReiheFarbe.add(farbeBlau);
        panelMitte.add(panelReiheFarbe);
        // Füllung
        JPanel panelReiheFuellung = new JPanel();
        panelReiheFuellung.add(new JLabel("Füllung:    "));
        panelReiheFuellung.add(fuellungHohlGefuellt);
        panelMitte.add(panelReiheFuellung);

        add(panelMitte, BorderLayout.CENTER);

        // Action Listener für Buttons
        ChangeListener sliderListener = e -> {
            int red = farbeRot.getValue();
            int green = farbeGruen.getValue();
            int blue = farbeBlau.getValue();
            grafik.setFarbe(new Color(red, green, blue));
            updateStatus("Farbe geändert zu: " + red + ", " + green + ", " + blue);
        };

        farbeRot.addChangeListener(sliderListener);
        farbeGruen.addChangeListener(sliderListener);
        farbeBlau.addChangeListener(sliderListener);

        // Action Listener für RadioButtons und CheckBox
        ActionListener radioButtonListener = e -> {
            if (e.getSource() == formDreieck)
                grafik.setForm(1);
            else if (e.getSource() == formRaute)
                grafik.setForm(2);
            else if (e.getSource() == formRechteck)
                grafik.setForm(0);
            else if (e.getSource() == fuellungHohlGefuellt) {
                boolean hohl = fuellungHohlGefuellt.isSelected();
                grafik.setHohl(hohl);
            }

            updateStatus("Letzte Änderung: " + ((AbstractButton) e.getSource()).getText());
        };



        formDreieck.addActionListener(radioButtonListener);
        formRaute.addActionListener(radioButtonListener);
        formRechteck.addActionListener(radioButtonListener);
        fuellungHohlGefuellt.addActionListener(radioButtonListener);

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