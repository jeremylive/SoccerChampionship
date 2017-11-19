package proyecto2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

public class ControladorPrincipal {

    //Variables globales
    private String option;
    //private int contadorMundial = 0; //limite 48
    private ArrayList<String> equiposMundial = new ArrayList<String>();
    private ResultSet output;            //Guarda el resultado del query
    private ResultSetMetaData metaDatos;
    private Statement statement;
    private Connection connection;
    private int numero_partido = 0;
    //private DefaultTableModel tabla;
    private int quienGanoPartido;
    private String codigoEquipo;
    private String codigoEquipoAnterior;
    //Variables GRUPOS Y CLASIFICACIOENS
    private int posicion=0, puntos_eq1=0, puntos_eq2=0, pj_eq1=0, pj_eq2=0, pg_eq1=0, pg_eq2=0, pe_eq1=0, pe_eq2=0, pp_eq1=0, pp_eq2=0, gf_eq1=0, gf_eq2=0, gc_eq1=0, gc_eq2=0, dif_eq1=0, dif_eq2=0;
        
    //Contadores
    private int contTitulares1;
    private int contTitulares2;
    private int contSuplentes1;
    private int contSuplentes2;
    
    
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
    public ControladorPrincipal() {
        this.option = "";
    }

    //Gets and Sets
    public void setOption(String opcion) {
        this.option = opcion;
    }

    public String getOption() {
        return this.option;
    }
/*
    public int getContadorMundial() {
        return contadorMundial;
    }

    public void upContadorMundial() {
        this.contadorMundial++;
    }
¨*/
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
    /*
    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }
    */
    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    
    
    
    /**
     * Funciones
     */

    //Funciones
    //Crea un nuevo equipo en la tabla Equipo
    public void crearEquipo(String codEquipo, String nombrePais, String grupoInicial, String codigoConfederacion) throws SQLException {
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
                + "(" + SQLcodEquipo + "," + SQLnombrePais + "," + SQLgrupoInicial + "," + SQLcodConfed + ")";
        statement.executeUpdate(queryInsert);
        getConnection().commit();
    }

