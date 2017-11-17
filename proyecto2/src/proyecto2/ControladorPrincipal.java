package proyecto2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    private int numero_partido=0;
    private DefaultTableModel tabla;
    private int quienGanoPartido;
    private String codigoEquipo;
    
    //Variables de PartidoCRUD
    private String equipo_1;
    private String equipo_2;
    private String jugadores_titulares;
    private String jugadores_suplentes;
    private String nombre_estadio;
    private String ano_partido;
    private String mes_partido;
    private String dia_partido;
    private String hora_partido;
    private String minutos_partido;
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

    public String getAno_partido() {
        return ano_partido;
    }

    public void setAno_partido(String anoo_partido) {
        this.ano_partido = anoo_partido;
    }

    public String getMes_partido() {
        return mes_partido;
    }

    public void setMes_partido(String mess_partido) {
        this.mes_partido = mess_partido;
    }
    
    public String getDia_partido() {
        return dia_partido;
    }

    public void setDia_partido(String diaa_partido) {
        this.dia_partido = diaa_partido;
    }
 
    public String getHora_partido() {
        return hora_partido;
    }

    public void setHora_partido(String hora_partido) {
        this.hora_partido = hora_partido;
    }

    public String getMin_partido() {
        return minutos_partido;
    }

    public void setMin_partido(String hora_partido) {
        this.minutos_partido = minutos_partido;
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

    public int getNumero_partido() {
        return numero_partido;
    }

    public void setNumero_partido(int numero_partido) {
        this.numero_partido = numero_partido;
    }

    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }
    
    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    
    
    
    /**
     * Funciones
     */
    
    //Crea un nuevo equipo en la tabla Equipo
    public void crearEquipo(String codEquipo, String nombrePais,String grupoInicial, String codigoConfederacion) throws SQLException
    {
        //Da formato a los strings
        String SQLcodEquipo = "'" + codEquipo + "'";
        String SQLnombrePais = "'" + nombrePais + "'";
        String SQLgrupoInicial = "'" + grupoInicial + "'";
        String SQLcodConfed = "'" + codigoConfederacion + "'";
        
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();
        
        //Realiza el query
        String queryInsert = "INSERT INTO EQUIPO(CODIGO_EQUIPO,NOMBRE,GRUPO_INICIO,CODIGO_CONF) VALUES "
                + "("+SQLcodEquipo+","+SQLnombrePais+","+SQLgrupoInicial+","+SQLcodConfed+")";
        statement.executeUpdate(queryInsert);
        getConnection().commit();
    }
    
    //Crea una copia del entrenador con el pasaporteReal y  le asigna el nuevo codEquipo
    public void crearEntrenadorEquipo(String paisNac,String fechaIni,String codEquipo,int pasaporteReal) throws SQLException
    {   
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();
        
        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = "+pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();
        
        ArrayList<String> datosPersona = new ArrayList();
        while(output.next())
        {
            for(int i = 1;i<=index;i++)
            {
                datosPersona.add(output.getString(i));
            }
        }
        
        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while(output.next())
        {
            pasaporteNuevo = output.getInt(1) +1;
        }
        
        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "("+pasaporteNuevo+",'"+datosPersona.get(0)+"','"+datosPersona.get(1)+"','"
                + datosPersona.get(2)+"',TO_TIMESTAMP('"+datosPersona.get(3)+"','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();
        
        //Inserto una nueva tupla en Entrenador
        insertar = "INSERT INTO ENTRENADOR(NUMERO_PASAPORTE,PAIS_NACIONALIDAD,FECHA_INICIO,CODIGO_EQUIPO) VALUES "
                + "("+pasaporteNuevo+","+paisNac+",TO_TIMESTAMP("+fechaIni+",'YYYY-MM-DD HH24:MI:SS.FF9'),"
                + codEquipo+")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
    
    //INSERTO EN LA TABLA PERSONA Y JUGADOR
    public void crearJugadorEquipo(int pasaporteReal,String puesto,int numCamiseta,String codEquipo,String esCapt) throws SQLException{
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();
        
        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = "+pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();
        
        ArrayList<String> datosPersona = new ArrayList();
        while(output.next())
        {
            for(int i = 1;i<=index;i++)
            {
                datosPersona.add(output.getString(i));
            }
        }
        
        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while(output.next())
        {
            pasaporteNuevo = output.getInt(1) +1;
        }
        
        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "("+pasaporteNuevo+",'"+datosPersona.get(0)+"','"+datosPersona.get(1)+"','"
                + datosPersona.get(2)+"',TO_TIMESTAMP('"+datosPersona.get(3)+"','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();
        
        //Inserto una nueva tupla en Jugador
        insertar = "INSERT INTO JUGADOR(NUMERO_PASAPORTE,PUESTO,NUMERO_CAMISETA,CODIGO_EQUIPO,ES_CAPITAN) VALUES "
                + "("+pasaporteNuevo+","+puesto+","+numCamiseta+","+codEquipo+","+esCapt+")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
    
    //INSERTO EN LA TABLA PERSONA Y ASISTENTE
    public void crearAsistenteEquipo(int pasaporteReal,String paisNac,String fechaIni,String tipoAsist,String codEquipo) throws SQLException{
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();
        
        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = "+pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();
        
        ArrayList<String> datosPersona = new ArrayList();
        while(output.next())
        {
            for(int i = 1;i<=index;i++)
            {
                datosPersona.add(output.getString(i));
            }
        }
        
        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while(output.next())
        {
            pasaporteNuevo = output.getInt(1) +1;
        }
        
        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "("+pasaporteNuevo+",'"+datosPersona.get(0)+"','"+datosPersona.get(1)+"','"
                + datosPersona.get(2)+"',TO_TIMESTAMP('"+datosPersona.get(3)+"','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();
        
        //Inserto una nueva tupla en Asistente
        insertar = "INSERT INTO ASISTENTE(NUMERO_PASAPORTE,PAIS_NACIONALIDAD,FECHA_INICIO,TIPO,CODIGO_EQUIPO) VALUES "
                + "("+pasaporteNuevo+","+paisNac+",TO_TIMESTAMP("+fechaIni+",'YYYY-MM-DD HH24:MI:SS.FF9'),"
                + tipoAsist + "," + codEquipo+")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
    
    //INSERTO EN LA TABLA DE PERSONA Y FEDERATIVOS
    public void crearFederativoEquipo(int pasaporteReal,String paisNac,String fechaIni,String puesto,String codEquipo) throws SQLException{
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();
        
        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = "+pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();
        
        ArrayList<String> datosPersona = new ArrayList();
        while(output.next())
        {
            for(int i = 1;i<=index;i++)
            {
                datosPersona.add(output.getString(i));
            }
        }
        
        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while(output.next())
        {
            pasaporteNuevo = output.getInt(1) +1;
        }
        
        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "("+pasaporteNuevo+",'"+datosPersona.get(0)+"','"+datosPersona.get(1)+"','"
                + datosPersona.get(2)+"',TO_TIMESTAMP('"+datosPersona.get(3)+"','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();
        
        //Inserto una nueva tupla en Federativo
        insertar = "INSERT INTO FEDERATIVO(NUMERO_PASAPORTE,PAIS_NACIONALIDAD,FECHA_INICIO,PUESTO,CODIGO_EQUIPO) VALUES "
                + "("+pasaporteNuevo+","+paisNac+",TO_TIMESTAMP("+fechaIni+",'YYYY-MM-DD HH24:MI:SS.FF9'),"
                + puesto + "," + codEquipo+")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
        
    //Operacion equipos por confederacion
    public void queryEquiposPorConfed(String codConfed)
    {
        try {
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();
            
            //Crea el query
            String query = "SELECT CONFEDERACIONESFUTBOL.CODIGO,EQUIPO.NOMBRE FROM EQUIPO JOIN CONFEDERACIONESFUTBOL ON CONFEDERACIONESFUTBOL.CODIGO = EQUIPO.CODIGO_CONF ";
                //Si se especifica un equipo
            if(!codConfed.equals(""))
                query += "WHERE CONFEDERACIONESFUTBOL.CODIGO = '"+codConfed+"' ";
            query+="ORDER BY CONFEDERACIONESFUTBOL.CODIGO,EQUIPO.NOMBRE";
            
            //Ejecuto el query
            output = statement.executeQuery(query);
            
            //Obtengo los metadatos y nombres de columnas
            metaDatos = output.getMetaData();
            int index = metaDatos.getColumnCount();
            Vector nombreColumnas = new Vector();
            for (int i = 1; i <= index; i++) {
                nombreColumnas.add(metaDatos.getColumnLabel(i));
            }

            String confederacionActual = ""; //Usado para imprimir en pantalla
            
            //Obtengo las tuplas en un vector que contiene vectores
            Vector filas = new Vector();
            while(output.next())
            {
                //Imprime en pantalla
                if(confederacionActual.equals("")||!confederacionActual.equals(output.getString(1))) {
                    System.out.println(output.getString(1));
                    confederacionActual = output.getString(1);
                }
                System.out.println("    "+output.getString(2));
                //Añado al vector de datos
                Vector tupla = new Vector();
                for (int i = 1; i <= index; i++) {
                    tupla.add(output.getString(i));
                }
                filas.add(tupla);
            }
            
            //Muestro los resultados
            DefaultTableModel modelo = this.getTabla();
            modelo.setDataVector(filas,nombreColumnas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta");
        }
    }
    
    //OPERACION TABLA GOLEADORES
    public void queryGoleadores()
    {
        try {
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();
            
            //Ejecuto el query
            String query = "SELECT NOMBRE,APELLIDO1,APELLIDO2,JUGADOR.CODIGO_EQUIPO,count(NUMERO_PARTIDO) GOLES FROM PARTIDO_GOLES "
                    + "JOIN JUGADOR ON PARTIDO_GOLES.NUMERO_PASAPORTE = JUGADOR.NUMERO_PASAPORTE "
                    + "JOIN PERSONA ON JUGADOR.NUMERO_PASAPORTE = PERSONA.NUM_PASAPORTE "
                    + "GROUP BY NOMBRE,APELLIDO1,APELLIDO2,JUGADOR.CODIGO_EQUIPO "
                    + "ORDER BY count(NUMERO_PARTIDO) DESC,NOMBRE,APELLIDO1,APELLIDO2";
            output = statement.executeQuery(query);
            
            //Obtengo los metadatos y nombres de columnas
            metaDatos = output.getMetaData();
            int index = metaDatos.getColumnCount();
            
            Vector nombreColumnas = new Vector();
            nombreColumnas.add("POSICION");
            for (int i = 1; i <= index; i++) {
                nombreColumnas.add(metaDatos.getColumnLabel(i));
            }
            
            //Obtengo las tuplas en un vector que contiene vectores
            int posicion = 1;
            Vector filas = new Vector();
            while(output.next())
            {
                //Imprime en pantalla
                System.out.println("Posicion:"+posicion+"   Nombre:"+output.getString(1)+"   Apellido1:"+output.getString(2)+"   Apellido2:"+output.getString(3)+"   Equipo:"+output.getString(4)+"   Goles:"+output.getString(5));
                //Añado al vector de datos
                Vector tupla = new Vector();
                tupla.add(posicion);
                for (int i = 1; i <= index; i++) {
                    tupla.add(output.getString(i));
                }
                filas.add(tupla);
                posicion++;
            }
            
            //Muestro los resultados
            DefaultTableModel modelo = this.getTabla();
            modelo.setDataVector(filas,nombreColumnas);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta");
        }
    }
    
    //INSERTO EN LA TABLA CUERPO_ARBITRAL USANDO UNA TRANSACCION
    public void ejecutarArbitro() throws SQLException
    {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();  
        
        //se deshabilita el modo de confirmación automática
        connection.setAutoCommit(false);
        
        //INSERTS A CUERPO_ARBITRAL
        String insertCUERPO_Principal = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_principal()+",'Principal')";
        String insertCUERPO_Asist1 = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_asistente_1()+",'Asistente')";
        String insertCUERPO_Asist2 = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_asistente_2()+",'Asistente')";
        String insertCUERPO_4to = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_4to()+",'Cuarto')";
        String insertCUERPO_5to = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_5to()+",'Quinto')";
        
        statement.executeUpdate(insertCUERPO_Principal);
        statement.executeUpdate(insertCUERPO_Asist1);
        statement.executeUpdate(insertCUERPO_Asist2);
        statement.executeUpdate(insertCUERPO_4to);
        statement.executeUpdate(insertCUERPO_5to);
        
        getConnection().commit();
        
        connection.setAutoCommit(true);
        
    }

    //INSERTO EN LA TABLA CAMBIOS
    public int ejecutarCambios(String jSale, String jEntra, String min, String seg, String codEquipo) throws SQLException
    {
        //Valido info
        if(!(jSale.isEmpty() || jEntra.isEmpty() || min.isEmpty() || seg.isEmpty() || codEquipo.isEmpty()))
        {
            //Inserto datos a java
            if(!(jSale.equals(jEntra))){
                setJugadorEntraCambio(jEntra);
                setJugadorSaleCambio(jSale);
            }else{
                return 1;
            }
            
            if(isInteger(min)){
                setMinCambio(min);
            }else{
                return 1;
            }
            
            if(isInteger(seg)){
                setSegCambio(seg);
            }else{
                return 1;
            }
            
            setCodigoEquipo(codEquipo);
                  
            //INSERTS A PARTIDO_CAMBIOS 
            String cambios = "INSERT INTO CAMBIOS VALUES ("+getNumero_partido()+","+getJugadorSaleCambio()+","+getJugadorEntraCambio()+","+getMinCambio()+","+getSegCambio()+",'"+getCodigoEquipo()+"')";
                   
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();  
            statement.executeUpdate(cambios);
            getConnection().commit();   
        } else {
            JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");
        }
        return 0;
    }
    
    //INSERTO EN LA TABLA PARTIDO_PARTICIPA Y EN PARTIDO
    public void queryPartido() throws SQLException 
    {   
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();  
        
        //se deshabilita el modo de confirmación automática
        connection.setAutoCommit(false);
        
        //Variables a usar en la funcion de partidos, total partidos 64
        String insercionHacer = "";
        insercionHacer += getNumero_partido()+", '"+getGrupo_clasificatoria()+"', "+"TO_TIMESTAMP('"+getAno_partido()+"-"+getMes_partido()+"-"+getDia_partido()+"','YYYY-MM-DD HH24:MI:SS.FF9'), "+
            "TO_DATE('"+getHora_partido()+"', 'hh24:mi')"+", "+getCantidad_aficionados()+", "+getPrimerTiempoRepMin()+", "+
            getSegundoTiempoRepMin()+", '"+getTiempo_extra()+"', '"+getNombre_estadio()+"', '"+getTieraron_penales()+"'";

        //Inserts a PARTICIPA
        String insertPARTICIPA_Equipo1 = "INSERT INTO PARTIDO_PARTICIPA VALUES ("+getNumero_partido()+","+getEquipo_1()+","+"1)";
        String insertPARTICIPA_Equipo2 = "INSERT INTO PARTIDO_PARTICIPA VALUES ("+getNumero_partido()+","+getEquipo_2()+","+"2)";
        //Inserts a PARTIDO
        String insertPartido = "INSERT INTO PARTIDO (NUMERO_PARTIDO, ETAPA_CLASIFICATORIA, FECHA, HORA, CANTIDAD_AFICIONADOS,"+
                "MIN_REPO_PRIMER_TIEMPO, MIN_REPO_SEGUNDO_TIEMPO, SEJUGOTIEMPOEXTRA, NOMBRE_ESTADIO, HUBOPENALES) VALUES ("+insercionHacer+")";
        System.out.println(insertPartido);
        
        statement.executeUpdate(insertPartido);
        statement.executeUpdate(insertPARTICIPA_Equipo1);
        statement.executeUpdate(insertPARTICIPA_Equipo2);

        getConnection().commit();   
        connection.setAutoCommit(true);
    }

    //Contadores
    int contTitulares1, contTitulares2, contSuplentes1, contSuplentes2;
    
    //Inserto titulares EQUIPO_1, titulares EQUIPO_2
    public int titulares1(String jugadorTitular, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorTitular.isEmpty() || codEquipo.isEmpty())){
            setJugadores_titulares(jugadorTitular);
            setCodigoEquipo(codEquipo);
        }
       
        if(contTitulares1 <= 12){
            
            String insertTitulares = "INSERT INTO PARTIDO_TITULARES VALUES ("+getNumero_partido()+","+getJugadores_titulares()+",'"+getCodigoEquipo()+"')";
            
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();  
            statement.executeUpdate(insertTitulares);
            getConnection().commit();          
        
        }else{
            return 1;
        }
        
        //Aumento el contador de titulares
        contTitulares1++;
        
        return 0;
    }
    
    public int titulares2(String jugadorTitular, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorTitular.isEmpty() || codEquipo.isEmpty())){
            setJugadores_titulares(jugadorTitular);
            setCodigoEquipo(codEquipo);
        }
       
        if(contTitulares2 <= 12){
            
            String insertTitulares2 = "INSERT INTO PARTIDO_TITULARES VALUES ("+getNumero_partido()+","+getJugadores_titulares()+",'"+getCodigoEquipo()+"')";
            
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();  
            statement.executeUpdate(insertTitulares2);
            getConnection().commit();          
        
        }else{
            return 1;
        }
        
        //Aumento el contador de titulares
        contTitulares2++;
        
        return 0;
    }
    
    //Inserto Suplentes EQUIPO_1, Suplentes EQUIPO_2
    public int suplentes1(String jugadorSuplente, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorSuplente.isEmpty() || codEquipo.isEmpty())){
            setJugadores_suplentes(jugadorSuplente);
            setCodigoEquipo(codEquipo);
        }
       
        if(contSuplentes2 <= 11){
            
            String insertSuplentes1 = "INSERT INTO PARTIDO_SUPLENTES VALUES ("+getNumero_partido()+","+getJugadores_titulares()+",'"+getCodigoEquipo()+"')";
            
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();  
            statement.executeUpdate(insertSuplentes1);
            getConnection().commit();          
        
        }else{
            return 1;
        }
        
        //Aumento el contador de titulares
        contSuplentes1++;
        
        return 0;
    }
    
    public int suplentes2(String jugadorSuplente, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorSuplente.isEmpty() || codEquipo.isEmpty())){
            setJugadores_suplentes(jugadorSuplente);
            setCodigoEquipo(codEquipo);
        }
       
        if(contSuplentes2 <= 11){
            
            String insertSuplentes2 = "INSERT INTO PARTIDO_SUPLENTES VALUES ("+getNumero_partido()+","+getJugadores_titulares()+",'"+getCodigoEquipo()+"')";
            
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();  
            statement.executeUpdate(insertSuplentes2);
            getConnection().commit();          
        
        }else{
            return 1;
        }       
        //Aumento el contador de titulares
        contSuplentes2++;
        
        return 0;
    }
    
    //Inserto goles, t.amarillas y t.rojas
    public int ejecutarGAR(String option, String min, String seg, String jugador, String codEquipo) throws SQLException
    {
        //Valido informacion
        if(!(min.isEmpty() || seg.isEmpty() || jugador.isEmpty() || codEquipo.isEmpty())){
            setMinGAR(min);
            setSegGAR(seg);
            setJugadorGAR(jugador);
            setCodigoEquipo(codEquipo);
        }else{
            return 1;
        }
        
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();  
                
        //En base a la opcion digitada
        switch (option){
            case "Gol":
                String insertGol = "INSERT INTO GOLES VALUES ("+getNumero_partido()+
                    ","+getMinGAR()+","+getSegGAR()+","+getJugadorGAR()+",'"+getCodigoEquipo()+"')";
                statement.executeUpdate(insertGol);
                getConnection().commit();  
                break;
                
            case "TarjetaAmarilla":
                String insertTarjetaAmarilla = "INSERT INTO TARJETASAMARILLAS VALUES ("+getNumero_partido()+
                    ","+getMinGAR()+","+getSegGAR()+","+getJugadorGAR()+")";
                statement.executeUpdate(insertTarjetaAmarilla);
                getConnection().commit();  
                break;
                
            case "TarjetaRoja":
                String insertarTarjetaRoja = "INSERT INTO TARJETASROJAS VALUES ("+getNumero_partido()+
                    ","+getMinGAR()+","+getSegGAR()+","+getJugadorGAR()+")";
                statement.executeUpdate(insertarTarjetaRoja);
                getConnection().commit();  
                break;
        }
        return 0;
    }
    
    
    //Interfaz penales
    public void queryPenales()
    {
        if(getTieraron_penales().equals("YES")){
            crudPartidosPenales crudPenales = new crudPartidosPenales(this);
            crudPenales.setLocationRelativeTo(null);
            crudPenales.setVisible(true);
            
            JOptionPane.showMessageDialog(null, "Penales", "Se van a tirar penales", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Penales", "No se van a tiraron penales", 3);
        }
    }
    
    
    //Valida que el parametro es int
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
    
    public void cargarEquipo1(){
        
    }
    
    
   
    /**
     * Funcion Inserto partido
     * @return 1 si algo sale mal o 0 si todo bien
     * @throws SQLException 
     */
    public int cargarEquipos(String equipo1, String equipo2, String nombreEstadio, String cantAficionados, String tiempoExtra, 
            String tiraronPenales, String grupoC, String minPrimerTR, String minSegundoTR, String hora, String minutos, String año, String mes, String dia) 
            throws SQLException
    {
        //Valido que esten con info los datos necesarios
        if(!(equipo2.isEmpty() || nombreEstadio.isEmpty() || cantAficionados.isEmpty() || minPrimerTR.isEmpty() || minSegundoTR.isEmpty() || equipo1.isEmpty()
                || hora.isEmpty() || minutos.isEmpty() || año.isEmpty() || mes.isEmpty() || dia.isEmpty()))
        {
            //Valido que los equipos no sean iguales
            if(!equipo1.equals(equipo2))
            {
                setEquipo_1(equipo1);
                setEquipo_2(equipo2);
            } else{
                return 1;
            }
            //Valido que este dato sea un numero
            if(isInteger(cantAficionados)){
                setCantidad_aficionados(cantAficionados);
            }else{
                JOptionPane.showMessageDialog(null, "La fecha esta con un formato erroneo \nDigitela con este formato:\n Un # entre 0 a 1000 0 más");
                return 1;
            }

            setGrupo_clasificatoria(grupoC);
            setPrimerTiempoRepMin(minPrimerTR);
            setSegundoTiempoRepMin(minSegundoTR);                
            setNombre_estadio(nombreEstadio);
            setTiempo_extra(tiempoExtra);
            setTieraron_penales(tiraronPenales);
            setHora_partido(hora);
            setMin_partido(minutos);
            setAno_partido(año);
            setMes_partido(mes);
            setDia_partido(dia);

            String numeroPartido = ""+interfazPartidos.numero_partido;
            int newNumero = Integer.parseInt(numeroPartido) + 1;
            interfazPartidos.numero_partido.setText(""+newNumero);

            JOptionPane.showMessageDialog(null, "Felicidades toda su información a insertar esta correcta.");

            //Hago QUERYS........... SQL
            //-->inserto informacion a la tablas 
            queryPartido();

            //restauro contador que lleva el orden de un partido 1 y 2 (0 y 1)
            restaurarContadorP();
            //Aumento el contador que lleva los partidos max 48
            upContadorMundial();
            //Valido si ya llego a 64
            if(getContadorMundial() <= 64){
                JOptionPane.showMessageDialog(null, "FELICIDADES, INSERTASTE 64 PARTIDOS");
            }
            JOptionPane.showMessageDialog(null, "Felicidades toda su información esta correcta.\nAcabas de insertar el partido numero : "+getContadorMundial());
        } else {
            JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");

        }
        return 0;
    }
    
    
    //Operacion grupo y clasificatoria
    public void queryClasificaria()
    {

        
    }
    
    
    //Operacion posiciones de equipo
    public void queryPosiciones()
    {
        
    }
    
    
    
    //--------------Equipos por Confederacion------------------------
    public void equiposCof(String parametro) throws SQLException
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: EQUIPOS PARTICIPANTES POR CONFEDERACIÓN");
        queryEquiposPorConfed(parametro);
    }
    
    //----------------------Informacion del partido---------------------------
    public void infoPartido()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: INFORME OFICIAL DEL PARTIDO");
    }
    
    //----------------------
    public void grupoClasificaciones()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: GRUPOS Y CLASIFICACIONES");
                
    }
    
    //-----------------------TablaPosicionesGenerales------------------------
    public void posicionesGenerales()
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: TABLA GENERAL DE POSICIONES");
    }
    
    //-----------------------TablaGoleadores---------------------------------
    public void goleadores() throws SQLException
    {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: TABLA DE GOLEADORES");
        queryGoleadores();
    }
    
    
    public void logicaVentanaPrincipal(String operacion, DefaultTableModel tabla1, String parametro)
    {
        //Seteo tabla
        setTabla(tabla1);
        //Seteo la option a la variable global
        setOption(operacion);
        //Menu de control para las opciones deisponibles
        try {
            switch(getOption()){
                case "EQUIPOS PARTICIPANTES POR CONFEDERACIÓN":  
                    equiposCof(parametro);
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
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL REALIZAR LA OPERACION");
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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


/*
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
                */




        /*
        output = statement.executeQuery("SELECT * FROM CUERPO_ARBITRAL");
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();
        
        DefaultTableModel modelo = getTabla();   //Obtengo la tabla de la Base de datos para poder agregarla
        modelo.setRowCount(0);
       
        while(output.next())
        {
            Vector vector = new Vector();   //Datos tabla
            for (int i = 1; i < index; i++) {
                vector.add(output.getString(i));
            }
            modelo.addRow(vector);
        }
        */



        /*
        output = statement.executeQuery("SELECT * FROM PARTIDO");
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();
        
        DefaultTableModel modelo = getTabla();   //Obtengo la tabla de la Base de datos para poder agregarla
        modelo.setRowCount(0);
        
        while(output.next())
        {
            System.out.println("numeroPartido: "+output.getString(1)+"\netapa_clasi: "+output.getString(2)+"\nfecha: "+output.getString(3)+
                    "\nhira: "+output.getString(4)+"\ncant_afici: "+output.getString(5)+"\nminRepoPrimer: "+output.getString(6)+
                    "\nsegRepoSegun: "+output.getString(7)+"\nTextra: "+output.getString(8)+"\npenales: "+output.getString(9));
        
            Vector vector = new Vector();   //Datos tabla
            for (int i = 1; i < index; i++) {
                vector.add(output.getString(i));
            }
            modelo.addRow(vector);
        }
        */