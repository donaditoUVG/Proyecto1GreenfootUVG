import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    private contador score;
    private contador level;
    
    private int velocidad_nave;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private int num_rivales;
    
    private nave tilin;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1); 
        
        num_adelantamientos = 0;
        num_adelantamientos_nivel = 4;
        velocidad_nave = 2;
        
        score = new contador("Score: " );
        level = new contador("Level: " );
        level.add(1);
        tilin = new nave(velocidad_nave);
        
        addObject(tilin, 300,600);
        addObject(level, 205, 90);
        addObject(score, 205, 60);
    }
    
    public void act(){
        aumentar_dificultad();
        aniadir_rivales();
    }
    
    public int getRandomNumber(int start, int end){
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal + start;
    }
    
    public void aumentar_puntuacion(int valor){
        score.add(valor);
    }
    
    public void aumentar_num_adelantamientos(){
        num_adelantamientos++;
    }
    
    public void disminuir_num_rivales(){
        num_rivales--;
    }
    
    public void aumentar_dificultad(){
        if(num_adelantamientos == num_adelantamientos_nivel){
            num_adelantamientos = 0;
            num_adelantamientos_nivel = num_adelantamientos_nivel + 2;
            velocidad_nave++;
            level.add(1);
            tilin.aumenta_velocidad();
        }
    }
    
    public void aniadir_rivales(){
        if(num_rivales == 0){
            int carril = getRandomNumber(0,3);
            
            if (carril == 0){
                addObject(new planeta (velocidad_nave), 120, 80);
            }
            else if(carril == 1){
                addObject(new planeta (velocidad_nave), 240, 80);
            }
            else if(carril == 2){
                addObject(new planeta (velocidad_nave), 360, 80);
            }
            else if(carril == 3){
                addObject(new planeta (velocidad_nave), 480, 80);
            }
            else{
                addObject(new planeta (velocidad_nave), 600, 80);
            }
            
            carril++;
            carril = carril % 3;
            
            if (carril == 0){
                addObject(new planeta (velocidad_nave), 120, 80);
            }
            else if(carril == 1){
                addObject(new planeta (velocidad_nave), 240, 80);
            }
            else if(carril == 2){
                addObject(new planeta (velocidad_nave), 360, 80);
            }
            else if(carril == 3){
                addObject(new planeta (velocidad_nave), 480, 80);
            }
            else{
                addObject(new planeta (velocidad_nave), 600, 80);
            }
        }
        
        num_rivales = 2;
    }
}