    //Crea una copia del entrenador con el pasaporteReal y  le asigna el nuevo codEquipo
    public void crearEntrenadorEquipo(String paisNac, String fechaIni, String codEquipo, int pasaporteReal) throws SQLException {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = " + pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();

        ArrayList<String> datosPersona = new ArrayList();
        while (output.next()) {
            for (int i = 1; i <= index; i++) {
                datosPersona.add(output.getString(i));
            }
        }

        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while (output.next()) {
            pasaporteNuevo = output.getInt(1) + 1;
        }

        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "(" + pasaporteNuevo + ",'" + datosPersona.get(0) + "','" + datosPersona.get(1) + "','"
                + datosPersona.get(2) + "',TO_TIMESTAMP('" + datosPersona.get(3) + "','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();

        //Inserto una nueva tupla en Entrenador
        insertar = "INSERT INTO ENTRENADOR(NUMERO_PASAPORTE,PAIS_NACIONALIDAD,FECHA_INICIO,CODIGO_EQUIPO) VALUES "
                + "(" + pasaporteNuevo + "," + paisNac + ",TO_TIMESTAMP(" + fechaIni + ",'YYYY-MM-DD HH24:MI:SS.FF9'),"
                + codEquipo + ")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
    
    //INSERTO EN LA TABLA PERSONA Y JUGADOR
    public void crearJugadorEquipo(int pasaporteReal, String puesto, int numCamiseta, String codEquipo, String esCapt) throws SQLException {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = " + pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();

        ArrayList<String> datosPersona = new ArrayList();
        while (output.next()) {
            for (int i = 1; i <= index; i++) {
                datosPersona.add(output.getString(i));
            }
        }

        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while (output.next()) {
            pasaporteNuevo = output.getInt(1) + 1;
        }

        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "(" + pasaporteNuevo + ",'" + datosPersona.get(0) + "','" + datosPersona.get(1) + "','"
                + datosPersona.get(2) + "',TO_TIMESTAMP('" + datosPersona.get(3) + "','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();

        //Inserto una nueva tupla en Jugador
        insertar = "INSERT INTO JUGADOR(NUMERO_PASAPORTE,PUESTO,NUMERO_CAMISETA,CODIGO_EQUIPO,ES_CAPITAN) VALUES "
                + "(" + pasaporteNuevo + "," + puesto + "," + numCamiseta + "," + codEquipo + "," + esCapt + ")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
    
    //INSERTO EN LA TABLA PERSONA Y ASISTENTE
    public void crearAsistenteEquipo(int pasaporteReal, String paisNac, String fechaIni, String tipoAsist, String codEquipo) throws SQLException {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = " + pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();

        ArrayList<String> datosPersona = new ArrayList();
        while (output.next()) {
            for (int i = 1; i <= index; i++) {
                datosPersona.add(output.getString(i));
            }
        }

        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while (output.next()) {
            pasaporteNuevo = output.getInt(1) + 1;
        }

        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "(" + pasaporteNuevo + ",'" + datosPersona.get(0) + "','" + datosPersona.get(1) + "','"
                + datosPersona.get(2) + "',TO_TIMESTAMP('" + datosPersona.get(3) + "','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();

        //Inserto una nueva tupla en Asistente
        insertar = "INSERT INTO ASISTENTE(NUMERO_PASAPORTE,PAIS_NACIONALIDAD,FECHA_INICIO,TIPO,CODIGO_EQUIPO) VALUES "
                + "(" + pasaporteNuevo + "," + paisNac + ",TO_TIMESTAMP(" + fechaIni + ",'YYYY-MM-DD HH24:MI:SS.FF9'),"
                + tipoAsist + "," + codEquipo + ")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
    
    //INSERTO EN LA TABLA DE PERSONA Y FEDERATIVOS
    public void crearFederativoEquipo(int pasaporteReal, String paisNac, String fechaIni, String puesto, String codEquipo) throws SQLException {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Obtengo los datos de Persona con el num de pasaporte
        String queryPersona = "SELECT NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM PERSONA WHERE NUM_PASAPORTE = " + pasaporteReal;
        output = statement.executeQuery(queryPersona);
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();

        ArrayList<String> datosPersona = new ArrayList();
        while (output.next()) {
            for (int i = 1; i <= index; i++) {
                datosPersona.add(output.getString(i));
            }
        }

        //Obtengo el ultimo numero de pasaporte existente en la tabla
        int pasaporteNuevo = 0;
        String queryUltimoPas = "SELECT MAX(NUM_PASAPORTE) FROM PERSONA";
        output = statement.executeQuery(queryUltimoPas);
        while (output.next()) {
            pasaporteNuevo = output.getInt(1) + 1;
        }

        //Inserto una nueva tupla en Persona
        String insertar = "INSERT INTO PERSONA(NUM_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO) VALUES "
                + "(" + pasaporteNuevo + ",'" + datosPersona.get(0) + "','" + datosPersona.get(1) + "','"
                + datosPersona.get(2) + "',TO_TIMESTAMP('" + datosPersona.get(3) + "','YYYY-MM-DD HH24:MI:SS.FF9'))";
        statement.executeUpdate(insertar);
        getConnection().commit();

        //Inserto una nueva tupla en Federativo
        insertar = "INSERT INTO FEDERATIVO(NUMERO_PASAPORTE,PAIS_NACIONALIDAD,FECHA_INICIO,PUESTO,CODIGO_EQUIPO) VALUES "
                + "(" + pasaporteNuevo + "," + paisNac + ",TO_TIMESTAMP(" + fechaIni + ",'YYYY-MM-DD HH24:MI:SS.FF9'),"
                + puesto + "," + codEquipo + ")";
        statement.executeUpdate(insertar);
        getConnection().commit();
    }
    
    // CRUD EQUIPO.. borrar
    public void borrarEquipo(String codEquipo) throws SQLException {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Borra los federativos del Equipo
        //Obtiene los federativos a borrar
        String queryObtenerFed = "SELECT NUMERO_PASAPORTE FROM FEDERATIVO WHERE CODIGO_EQUIPO = '" + codEquipo + "'";
        output = statement.executeQuery(queryObtenerFed);
        ArrayList<Integer> pasaportes = new ArrayList<>();
        while (output.next()) {
            pasaportes.add(output.getInt(1));
        }
        //Borra el Federativo y su correspondiente en Persona
        for (int numPasBorrar : pasaportes) {
            statement.executeUpdate("DELETE FROM FEDERATIVO WHERE NUMERO_PASAPORTE = " + numPasBorrar);
            statement.executeUpdate("DELETE FROM PERSONA WHERE NUM_PASAPORTE = " + numPasBorrar);
        }

        //Borra los asistentes del Equipo
        //Obtiene los asistentes a borrar
        String queryObtenerAsist = "SELECT NUMERO_PASAPORTE FROM ASISTENTE WHERE CODIGO_EQUIPO = '" + codEquipo + "'";
        output = statement.executeQuery(queryObtenerAsist);
        pasaportes = new ArrayList<>();
        while (output.next()) {
            pasaportes.add(output.getInt(1));
        }
        //Borra el Asistente y su correspondiente en Persona
        for (int numPasBorrar : pasaportes) {
            statement.executeUpdate("DELETE FROM ASISTENTE WHERE NUMERO_PASAPORTE = " + numPasBorrar);
            statement.executeUpdate("DELETE FROM PERSONA WHERE NUM_PASAPORTE = " + numPasBorrar);
        }

        //Borra el entrenador del Equipo
        //Obtiene el entrenador a borrar
        String queryObtenerEntre = "SELECT NUMERO_PASAPORTE FROM ENTRENADOR WHERE CODIGO_EQUIPO = '" + codEquipo + "'";
        output = statement.executeQuery(queryObtenerEntre);
        pasaportes = new ArrayList<>();
        while (output.next()) {
            pasaportes.add(output.getInt(1));
        }
        //Borra el Entrenador y su correspondiente en Persona
        for (int numPasBorrar : pasaportes) {
            statement.executeUpdate("DELETE FROM ENTRENADOR WHERE NUMERO_PASAPORTE = " + numPasBorrar);
            statement.executeUpdate("DELETE FROM PERSONA WHERE NUM_PASAPORTE = " + numPasBorrar);
        }

        //Borra los jugadores del Equipo
        //Obtiene los jugadores a borrar
        String queryObtenerJugad = "SELECT NUMERO_PASAPORTE FROM JUGADOR WHERE CODIGO_EQUIPO = '" + codEquipo + "'";
        output = statement.executeQuery(queryObtenerJugad);
        pasaportes = new ArrayList<>();
        while (output.next()) {
            pasaportes.add(output.getInt(1));
        }
        //Borra el Jugador y su correspondiente en Persona
        for (int numPasBorrar : pasaportes) {
            statement.executeUpdate("DELETE FROM JUGADOR WHERE NUMERO_PASAPORTE = " + numPasBorrar);
            statement.executeUpdate("DELETE FROM PERSONA WHERE NUM_PASAPORTE = " + numPasBorrar);
        }

        //Borra el Equipo
        String queryDelete = "DELETE FROM EQUIPO WHERE CODIGO_EQUIPO = '" + codEquipo + "'";
        statement.executeUpdate(queryDelete);
        connection.commit();
    }

    //Actualizar equipos... CRUD EQUIPO - se utilizo una transaccion
    public void actualizarEquipo(String codEquipoAnterior, String codEquipoNuevo, String nombre, String grupoIni, String codConfed) {
        //Hago conexion
        connection = Conexion.getConexion();

        try {
            statement = connection.createStatement();
            connection.setAutoCommit(false);

            //Revisa si es necesario cambiar las demás tablas
            if (!codEquipoAnterior.equals(codEquipoNuevo)) {
                String feder = "UPDATE FEDERATIVO SET CODIGO_EQUIPO = '" + codEquipoNuevo + "' WHERE CODIGO_EQUIPO = '" + codEquipoAnterior + "'";
                String asist = "UPDATE ASISTENTE SET CODIGO_EQUIPO = '" + codEquipoNuevo + "' WHERE CODIGO_EQUIPO = '" + codEquipoAnterior + "'";
                String entren = "UPDATE ENTRENADOR SET CODIGO_EQUIPO = '" + codEquipoNuevo + "' WHERE CODIGO_EQUIPO = '" + codEquipoAnterior + "'";
                String jugad = "UPDATE JUGADOR SET CODIGO_EQUIPO = '" + codEquipoNuevo + "' WHERE CODIGO_EQUIPO = '" + codEquipoAnterior + "'";
                statement.executeUpdate(feder);
                statement.executeUpdate(asist);
                statement.executeUpdate(entren);
                statement.executeUpdate(jugad);
            }
            //Actualiza el Equipo
            String equipo = "UPDATE EQUIPO SET CODIGO_EQUIPO = '" + codEquipoNuevo + "', NOMBRE = '" + nombre
                    + "', GRUPO_INICIO = '" + grupoIni + "', CODIGO_CONF = '" + codConfed + "' WHERE CODIGO_EQUIPO = '" + codEquipoAnterior + "'";
            statement.executeUpdate(equipo);
            connection.commit();
            connection.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Equipo actualizado correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el equipo");
            System.err.println("Error: "+ex.getMessage());
            if (connection != null) {
                System.out.println("Rollback");
                try {
                    //deshace todos los cambios realizados en los datos
                    connection.rollback();
                } catch (SQLException ex1) {
                    System.err.println("No se pudo deshacer" + ex1.getMessage());
                }
            }
        }
    }

    //Operacion tabla equipos por confederacion
    public void queryEquiposPorConfed(String codConfed) {
        try {
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();

            //Crea el query
            String query = "SELECT CONFEDERACIONESFUTBOL.CODIGO,EQUIPO.NOMBRE FROM EQUIPO JOIN CONFEDERACIONESFUTBOL ON CONFEDERACIONESFUTBOL.CODIGO = EQUIPO.CODIGO_CONF ";
            //Si se especifica un equipo
            if (!codConfed.equals("")) {
                query += "WHERE CONFEDERACIONESFUTBOL.CODIGO = '" + codConfed + "' ";
            }
            query += "ORDER BY CONFEDERACIONESFUTBOL.CODIGO,EQUIPO.NOMBRE";

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
            while (output.next()) {
                //Imprime en pantalla
                if (confederacionActual.equals("") || !confederacionActual.equals(output.getString(1))) {
                    System.out.println(output.getString(1));
                    confederacionActual = output.getString(1);
                }
                System.out.println("    " + output.getString(2));
                //Añado al vector de datos
                Vector tupla = new Vector();
                for (int i = 1; i <= index; i++) {
                    tupla.add(output.getString(i));
                }
                filas.add(tupla);
            }

            //Muestro los resultados
            DefaultTableModel modelo = (DefaultTableModel) ventanaPrincipal.tablaQuerysPrincipal.getModel();
            modelo.setDataVector(filas, nombreColumnas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta");
        }
    }
    
    //OPERACION TABLA GOLEADORES
    public void queryGoleadores() {
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
            while (output.next()) {
                //Imprime en pantalla
                System.out.println("Posicion:" + posicion + "   Nombre:" + output.getString(1) + "   Apellido1:" + output.getString(2) + "   Apellido2:" + output.getString(3) + "   Equipo:" + output.getString(4) + "   Goles:" + output.getString(5));
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
            DefaultTableModel modelo = (DefaultTableModel) ventanaPrincipal.tablaQuerysPrincipal.getModel();;
            modelo.setDataVector(filas, nombreColumnas);

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
        
        //Creo query´s
        String insertCUERPO_Principal = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_principal()+",'Principal')";
        String insertCUERPO_Asist1 = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_asistente_1()+",'Asistente')";
        String insertCUERPO_Asist2 = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_asistente_2()+",'Asistente')";
        String insertCUERPO_4to = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_4to()+",'Cuarto')";
        String insertCUERPO_5to = "INSERT INTO CUERPO_ARBITRAL VALUES ("+getNumero_partido()+","+getArbitro_5to()+",'Quinto')";
        
        //INSERTS A PARTIDO_CAMBIOS
        statement.executeUpdate(insertCUERPO_Principal);
        statement.executeUpdate(insertCUERPO_Asist1);
        statement.executeUpdate(insertCUERPO_Asist2);
        statement.executeUpdate(insertCUERPO_4to);
        statement.executeUpdate(insertCUERPO_5to);        
        getConnection().commit();

        //se habilita el modo de confirmación automática
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
            
            //Valido que no se pase de 3 cambios por equipo
            String cambio = interfazPartidos.cambiosHechos.getText();
            if(cambio == "0"){
                //SETEO EL EQUIPO PARA HACER LA COMPARACION DESPUES
                codigoEquipoAnterior = getCodigoEquipo();
                
                //Aumento cambio
                int Numchange =Integer.parseInt(cambio);
                Numchange++;

                //Actualizo interfaz con el contador modificado
                String change = Integer.toString(Numchange);
                interfazPartidos.cambiosHechos.setText(change);
            }else if(getCodigoEquipo().equals(codigoEquipoAnterior)){
                //Aumento cambio
                int Numchange =Integer.parseInt(cambio);
                Numchange++;

                //Actualizo interfaz con el contador modificado
                String change = Integer.toString(Numchange);
                interfazPartidos.cambiosHechos.setText(change);

            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");
        }
        return 0;
    }
    
    //INSERTO EN LA TABLA PARTIDO_PARTICIPA Y EN PARTIDO - Se usa una transaccion
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

    //Inserto en la tabla de titulares.. de equipo1
    public int titulares1(String jugadorTitular, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorTitular.isEmpty() || codEquipo.isEmpty())){
            setJugadores_titulares(jugadorTitular);
            setCodigoEquipo(codEquipo);
        }
       
        if(contTitulares1 < 12){
            
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
    
    //Inserto en la tabla de titulares.. de equipo2
    public int titulares2(String jugadorTitular, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorTitular.isEmpty() || codEquipo.isEmpty())){
            setJugadores_titulares(jugadorTitular);
            setCodigoEquipo(codEquipo);
        }
       
        if(contTitulares2 < 12){
            
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
    
    //Inserto en la tabla de suplentes... suplentes del equipo1
    public int suplentes1(String jugadorSuplente, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorSuplente.isEmpty() || codEquipo.isEmpty())){
            setJugadores_suplentes(jugadorSuplente);
            setCodigoEquipo(codEquipo);
        }
       
        if(contSuplentes1 < 11){
            
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
    
    //Inserto en la tabla de suplentes... suplentes del equipo2
    public int suplentes2(String jugadorSuplente, String codEquipo) throws SQLException
    {
        //Valido info 
        if(!(jugadorSuplente.isEmpty() || codEquipo.isEmpty())){
            setJugadores_suplentes(jugadorSuplente);
            setCodigoEquipo(codEquipo);
        }
       
        if(contSuplentes2 < 11){
            
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
        if (getTieraron_penales().equals("YES")) {
            crudPartidosPenales crudPenales = new crudPartidosPenales(this);
            crudPenales.setLocationRelativeTo(null);
            crudPenales.setVisible(true);
            
            JOptionPane.showMessageDialog(null, "Si Penales", "Se van a tirar penales", 1);
        } else {
            JOptionPane.showMessageDialog(null, "No Penales", "No se van a tiraron penales", 3);
        }
    }
    
    //Logica de interfaz penales
   public int queryPenales2(String numPenal, String seAnoto, String idJugador) throws SQLException
   {
       //Valido la info
       if(!(isInteger(idJugador))){
           JOptionPane.showMessageDialog(null, "El idJugador insertado no es valido");
           return 1;
       }
       
       //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();  
                
        //Creo query
        String query1 = "INSERT INTO PENALES VALUES ("+numPenal+",'"+seAnoto+"',"+idJugador+")";
        
        //Ejecuto query
        statement.executeUpdate(query1);
        getConnection().commit();  
       
        //Aumento el numero de penal
        int newNum = Integer.parseInt(numPenal);
        newNum++;
        String newNumString = Integer.toString(newNum);
        crudPartidosPenales.numPenal.setText(newNumString);
        
        return 0;
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
    
    //Carga la tabla de equipo1
    public void cargarEquipo1(String codEq) throws SQLException
    {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Ejecuto el query
        String query = "SELECT * FROM EQUIPO WHERE EQUIPO.CODIGO_PAIS = "+codEq;
        output = statement.executeQuery(query);
        //Obtengo los metadatos y nombres de columnas
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();

        Vector nombreColumnas = new Vector();
        for (int i = 1; i <= index; i++) {
            nombreColumnas.add(metaDatos.getColumnLabel(i));
        }

        //Obtengo las tuplas en un vector que contiene vectores
        Vector filas = new Vector();
        while (output.next()) {
            //Añado al vector de datos
            Vector tupla = new Vector();
            for (int i = 1; i <= index; i++) {
                tupla.add(output.getString(i));
            }
            filas.add(tupla);
        }

        //Muestro los resultados
        DefaultTableModel modelo = (DefaultTableModel) interfazPartidos.tabla_Jugadores1.getModel();
        modelo.setDataVector(filas, nombreColumnas);
        
    }
 
    //Carga la tabla de equipo1
    public void cargarEquipo2(String codEq) throws SQLException
    {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Ejecuto el query
        String query = "SELECT * FROM EQUIPO WHERE EQUIPO.CODIGO_PAIS = "+codEq;
        output = statement.executeQuery(query);
        //Obtengo los metadatos y nombres de columnas
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();

        Vector nombreColumnas = new Vector();
        for (int i = 1; i <= index; i++) {
            nombreColumnas.add(metaDatos.getColumnLabel(i));
        }

        //Obtengo las tuplas en un vector que contiene vectores
        Vector filas = new Vector();
        while (output.next()) {
            //Añado al vector de datos
            Vector tupla = new Vector();
            for (int i = 1; i <= index; i++) {
                tupla.add(output.getString(i));
            }
            filas.add(tupla);
        }

        //Muestro los resultados
        DefaultTableModel modelo = (DefaultTableModel) interfazPartidos.tabla_Jugadores_equipo2.getModel();
        modelo.setDataVector(filas, nombreColumnas);
        
    }
    
    //carga arbitros en la interfaz
    public void cargarArbitro() throws SQLException
    {
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Ejecuto el query
        String query = "SELECT * FROM ARBITRO";
        output = statement.executeQuery(query);
        //Obtengo los metadatos y nombres de columnas
        metaDatos = output.getMetaData();
        int index = metaDatos.getColumnCount();

        Vector nombreColumnas = new Vector();
        for (int i = 1; i <= index; i++) {
            nombreColumnas.add(metaDatos.getColumnLabel(i));
        }

        //Obtengo las tuplas en un vector que contiene vectores
        Vector filas = new Vector();
        while (output.next()) {
            //Añado al vector de datos
            Vector tupla = new Vector();
            for (int i = 1; i <= index; i++) {
                tupla.add(output.getString(i));
            }
            filas.add(tupla);
        }

        //Muestro los resultados
        DefaultTableModel modelo = (DefaultTableModel) interfazPartidos.tablaAlbitros.getModel();
        modelo.setDataVector(filas, nombreColumnas);
        
    }
    
    //Creo tabla grupos clasificaciones
    public void queryCreoTablaGrupos() 
    {
        try{
            //Hago conexion
            connection = Conexion.getConexion();
            statement = connection.createStatement();

            //Ejecuto el query
            String query = "CREATE TABLE GRUPO_CLASIFICAIONES( POSICION INT, EQUIPO CHAR(20), PUNTOS INT, PJ INT, PG INT, PE INT, PP INT, GF INT, GC INT, DIF INT )";
            statement.execute(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    //inserto en la tabla grupo_clasificaiones
    public void queryInsetoTablaGruposClasificaciones(String eq1, String eq2) throws SQLException
    {
        int golesEq1=0, golesEq2=0;
        //Hago conexion
        connection = Conexion.getConexion();
        statement = connection.createStatement();

        //Obtengo gf eq1
        String consulta1 = "SELECT COUNT(GOLES.NUMPARTIDO) FROM GOLES JOIN EQUIPO ON GOLES.CODIGO_PAIS = EQUIPO."+eq1;
        output = statement.executeQuery(consulta1);
        metaDatos = output.getMetaData();
        while (output.next()) {
            gf_eq1 += Integer.parseInt(output.getString(0));
            golesEq1 = Integer.parseInt(output.getString(0));
        }
        //Obtengo gf eq2
        String consulta11 = "SELECT COUNT(GOLES.NUMPARTIDO) FROM GOLES JOIN EQUIPO ON GOLES.CODIGO_PAIS = EQUIPO."+eq2;
        output = statement.executeQuery(consulta11);
        metaDatos = output.getMetaData();
        while (output.next()) {
            gf_eq2 += Integer.parseInt(output.getString(0));
            golesEq2 = Integer.parseInt(output.getString(0));
        }
        //Obtengo gc eq1 y eq2
        gc_eq1 += gf_eq2;
        gc_eq2 += gf_eq1;
        //Obtengo dif  ...  gf - gc
        dif_eq1 += gf_eq1 - gc_eq1;
        dif_eq2 += gf_eq2 - gc_eq2;
        //Pg y pp y pj
        if(golesEq1 > golesEq2){
            pg_eq1++;
            pp_eq2++;
            pj_eq1++;
            pj_eq2++;
        }else if(golesEq1 < golesEq2){
            pg_eq2++;
            pp_eq1++;
            pj_eq1++;
            pj_eq2++;
        }else if(golesEq1 == golesEq2){
            pe_eq1++;
            pe_eq2++;
            pj_eq1++;
            pj_eq2++;
        }
        
        //Puntos: 3 x cada PG, 1 x cada PE
        pg_eq1 += (pg_eq1*3)+(pe_eq1);
        pg_eq2 += (pg_eq2*3)+(pe_eq2);        
        
        //Consulta para sacar el nombre del equipo
        String consult1 = "SELECT NOMBRE_PAIS FROM EQUIPO WHERE EQUIPO.CODIGO_CONF = "+eq1;
        String consult2 = "SELECT NOMBRE_PAIS FROM EQUIPO WHERE EQUIPO.CODIGO_CONF = "+eq2;     
        output = statement.executeQuery(consult1);
        metaDatos = output.getMetaData();
        while (output.next()) {
            eq1 += Integer.parseInt(output.getString(0));
        }
        //
        output = statement.executeQuery(consult2);
        metaDatos = output.getMetaData();
        while (output.next()) {
            eq2 += Integer.parseInt(output.getString(0));
        }
        
        //Ejecuto el query
        String query1 = "INSERT INTO GRUPO_CLASIFICAIONES VALUES ("+posicion+",'"+eq1+"',"+puntos_eq1+","+pj_eq1+","+pg_eq1+","+pe_eq1+","+pp_eq1+","+gf_eq1+","+gc_eq1+","+dif_eq1+")";
        posicion++;
        String query2 = "INSERT INTO GRUPO_CLASIFICAIONES VALUES ("+posicion+",'"+eq2+"',"+puntos_eq2+","+pj_eq2+","+pg_eq2+","+pe_eq2+","+pp_eq2+","+gf_eq2+","+gc_eq2+","+dif_eq2+")";
        
        statement.executeUpdate(query1);
        statement.executeUpdate(query2);
        getConnection().commit();  
        
        posicion++;
    }
            
    
    /**
     * Funcion Inserto partido
     *
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

            String numeroPartido = ""+interfazPartidos.numero_partido.getText();
            int newNumero = Integer.parseInt(numeroPartido);
            newNumero++;
            interfazPartidos.numero_partido.setText(""+newNumero);

            JOptionPane.showMessageDialog(null, "Felicidades toda su información a insertar esta correcta.");

            //INSERTO EN LA TABLA PARTIDO_PARTICIPA Y EN PARTIDO - Se usa una transaccion
            queryPartido();

            //INSERTO EN TABLA PENALES SI ES QUE HAY PENALES
            queryPenales();
            
            //actualizo datos.. quien gano el partido?
            //INSERTO EN LA TABLA DE GRUPOS Y CLASIFICACIONES
            queryInsetoTablaGruposClasificaciones(equipo1, equipo2);
            
            //Valido si ya llego a 64
            if(newNumero <= 64){
                JOptionPane.showMessageDialog(null, "FELICIDADES, INSERTASTE 64 PARTIDOS");
            }
            JOptionPane.showMessageDialog(null, "Felicidades toda su información esta correcta.\nAcabas de insertar el partido numero : "+newNumero);
        } else {
            JOptionPane.showMessageDialog(null, "Algún dato en la información no se inserto. \nPorfavor intentar nuevamente... -.-");

        }
        return 0;
    
    }
        
    //--------------Equipos por Confederacion------------------------
    public void equiposCof(String parametro) throws SQLException {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: EQUIPOS PARTICIPANTES POR CONFEDERACIÓN");
        queryEquiposPorConfed(parametro);
    }

    //----------------------Informacion del partido---------------------------
    public void infoPartido() {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: INFORME OFICIAL DEL PARTIDO");
    }

    //----------------------Informacion del campeonato, grupo clasificatoria----
    public void grupoClasificaciones() {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: GRUPOS Y CLASIFICACIONES");

    }

    //-----------------------TablaPosicionesGenerales------------------------
    public void posicionesGenerales() {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: TABLA GENERAL DE POSICIONES");
    }

    //-----------------------TablaGoleadores---------------------------------
    public void goleadores() throws SQLException {
        JOptionPane.showMessageDialog(null, "ACABAS DE HACER LA CONSULTA: TABLA DE GOLEADORES");
        queryGoleadores();
    }

    public void logicaVentanaPrincipal(String operacion, String parametro) 
    {
        //Creo la tabla grupos por clasificaion para poder insertarle tuplas despues
        queryCreoTablaGrupos();
        //Seteo la option a la variable global
        setOption(operacion);
        //Menu de control para las opciones deisponibles
        try {
            switch (getOption()) {
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
        } catch (SQLException ex) {
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
<<<<<<< HEAD
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
