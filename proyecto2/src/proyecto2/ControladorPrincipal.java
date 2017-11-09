package proyecto2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorPrincipal 
{
    //Variables globales
    private String option;
    private int contadorPrincipal;//de 0 a 1
    private int contadorMundial; //limite 48
    private ArrayList<String> equiposMundial = new ArrayList<String>();
    private ResultSet output;            //Guarda el resultado del query
    private ResultSetMetaData metaDatos;
    private Statement statement;
    private Connection connection;
    
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
    private String grupo_clasificatoria;
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

    public ResultSet getOutput() {
        return output;
    }

    public String getGrupo_clasificatoria() {
        return grupo_clasificatoria;
    }

    public void setGrupo_clasificatoria(String grupo_clasificatoria) {
        this.grupo_clasificatoria = grupo_clasificatoria;
    }
    
    public void setOutput(ResultSet output) {
        this.output = output;
    }

    public ResultSetMetaData getMetaDatos() {
        return metaDatos;
    }

    public void setMetaDatos(ResultSetMetaData metaDatos) {
        this.metaDatos = metaDatos;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    

    public ArrayList<String> getEquiposMundial() {
        return equiposMundial;
    }

    public void setEquiposMundial(String equiposMundiall) {
        this.equiposMundial.add(equiposMundiall);
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
    
    public void query02()
    {

    }
    
    public void queryPartido() throws SQLException 
    {   
        int numero_partido=0;
        
        //Variables a usar en la funcion de partidos, total partidos 64
        String insercionHacer = "";
        
        //Verifico que este conectado a la BD
        connection = Conexion.getConexion();
        statement = connection.createStatement();  
        //Empiezo las inserciones de partidos
        insercionHacer+=numero_partido+", "+getGrupo_clasificatoria()+", "+getFecha_partido()+", "+getHora_partido()+", "+getCantidad_aficionados()+", "+primerTiempoRepMin+", "+segundoTiempoRepMin+", "+tiempo_extra+", "+getTieraron_penales();
        
        String insertPartido = "INSERT INTO PARTIDO (NUMERO_PARTIDO, ETAPA_CLASIFICATORIA, FECHA, HORA, CANTIDAD_AFICIONADOS, MIN_REPO_PRIMER_TIEMPO, MIN_REPO_SEGUNDO_TIEMPO, SEJUGOTIEMPOEXTRA, NOMBRE_ESTADIO, HUBOPENALES)\n" +
        "VALUES ("+insercionHacer+")";
        
        //Inserto partidos
        statement.executeUpdate(insertPartido);
        getConnection().commit();
        
        output = statement.executeQuery("SELECT * FROM PARTIDO");
        while(output.next())
        {
            System.out.println("numeroPartido: "+output.getString(1)+"\netapa_clasi: "+output.getString(2)+"\nfecha: "+output.getDate(3)+"\nhira: "+output.getDate(4)+"\ncant_afici: "+output.getDate(5)+"\nminRepoPrimer: "+output.getDate(6)+"\nsegRepoSegun: "+output.getDate(7)+"\nTextra: "+output.getDate(8)+"\npenales: "+output.getDate(9));
           
        }
        System.out.println("no entro...");
        
    }
    
    public void queryEquiposPorConfed(String codConfed) throws SQLException
    {
        String query;
        if(codConfed.equals("*"))
            query = "SELECT CONFEDERACIONESFUTBOL.CODIGO,EQUIPO.NOMBRE FROM EQUIPO JOIN CONFEDERACIONESFUTBOL ON CONFEDERACIONESFUTBOL.CODIGO = EQUIPO.CODIGO_CONF ORDER BY CONFEDERACIONESFUTBOL.CODIGO,EQUIPO.NOMBRE"; 
        else
            query = "SELECT CONFEDERACIONESFUTBOL.CODIGO,EQUIPO.NOMBRE FROM EQUIPO JOIN CONFEDERACIONESFUTBOL ON CONFEDERACIONESFUTBOL.CODIGO = EQUIPO.CODIGO_CONF WHERE CONFEDERACIONESFUTBOL.CODIGO = "+codConfed+" ORDER BY EQUIPO.NOMBRE";
        
        //Ejecuto el query
        output = statement.executeQuery(query);
        while(output.next())
        {
            System.out.println("Confederacion: "+output.getString(1)+"  Pais: "+output.getString(2));
        }
        System.out.println("no entro...");
    }
    
    
    public int cargarEquipos(String equipo2, String nombreEstadio, String fecha, String hora, String cantAficionados, String jugadoresSuplentes, String jugadoresTitulares, String minPrimerTR, String minSegundoTR, String grupoC) throws SQLException
    {
        if(getContadorP() == 1)
            {
            if(!(equipo2.isEmpty() || nombreEstadio.isEmpty() || fecha.isEmpty() || hora.isEmpty() || cantAficionados.isEmpty() || jugadoresSuplentes.isEmpty() || jugadoresTitulares.isEmpty() || minPrimerTR.isEmpty() || minSegundoTR.isEmpty()))
            {
                //--LOGIC SIGUIENTE EQUIPO
                //--Valido que este bien la informacion insertada
                //Equipo no debe estar en este string de equipos insertados
                for (int i = 0; i < equiposMundial.size(); i++) {
                    if(equiposMundial.get(i).equals(equipo2)){
                        JOptionPane.showMessageDialog(null, "El equipo seleccionado ya esta dentro del mundial\nIntentelo de nuevo");
                        return 1;
                    } else {
                        setEquipo_1(equipo2);
                    }
                }                
                //Valido formato fecha 
                String[] formatoFecha = fecha.split("/");
                for (String string : formatoFecha) {
                    if(isInteger(string)){
                        setFecha_partido(string);
                    }else{
                        JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n día/mes/año");
                        return 1;
                    }
                }
                //Valido formato hora, 00:00
                if(isInteger(hora)){
                    setHora_partido(hora);
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n Un # entre 0 a 9");
                    return 1;
                }
                //Valido que este dato sea un numero
                if(isInteger(cantAficionados)){
                    setCantidad_aficionados(cantAficionados);
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n Un # entre 0 a 1000 0 más");
                    return 1;
                }
                //Valido suplentes 12
                String[] jSuplentes = jugadoresSuplentes.split(", ");
                int contadorJugador = 0;
                for (String jSuplente : jSuplentes) {
                    contadorJugador++;
                }
                //Se puede jugar un partido con menos de 12 jugadores
                if(contadorJugador <= 12){
                    setJugadores_suplentes(jugadoresSuplentes);
                }
                
                //Valido titulares 11
                String[] jTitulares = jugadoresTitulares.split(", ");
                contadorJugador = 0;
                for (String jSuplente : jSuplentes) {
                    contadorJugador++;
                }
                //Partido de 11 jugadores
                if(contadorJugador == 11){
                    setJugadores_titulares(jugadoresTitulares);
                }
                
                //Validos primerTiempoRepo 
                setPrimerTiempoRepMin(minPrimerTR);
                
                //Valido segTiempoR  
                setSegundoTiempoRepMin(minSegundoTR);                

                //Se setea nadamas
                setNombre_estadio(nombreEstadio);
                
                JOptionPane.showMessageDialog(null, "Felicidades toda su información a insertar esta correcta.");

                //Hago QUERYS........... SQL
                //-->inserto informacion a la tablas 
                queryPartido();
                
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
        return 0;
    }
    
    public boolean isInteger(String cadena)
    {
        try{
            Integer.parseInt(cadena);
            return true;
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public int sigEquipo(String equipo1, String nombreEstadio, String fecha, String hora, String cantAficionados, String jugadoresSuplentes, String jugadoresTitulares, String minPrimerTR, String minSegundoTR, String grupoC) throws SQLException
    {
        if(getContadorP() == 0)
        {
            if(!(equipo1.isEmpty() || nombreEstadio.isEmpty() || fecha.isEmpty() || hora.isEmpty() || cantAficionados.isEmpty() || jugadoresSuplentes.isEmpty() || jugadoresTitulares.isEmpty() || minPrimerTR.isEmpty() || minSegundoTR.isEmpty()))
            {
                //--LOGIC SIGUIENTE EQUIPO
                //--Valido que este bien la informacion insertada
                //Equipo no debe estar en este string de equipos insertados
                if(equiposMundial.size() == 0)
                {
                    setEquipo_1(equipo1);
                }else{
                    for (int i = 0; i < equiposMundial.size(); i++) {
                        if(equiposMundial.get(i).equals(equipo1)){
                            JOptionPane.showMessageDialog(null, "El equipo seleccionado ya esta dentro del mundial\nIntentelo de nuevo");
                            return 1;
                        } else {
                            setEquipo_1(equipo1);
                        }
                    }   
                }
                             
                //Valido formato fecha 
                String[] formatoFecha = fecha.split("/");
                for (String string : formatoFecha) {
                    if(isInteger(string)){
                        setFecha_partido(string);
                    }else{
                        JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n día/mes/año");
                        return 1;
                    }
                }
                //Valido formato hora
                if(isInteger(hora)){
                    setHora_partido(hora);
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n Un # entre 0 a 9");
                    return 1;
                }
                //Valido que este dato sea un numero
                if(isInteger(cantAficionados)){
                    setCantidad_aficionados(cantAficionados);
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n Un # entre 0 a 1000 0 más");
                    return 1;
                }
                //Valido suplentes 12
                String[] jSuplentes = jugadoresSuplentes.split(", ");
                int contadorJugador = 0;
                for (String jSuplente : jSuplentes) {
                    contadorJugador++;
                }
                //Se puede jugar un partido con menos de 12 jugadores
                if(contadorJugador <= 12){
                    setJugadores_suplentes(jugadoresSuplentes);
                }
                
                //Valido titulares 11
                String[] jTitulares = jugadoresTitulares.split(", ");
                contadorJugador = 0;
                for (String jSuplente : jSuplentes) {
                    contadorJugador++;
                }
                //Partido de 11 jugadores
                if(contadorJugador == 11){
                    setJugadores_titulares(jugadoresTitulares);
                }
                
                //Validos primerTiempoRepo 
                setPrimerTiempoRepMin(minPrimerTR);
                
                //Valido segTiempoR  
                setSegundoTiempoRepMin(minSegundoTR);                

                //Se setea nadamas
                setNombre_estadio(nombreEstadio);
                
                JOptionPane.showMessageDialog(null, "Felicidades toda su información a insertar esta correcta.");

                //Hago QUERYS........... SQL
                //-->inserto informacion a la tablas 
                queryPartido();
                
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



 /*
            for (int i = 1; i <= output.getFetchSize(); i++) {
                System.out.println("entro al for");
                System.out.println(output.getString(i));
            }
            */