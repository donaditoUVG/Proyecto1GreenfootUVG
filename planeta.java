import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * El objeto Planeta conserva su díametro y solo varía la posición en 
 * la que aparece.
 */
public class planeta extends Actor
{
    private int speed;
    
    public planeta (int v) {
        GreenfootImage naveimg = getImage();
        int myNewHeight = (int)naveimg.getHeight()/5;
        int myNewWidth = (int)naveimg.getWidth()/5;
        naveimg.scale(myNewWidth, myNewHeight);
        speed = v;
    }
    
    /**
     * Método Auxiliar: Aumentar Dificultad de acuerdo con la puntuación
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + speed);
        if( getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.aumentar_puntuacion(10);
            juego.disminuir_num_rivales();
            juego.aumentar_num_adelantamientos();
            
        }
    }
}
