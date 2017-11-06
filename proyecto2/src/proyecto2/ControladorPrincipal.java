package proyecto2;

import javax.swing.JOptionPane;

public class ControladorPrincipal 
{
    //Variables globales
    private String option;
    private int contadorPrincipal;
    
    //Variables de PartidoCRUD
    private String equipo_1;
    private String equipo_2;
    private String jugadores_titulares;
    private String jugadores_suplentes;
    private String nombre_estadio;
    private String fecha_partido;
    private String hora_partido;
    private String cantidad_aficionados;
    private String primerTiempoRepMin;
    private String segundoTiempoRepMin;
    private String tiempo_extra;
    private String tieraron_penales;
    //Info: goles, t.amarillas, t.rojas
    private String tipo_accion;
    private String minGAR;
    private String segGAR;
    private String jugadorGAR;
    //Info;: cambios
    private String minCambio;
    private String segCambio;
    private String jugadorEntraCambio;
    private String jugadorSaleCambio;
    private String cambios_hechos;
    //Info: albitros
    private String arbitro_principal;
    private String arbitro_asistente_1;
    private String arbitro_asistente_2;
    private String arbitro_4to;
    private String arbitro_5to;
    
    //Variables de QUERYS
    
    
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
    
    public int getContadorP()
    {
        return this.contadorPrincipal;
    }
    
    public void aumentarContador()
    {
        this.contadorPrincipal++;
    }
    
    //Funciones
    
    public void cargarEquipos(String equipo2, String nombreEstadio, String fecha, String hora, String cantAficionados, String jugadoresSuplentes, String jugadoresTitulares, String minPrimerTR, String minSegundoTR)
    {
        if(getContadorP() == 1)
            {
            if(!(equipo2.isEmpty() || nombreEstadio.isEmpty() || fecha.isEmpty() || hora.isEmpty() || cantAficionados.isEmpty() || jugadoresSuplentes.isEmpty() || jugadoresTitulares.isEmpty() || minPrimerTR.isEmpty() || minSegundoTR.isEmpty()))
            {
                JOptionPane.showMessageDialog(null, "Felicidades toda su información esta correcta.");



            } else {
                JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ah eligio al EQUIPO 1 \nPorfavor hacer la escogencia... -.-");
        }
    }
    
    public void sigEquipo(String equipo1, String nombreEstadio, String fecha, String hora, String cantAficionados, String jugadoresSuplentes, String jugadoresTitulares, String minPrimerTR, String minSegundoTR)
    {
        if(getContadorP() == 0)
        {
            if(!(equipo1.isEmpty() || nombreEstadio.isEmpty() || fecha.isEmpty() || hora.isEmpty() || cantAficionados.isEmpty() || jugadoresSuplentes.isEmpty() || jugadoresTitulares.isEmpty() || minPrimerTR.isEmpty() || minSegundoTR.isEmpty()))
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


                //Siguiente: equipo2 a seguir escogiendo info....
                aumentarContador();
            } else {

                JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya se eligio al EQUIPO 1 \nPorfavor darle al boton EjecutarCRUD... -.-");
        }
        
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
