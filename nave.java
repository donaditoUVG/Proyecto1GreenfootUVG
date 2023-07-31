import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * El objeto nave puede moverse a lo largo del plano R2.
 * 
 * Le queremos colocar músicaaaa
 */
public class nave extends Actor
{
    private int speed;
    
    public nave (int v){
        GreenfootImage naveimg = getImage();
        int myNewHeight = (int)naveimg.getHeight()/3;
        int myNewWidth = (int)naveimg.getWidth()/3;
        naveimg.scale(myNewWidth, myNewHeight);
        speed = v;
    }
    
    /**
     * Método Auxiliar para moverse con las teclas "WASD"
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.playSound("beuk.mp3");
        
        }
        if(Greenfoot.isKeyDown("d")){
            if(getX()< 500)
            setLocation(getX() + speed, getY());
            
        }  
        if(Greenfoot.isKeyDown("a")){
            if(getX() > 100)
            setLocation(getX() - speed, getY());
        }
        if(Greenfoot.isKeyDown("w")){
            if(getY() > 250)
            setLocation(getX(), getY() - speed);
        }
        if(Greenfoot.isKeyDown("s")){
            if(getY() < 650)
            setLocation(getX(), getY() + speed);
        }
        
        checkCollision();
    }
    
    public void checkCollision(){
        Actor collided = getOneIntersectingObject(planeta.class);
        if(collided != null)
        {
            getWorld().removeObject(collided);
            getWorld().removeObject(this);
            Greenfoot.playSound("restchemistryNightcore.mp3");
            Greenfoot.stop();
        }
    }
    
    public void aumenta_velocidad(){
        speed++;
    }
}
