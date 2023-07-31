import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * El objeto "MyWorld" es utilizado para presentar el puntaje y nivel obtenido
 * conforme el jugador esquiva al objeto planeta.
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
     * Cada múltiplo de 100 se avanza un nivel.
     * 
     */
    public MyWorld()
    {    
        // Mundo de 600x400 cells con un tamaño de cell size de 1x1 pixels.
        super(600, 700, 1); 

        num_adelantamientos = 0;
        num_adelantamientos_nivel = 4;
        velocidad_nave = 2;

        score = new contador("PUNTAJE: " );
        level = new contador("NIVEL: " );
        
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

    /**Para aumentar la dificultad, la rapidez con la que los objetos 
     * planeta descienden se incrementa.
     */
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
