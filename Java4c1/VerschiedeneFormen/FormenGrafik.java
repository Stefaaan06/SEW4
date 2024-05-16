package Java4c1.VerschiedeneFormen;

import javax.swing.*;
import java.awt.*;

public class FormenGrafik extends JPanel {
    private int form;
    private Color farbe;
    private int width;
    private int height;
    private boolean hohl;

    public static final int RECHTECK = 0;
    public static final int DREIECK = 1;
    public static final int RAUTE = 2;

    public FormenGrafik(int form, Color farbe, int width, int height, boolean hohl) {
        this.form = form;
        this.farbe = farbe;
        this.width = width;
        this.height = height;
        this.hohl = hohl;
        setPreferredSize(new Dimension(200, 250));
    }

    public void setForm(int form) {
        if (form < 0 || form > 2) {
            throw new IllegalArgumentException("Keine existierende Form!");
        }
        this.form = form;
        repaint();
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
        repaint();
    }

    public void setWidth(int width) {
        if (width < 0) {
            throw new IllegalArgumentException("Breite muss positiv sein!");
        }
        this.width = width;
        repaint();
    }

    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Höhe muss positiv sein!");
        }
        this.height = height;
        repaint();
    }

    public void setHohl(boolean hohl) {
        this.hohl = hohl;
        repaint();
    }

    public boolean isHohl() {
        return hohl;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int mitteY = getHeight() / 2;
        int mitteX = getWidth() / 2;

        g.setColor(farbe);

        if (form == RECHTECK) {
            if (hohl)
                g.drawRect(mitteX - (width / 2), mitteY - (height / 2), width, height);
            else
                g.fillRect(mitteX - width / 2, mitteY - height / 2, width, height);
        } else if (form == DREIECK) {
            int[] xPoints = {mitteX + width / 2, mitteX + width / 2, mitteX - width / 2};
            int[] yPoints = {mitteY + height / 2, mitteY - height / 2, mitteY - height / 2};
            if (hohl)
                g.drawPolygon(xPoints, yPoints, 3);
            else
                g.fillPolygon(xPoints, yPoints, 3);
        } else if (form == RAUTE) {
            int[] xPoints = {mitteX - width / 4, mitteX, mitteX + width / 4, mitteX};
            int[] yPoints = {mitteY, mitteY + height / 2, mitteY, mitteY - height / 2};
            if (hohl)
                g.drawPolygon(xPoints, yPoints, 4);
            else
                g.fillPolygon(xPoints, yPoints, 4);
        }
    }
}
