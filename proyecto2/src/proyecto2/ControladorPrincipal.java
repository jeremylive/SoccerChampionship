package proyecto2;

import javax.swing.JOptionPane;

public class ControladorPrincipal 
{
    //Variables globales
    private String option;
    private int contadorPrincipal;

    
    //Constructor
    public ControladorPrincipal()
    {
        this.option = "";
        this.contadorPrincipal = 0;
    }
        
    //Gets and Sets
    public void setOption(String opcion)
    {
        this.option = opcion;
    }
    
    public String getOption()
    {
        return this.option;
    }
    
    public void aumentarContador()
    {
        this.contadorPrincipal++;
    }
    
    //Funciones
    
    public void sigEquipo(String nombreEstadio, String fecha, String hora, String cantAficionados, String jugadoresSuplentes, String jugadoresTitulares)
    {
        
        if(!(nombreEstadio=="" || fecha=="" || hora=="" || cantAficionados=="" || jugadoresSuplentes=="" || jugadoresTitulares==""))
        {
            JOptionPane.showMessageDialog(null, "Felicidades toda su información esta correcta.");
        
            //LOGIC SIGUIENTE EQUIPO
            
            //Agarro toda la informacion 
            
            //Valido que este bien la informacion insertada
            
            //Coloco el equipo1 donde corresponde
            
            //Coloco valores de variables
            
            //Hago QUERYS........... SQL
            
            //-->inserto informacion a la tablas 
            //--tabla jugadores titulares
            
            //--tabla jugadores suplentes
            
            //--....
            
            //....
            
            //..
            
            //Borro los campor en la interfaz 
        
        
        } else {

            JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");
        }
        
        
        //Siguiente: equipo2 a seguir escogiendo info....
        aumentarContador();
    }
    
    //##----------------------
    
    public void equiposCof()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: EQUIPOS PARTICIPANTES POR CONFEDERACIÓN");
        
        //LOGIC
        //##--
        
        //Total de confederaciones
        
        //Dividir en grupos por confederaciones
        
        //Recorrer los grupos eh imprimir sus equipos
        
        //Fin de la operación...    
    }
    
    public void infoPartido()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: INFORME OFICIAL DEL PARTIDO");
    }
    
    public void grupoClasificaciones()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: GRUPOS Y CLASIFICACIONES");
                
    }
    
    public void posicionesGenerales()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: TABLA GENERAL DE POSICIONES");
    }
    
    public void goleadores()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: TABLA DE GOLEADORES");
    }
    
    
    public void logicaVentanaPrincipal(String operacion)
    {
        //Seteo la option a la variable global
        setOption(operacion);
        //Menu de control para las opciones deisponibles
        switch(getOption()){
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
