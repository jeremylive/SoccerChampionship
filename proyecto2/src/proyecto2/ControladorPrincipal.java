package proyecto2;

import javax.swing.JOptionPane;

public class ControladorPrincipal 
{
    //Variables globales
    private String option;
    private int contadorPrincipal;//de 0 a 1
    private int contadorMundial; //limite 48
    
    
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
    
    
    public void aumentarContador()
    {
        this.contadorPrincipal++;
    }
    
    public void restaurarContadorP()
    {
        this.contadorPrincipal = 0;
    }

    public int getContadorP() {
        return contadorPrincipal;
    }

    public int getContadorMundial() {
        return contadorMundial;
    }

    public void upContadorMundial() {
        this.contadorMundial++;
    }

    public void setContadorPrincipal(int contadorPrincipal) {
        this.contadorPrincipal = contadorPrincipal;
    }

    public String getEquipo_1() {
        return equipo_1;
    }

    public void setEquipo_1(String equipo_1) {
        this.equipo_1 = equipo_1;
    }

    public String getEquipo_2() {
        return equipo_2;
    }

    public void setEquipo_2(String equipo_2) {
        this.equipo_2 = equipo_2;
    }

    public String getJugadores_titulares() {
        return jugadores_titulares;
    }

    public void setJugadores_titulares(String jugadores_titulares) {
        this.jugadores_titulares = jugadores_titulares;
    }

    public String getJugadores_suplentes() {
        return jugadores_suplentes;
    }

    public void setJugadores_suplentes(String jugadores_suplentes) {
        this.jugadores_suplentes = jugadores_suplentes;
    }

    public String getNombre_estadio() {
        return nombre_estadio;
    }

    public void setNombre_estadio(String nombre_estadio) {
        this.nombre_estadio = nombre_estadio;
    }

    public String getFecha_partido() {
        return fecha_partido;
    }

    public void setFecha_partido(String fecha_partido) {
        this.fecha_partido = fecha_partido;
    }

    public String getHora_partido() {
        return hora_partido;
    }

    public void setHora_partido(String hora_partido) {
        this.hora_partido = hora_partido;
    }

    public String getCantidad_aficionados() {
        return cantidad_aficionados;
    }

    public void setCantidad_aficionados(String cantidad_aficionados) {
        this.cantidad_aficionados = cantidad_aficionados;
    }

    public String getPrimerTiempoRepMin() {
        return primerTiempoRepMin;
    }

    public void setPrimerTiempoRepMin(String primerTiempoRepMin) {
        this.primerTiempoRepMin = primerTiempoRepMin;
    }

    public String getSegundoTiempoRepMin() {
        return segundoTiempoRepMin;
    }

    public void setSegundoTiempoRepMin(String segundoTiempoRepMin) {
        this.segundoTiempoRepMin = segundoTiempoRepMin;
    }

    public String getTiempo_extra() {
        return tiempo_extra;
    }

    public void setTiempo_extra(String tiempo_extra) {
        this.tiempo_extra = tiempo_extra;
    }

    public String getTieraron_penales() {
        return tieraron_penales;
    }

    public void setTieraron_penales(String tieraron_penales) {
        this.tieraron_penales = tieraron_penales;
    }

    public String getTipo_accion() {
        return tipo_accion;
    }

    public void setTipo_accion(String tipo_accion) {
        this.tipo_accion = tipo_accion;
    }

    public String getMinGAR() {
        return minGAR;
    }

    public void setMinGAR(String minGAR) {
        this.minGAR = minGAR;
    }

    public String getSegGAR() {
        return segGAR;
    }

    public void setSegGAR(String segGAR) {
        this.segGAR = segGAR;
    }

    public String getJugadorGAR() {
        return jugadorGAR;
    }

    public void setJugadorGAR(String jugadorGAR) {
        this.jugadorGAR = jugadorGAR;
    }

    public String getMinCambio() {
        return minCambio;
    }

    public void setMinCambio(String minCambio) {
        this.minCambio = minCambio;
    }

    public String getSegCambio() {
        return segCambio;
    }

    public void setSegCambio(String segCambio) {
        this.segCambio = segCambio;
    }

    public String getJugadorEntraCambio() {
        return jugadorEntraCambio;
    }

    public void setJugadorEntraCambio(String jugadorEntraCambio) {
        this.jugadorEntraCambio = jugadorEntraCambio;
    }

    public String getJugadorSaleCambio() {
        return jugadorSaleCambio;
    }

    public void setJugadorSaleCambio(String jugadorSaleCambio) {
        this.jugadorSaleCambio = jugadorSaleCambio;
    }

