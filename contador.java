import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * El contador del Juego muestra el nivel y aumenta la dificultad
 * 
 * Donado y Sebastían
 * Por cada conjunto de planetas esquivados se le suman veinte puntos.
 */
public class contador extends Actor
{
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;

    public contador(){
        this("");
    }
    public contador(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(25.0F));  // Fuente más legible
        image.setColor(Color.RED);
        
        updateImage();
    }
    public void act() {
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }
    public void add(int score){
        target += score;
    }
    public void subtract(int score){
        target -= score;
    }
    public int getValue(){
        return value;
    }
    private void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}
