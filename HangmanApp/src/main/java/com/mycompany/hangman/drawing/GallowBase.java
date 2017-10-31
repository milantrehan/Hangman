package com.mycompany.hangman.drawing;

/**
 *
 * @author Cory
 */
public class GallowBase extends GallowPiece
{
    protected static  int WIDTH = 100;
    protected static  int HEIGHT = 10;

    public GallowBase(int x, int y)
    {
        super(x, y);
    }

    @Override
    protected int getWidth()
    {
        return WIDTH;
    }

    @Override
    protected int getHeight()
    {
        return HEIGHT;
    }

}