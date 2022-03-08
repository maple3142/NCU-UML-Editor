package net.maple3142.umleditor.misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class DrawingUtils {
    public static void drawAssociationLine(Graphics g, Color lineColor, int sx, int sy, int ex, int ey, int sideLength) {
        g.setColor(lineColor);
        g.drawLine(sx, sy, ex, ey);
        double theta = Math.atan2(-(ey - sy), ex - sx);
        double phi1 = theta - Math.PI / 6;
        double phi2 = Math.PI * 2 / 3 - phi1;
        int ax = ex;
        int ay = ey;
        int bx = (int) (ax - sideLength * Math.cos(phi1));
        int by = (int) (ay + sideLength * Math.sin(phi1));
        int cx = (int) (ax + sideLength * Math.cos(phi2));
        int cy = (int) (ay + sideLength * Math.sin(phi2));
        g.drawLine(ax, ay, bx, by);
        g.drawLine(ax, ay, cx, cy);
    }

    public static void drawGeneralizationLine(Graphics g, Color lineColor, int sx, int sy, int ex, int ey, int sideLength) {
        g.setColor(lineColor);
        g.drawLine(sx, sy, ex, ey);
        double theta = Math.atan2(-(ey - sy), ex - sx);
        double phi1 = theta - Math.PI / 6;
        double phi2 = Math.PI * 2 / 3 - phi1;
        int ax = ex;
        int ay = ey;
        int bx = (int) (ax - sideLength * Math.cos(phi1));
        int by = (int) (ay + sideLength * Math.sin(phi1));
        int cx = (int) (ax + sideLength * Math.cos(phi2));
        int cy = (int) (ay + sideLength * Math.sin(phi2));
        g.fillPolygon(new int[]{ax, bx, cx}, new int[]{ay, by, cy}, 3);
    }

    public static void drawCompositionLine(Graphics g, Color lineColor, int sx, int sy, int ex, int ey, int sideLength) {
        g.setColor(lineColor);
        g.drawLine(sx, sy, ex, ey);
        double theta = Math.atan2(-(ey - sy), ex - sx);
        double phi1 = theta - Math.PI / 4;
        double phi2 = theta;
        double phi3 = Math.PI * 3 / 4 - theta;
        int ax = ex;
        int ay = ey;
        int bx = (int) (ax - sideLength * Math.cos(phi1));
        int by = (int) (ay + sideLength * Math.sin(phi1));
        int cx = (int) (ax - sideLength * Math.sqrt(2) * Math.cos(phi2));
        int cy = (int) (ay + sideLength * Math.sqrt(2) * Math.sin(phi2));
        int dx = (int) (ax + sideLength * Math.cos(phi3));
        int dy = (int) (ay + sideLength * Math.sin(phi3));
        g.fillPolygon(new int[]{ax, bx, cx, dx}, new int[]{ay, by, cy, dy}, 4);
    }

    // copied from https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
}
