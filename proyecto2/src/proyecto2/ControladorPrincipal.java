package proyecto2;

public class ControladorPrincipal 
{
    //Variables globales
    ventanaPrincipal controlador1 = new ventanaPrincipal();
    String option;
    //Constructor
    public ControladorPrincipal()
    {
        option = controlador1.getOpciones().getSelectedItem().toString();
    }
    
    //Gets y sets
    
    
    //Funciones
    public void logicaVentanaPrincipal()
    {
            
        //Menu de control para las opciones deisponibles
        switch(option){
            case "EQUIPOS PARTICIPANTES POR CONFEDERACIÓN":  
                break;
            case "INFORME OFICIAL DEL PARTIDO":
                break;
            case "GRUPOS Y CLASIFICACIONES":
                break;                        
            case "TABLA GENERAL DE POSICIONES":
                break;
            case "TABLA DE GOLEADORES":
                break;
            default:
        }
        
        //Fin del menu controlador principal
    }
    
    //Fin de la clase ControladorPrincipal
}
