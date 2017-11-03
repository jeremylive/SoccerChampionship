package proyecto2;

public class ControladorPrincipal 
{
    //Variables globales
    String option;
    
    //Constructor
    public ControladorPrincipal()
    {
        option = "";
    }
        
    //Gets and Sets
    public void setOption(String opcion)
    {
        this.option = opcion;
    }
    
    
    //Funciones
    public void equiposCof()
    {
        
    }
    
    public void infoPartido()
    {
        
    }
    
    public void grupoClasificaciones()
    {
        
    }
    
    public void posicionesGenerales()
    {
        
    }
    
    public void goleadores()
    {
        
    }
    
    
    public void logicaVentanaPrincipal()
    {
            
        //Menu de control para las opciones deisponibles
        switch(option){
            case "EQUIPOS PARTICIPANTES POR CONFEDERACIÓN":  
                equiposCof();
                break;
            case "INFORME OFICIAL DEL PARTIDO":
                infoPartido();
                break;
            case "GRUPOS Y CLASIFICACIONES":
                grupoClasificaciones();
                break;                        
            case "TABLA GENERAL DE POSICIONES":
                posicionesGenerales();
                break;
            case "TABLA DE GOLEADORES":
                goleadores();
                break;
            default:
        }
        
        //Fin del menu controlador principal
    }
    
    //Fin de la clase ControladorPrincipal
}
