package com.example.th.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {

    private int canvasWidth;

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private int canvasHeight;

    public AlgoFrame(String name, int canvasWidth, int canvasHeight) {
        super(name);

        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

//        this.setSize(getCanvasWidth(), getCanvasHeight());
        AlgoCanvas canvas = new AlgoCanvas();
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);
        pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    public AlgoFrame(String name) {
        this(name, 1000, 1000);
    }

    private class AlgoCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
//            g.drawOval(10, 10, 200, 200);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(5));

            g2d.setColor(Color.RED);
            Ellipse2D.Double cicle = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.draw(cicle);

            g2d.setColor(Color.BLUE);
            Ellipse2D.Double cicle2 = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.fill(cicle2);


        }
    }
}














