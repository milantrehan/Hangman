package com.mycompany.hangman.drawing.body;

import com.mycompany.hangman.drawing.DrawablePiece;
import java.awt.Color;
import java.awt.Graphics;

public class LeftLeg extends DrawablePiece
{

    public LeftLeg(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        double slope = 1;
        int x2 = 25;
        double y2 = slope * x2 + getY();
        int offset = getX();
        g.drawLine(getX(), getY(), offset - x2, (int) y2);

    }

}