    public String getCambios_hechos() {
        return cambios_hechos;
    }

    public void setCambios_hechos(String cambios_hechos) {
        this.cambios_hechos = cambios_hechos;
    }

    public String getArbitro_principal() {
        return arbitro_principal;
    }

    public void setArbitro_principal(String arbitro_principal) {
        this.arbitro_principal = arbitro_principal;
    }

    public String getArbitro_asistente_1() {
        return arbitro_asistente_1;
    }

    public void setArbitro_asistente_1(String arbitro_asistente_1) {
        this.arbitro_asistente_1 = arbitro_asistente_1;
    }

    public String getArbitro_asistente_2() {
        return arbitro_asistente_2;
    }

    public void setArbitro_asistente_2(String arbitro_asistente_2) {
        this.arbitro_asistente_2 = arbitro_asistente_2;
    }

    public String getArbitro_4to() {
        return arbitro_4to;
    }

    public void setArbitro_4to(String arbitro_4to) {
        this.arbitro_4to = arbitro_4to;
    }

    public String getArbitro_5to() {
        return arbitro_5to;
    }

    public void setArbitro_5to(String arbitro_5to) {
        this.arbitro_5to = arbitro_5to;
    }
    
    
    
    
    //Funciones
    
    public void cargarEquipos(String equipo2, String nombreEstadio, String fecha, String hora, String cantAficionados, String jugadoresSuplentes, String jugadoresTitulares, String minPrimerTR, String minSegundoTR)
    {
        if(getContadorP() == 1)
            {
            if(!(equipo2.isEmpty() || nombreEstadio.isEmpty() || fecha.isEmpty() || hora.isEmpty() || cantAficionados.isEmpty() || jugadoresSuplentes.isEmpty() || jugadoresTitulares.isEmpty() || minPrimerTR.isEmpty() || minSegundoTR.isEmpty()))
            {
                //Valido que este bien la info
 
                
                //Aumento el contador que lleva los partidos max 48
                upContadorMundial();
                //Valido si ya llego a 48
                if(getContadorMundial() == 48){
                    JOptionPane.showMessageDialog(null, "FELICIDADES, INSERTASTE 48 PARTIDOS");
                }
                
                //restauro contador que lleva el orden de un partido 1 y 2 (0 y 1)
                restaurarContadorP();
                
                JOptionPane.showMessageDialog(null, "Felicidades toda su información esta correcta.\nAcabas de insertar el partido numero : "+getContadorMundial());
                
            } else {
                JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ah eligio al EQUIPO 1 \nPorfavor hacer la escogencia... -.-");
        }
    }
    
    public int sigEquipo(String equipo1, String nombreEstadio, String fecha, String hora, String cantAficionados, String jugadoresSuplentes, String jugadoresTitulares, String minPrimerTR, String minSegundoTR)
    {
        if(getContadorP() == 0)
        {
            if(!(equipo1.isEmpty() || nombreEstadio.isEmpty() || fecha.isEmpty() || hora.isEmpty() || cantAficionados.isEmpty() || jugadoresSuplentes.isEmpty() || jugadoresTitulares.isEmpty() || minPrimerTR.isEmpty() || minSegundoTR.isEmpty()))
            {
                String[] equiposMundial = {};
                
                
                //--LOGIC SIGUIENTE EQUIPO
                //--Valido que este bien la informacion insertada
                //Equipo no debe estar en este string de equipos insertados
                for (int i = 0; i < equiposMundial.length; i++) {
                    if(equiposMundial[i].equals(equipo1)){
                        JOptionPane.showMessageDialog(null, "El equipo seleccionado ya esta dentro del mundial\nIntentelo de nuevo");
                        return 1;
                    } else {
                        setEquipo_1(equipo1);
                    }
                }                
                //Valido formato fecha y hora
                String[] formatoFecha = fecha.split("/");
                for (String string : formatoFecha) {
                    try{
                        int num = Integer.parseInt(string);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n día/mes/año");
                        return 1;
                    }
                }
                setFecha_partido(fecha);
                try{
                    int num = Integer.parseInt(hora);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n día/mes/año");
                    return 1;
                }
                setHora_partido(hora);
                //Valido que este dato sea un numero
                setCantidad_aficionados(cantAficionados);
                
                setJugadores_suplentes(jugadoresSuplentes);
                setJugadores_titulares(jugadoresTitulares);
                
                setPrimerTiempoRepMin(minPrimerTR);
                setSegundoTiempoRepMin(minSegundoTR);                


                setNombre_estadio(nombreEstadio);
                
                JOptionPane.showMessageDialog(null, "Felicidades toda su información esta correcta.");

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
        return 0;
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
