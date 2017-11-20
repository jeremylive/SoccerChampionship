package proyecto2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author live
 */
public class interfazPartidos extends javax.swing.JFrame {

    //Variables globales
    ControladorPrincipal control;

    public interfazPartidos(ControladorPrincipal controll) {
        this.control = controll;
        initComponents();
        cargarDatosExistentes();
    }

    private void cargarArbitro() {
        try {
            //Hago conexion
            Connection connection = Conexion.getConexion();
            Statement statement = connection.createStatement();

            //Realiza el query
            String query = "SELECT NUMERO_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2 FROM ALBITRO JOIN PERSONA ON ALBITRO.NUMERO_PASAPORTE = PERSONA.NUM_PASAPORTE ORDER BY NUMERO_PASAPORTE";
            ResultSet output = statement.executeQuery(query);

            //Obtengo los metadatos y nombres de columnas
            ResultSetMetaData metaDatos = output.getMetaData();
            int index = metaDatos.getColumnCount();

            Vector nombreColumnas = new Vector();
            for (int i = 1; i <= index; i++) {
                nombreColumnas.add(metaDatos.getColumnLabel(i));
            }

            //Obtengo las tuplas en un vector que contiene vectores
            Vector filas = new Vector();
            while (output.next()) {
                Vector tupla = new Vector();
                for (int i = 1; i <= index; i++) {
                    tupla.add(output.getString(i));
                }
                filas.add(tupla);
            }

            //Muestro los resultados
            DefaultTableModel modelo = (DefaultTableModel) this.tablaAlbitros.getModel();
            modelo.setDataVector(filas, nombreColumnas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla de Arbitros");
        }
    }

    private void cargarEquipo1(String codEq) {
        try {
            //Hago conexion
            Connection connection = Conexion.getConexion();
            Statement statement = connection.createStatement();

            //Realiza el query
            String query = "SELECT NUMERO_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2 FROM JUGADOR JOIN PERSONA ON JUGADOR.NUMERO_PASAPORTE = PERSONA.NUM_PASAPORTE WHERE CODIGO_EQUIPO = '" + codEq + "' ORDER BY NUMERO_PASAPORTE";
            ResultSet output = statement.executeQuery(query);

            //Obtengo los metadatos y nombres de columnas
            ResultSetMetaData metaDatos = output.getMetaData();
            int index = metaDatos.getColumnCount();

            Vector nombreColumnas = new Vector();
            for (int i = 1; i <= index; i++) {
                nombreColumnas.add(metaDatos.getColumnLabel(i));
            }

            //Obtengo las tuplas en un vector que contiene vectores
            Vector filas = new Vector();
            while (output.next()) {
                Vector tupla = new Vector();
                for (int i = 1; i <= index; i++) {
                    tupla.add(output.getString(i));
                }
                filas.add(tupla);
            }

            //Muestro los resultados
            DefaultTableModel modelo = (DefaultTableModel) this.tabla_Jugadores1.getModel();
            modelo.setDataVector(filas, nombreColumnas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla de Jugadores del Eq.1");
        }
    }

    private void cargarEquipo2(String codEq) {
        try {
            //Hago conexion
            Connection connection = Conexion.getConexion();
            Statement statement = connection.createStatement();

            //Realiza el query
            String query = "SELECT NUMERO_PASAPORTE,NOMBRE,APELLIDO1,APELLIDO2 FROM JUGADOR JOIN PERSONA ON JUGADOR.NUMERO_PASAPORTE = PERSONA.NUM_PASAPORTE WHERE CODIGO_EQUIPO = '" + codEq + "' ORDER BY NUMERO_PASAPORTE";
            ResultSet output = statement.executeQuery(query);

            //Obtengo los metadatos y nombres de columnas
            ResultSetMetaData metaDatos = output.getMetaData();
            int index = metaDatos.getColumnCount();

            Vector nombreColumnas = new Vector();
            for (int i = 1; i <= index; i++) {
                nombreColumnas.add(metaDatos.getColumnLabel(i));
            }

            //Obtengo las tuplas en un vector que contiene vectores
            Vector filas = new Vector();
            while (output.next()) {
                Vector tupla = new Vector();
                for (int i = 1; i <= index; i++) {
                    tupla.add(output.getString(i));
                }
                filas.add(tupla);
            }

            //Muestro los resultados
            DefaultTableModel modelo = (DefaultTableModel) this.tabla_Jugadores_equipo2.getModel();
            modelo.setDataVector(filas, nombreColumnas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla de Jugadores del Eq.2");
        }
    }

    private void cargarDatosExistentes() {
        try {
            //Hago conexion
            Connection connection = Conexion.getConexion();
            Statement statement = connection.createStatement();

            //Realiza el query para Codigo de equipos
            ResultSet output = statement.executeQuery("SELECT CODIGO_EQUIPO FROM EQUIPO");
            //Obtengo los codigos en un vector
            Vector codigos = new Vector();
            while (output.next()) {
                codigos.add(output.getString(1));
            }

            //Realiza el query para Nombres de Estadio
            output = statement.executeQuery("SELECT NOMBRE_ESTADIO FROM SEDE");
            //Obtengo los nombres en un vector
            Vector estadios = new Vector();
            while (output.next()) {
                estadios.add(output.getString(1));
            }

            //Obtiene el Numero de Partido actual
            output = statement.executeQuery("SELECT MAX(NUMERO_PARTIDO) FROM PARTIDO");
            //Obtengo los nombres en un vector
            while (output.next()) {
                numero_partido.setText("" + output.getInt(1));
            }
            
            //Setea los ComboBox
            this.equipo1.setModel(new DefaultComboBoxModel<>(codigos));
            this.equipo2.setModel(new DefaultComboBoxModel<>(codigos));
            this.nombreEstadio.setModel(new DefaultComboBoxModel<>(estadios));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los codigos de los equipos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        equipo1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cargarEq1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Jugadores_equipo2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombreEstadio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cantAficionados = new javax.swing.JTextField();
        ejecutarCrudPartido = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        minCambio = new javax.swing.JTextField();
        jugadorEntraCambio = new javax.swing.JTextField();
        segCambio = new javax.swing.JTextField();
        jugadorSaleCambio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        arbitroAsistente2 = new javax.swing.JTextField();
        cuartoArbitro = new javax.swing.JTextField();
        arbitroPrincipal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        quintoArbitro = new javax.swing.JTextField();
        arbitroAsistente1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        minGAR = new javax.swing.JTextField();
        jugadorGAR = new javax.swing.JTextField();
        segGAR = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlbitros = new javax.swing.JTable();
        ejecutarCambio = new javax.swing.JButton();
        ejecutarGAR = new javax.swing.JButton();
        ejecutarAlbitro = new javax.swing.JButton();
        golAmarillaRoja = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        primerTiempoR = new javax.swing.JComboBox<>();
        segundoTiempoR = new javax.swing.JComboBox<>();
        jugaronTiemposExtras = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        tiraronPenales = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        grupo_clasificatoria = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_Jugadores1 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        codGAR = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        equipo2 = new javax.swing.JComboBox<>();
        cargarEq2 = new javax.swing.JButton();
        InsertarSuplentesEq1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        codigoEquipoCambios = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        InsertarTitularesEq1 = new javax.swing.JButton();
        InsertarTitularesEq2 = new javax.swing.JButton();
        InsertarSuplentesEq2 = new javax.swing.JButton();
        año = new javax.swing.JComboBox<>();
        mes = new javax.swing.JComboBox<>();
        dia = new javax.swing.JComboBox<>();
        hora = new javax.swing.JComboBox<>();
        minutos = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        numero_partido = new javax.swing.JLabel();
        cambiosHechosEq1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cargarArbitros = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        cambiosHechosEq2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Interfaz Partidos Create");

        jLabel2.setText("Escoja el equipo 1:");

        equipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USA", "MEX", "HON", "CRC", "COL", "ECU", "BRA", "CHI", "URU", "ARG", "ENG", "BEL", "FRA", "ESP", "POR", "NED", "GER", "SUI", "CRO", "BIH", "ITA", "GRE", "ALG", "GHA", "CIV", "NGA", "CMR", "RUS", "IRN", "JPN", "KOR", "AUS" }));

        jLabel3.setText("Tabla de jugadores Eq1:");

        cargarEq1.setText("Cargar");
        cargarEq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarEq1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tabla_Jugadores_equipo2);

        jLabel4.setText("Nombre del estadio:");

        jLabel5.setText("Fecha:");

        jLabel6.setText("Hora:");

        nombreEstadio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belo Horizonte", "Brasilia", "Cuiabá", "Curitiba", "Fortaleza", "Natal", "Recife", "Río de Janeiro", "Salvador", "São Paulo", "Porto Alegre", "Manaos", "Pantanal" }));

        jLabel7.setText("Cantidad aficionados:");

        ejecutarCrudPartido.setText("InsertoPartido");
        ejecutarCrudPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarCrudPartidoActionPerformed(evt);
            }
        });

        jLabel10.setText("Cambio (max 3)");

        jLabel11.setText("Minutos:");

        jLabel12.setText("Segundos:");

        jLabel13.setText("Jugador entra:");

        jLabel14.setText("Jugador sale:");

        jLabel15.setText("Cuerpo árbitrario");

        jLabel16.setText("Árbitro principal:");

        jLabel17.setText("Árbitro asistente 1:");

        jLabel18.setText("4to árbitro:");

        jLabel19.setText("5to árbitro:");

        jLabel21.setText("Minutos:");

        jLabel22.setText("Segundos:");

        jLabel23.setText("Jugador:");

        jScrollPane2.setViewportView(tablaAlbitros);

        ejecutarCambio.setText("Ejecutar");
        ejecutarCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarCambioActionPerformed(evt);
            }
        });

        ejecutarGAR.setText("Ejecutar");
        ejecutarGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarGARActionPerformed(evt);
            }
        });

        ejecutarAlbitro.setText("Ejecutar");
        ejecutarAlbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarAlbitroActionPerformed(evt);
            }
        });

        golAmarillaRoja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gol", "TarjetaAmarilla", "TarjetaRoja" }));

        jLabel20.setText("Tabla Arbitros:");

        jLabel28.setText("PrimerTiempoReposiciónMin:");

        jLabel29.setText("SegundoTiempoReposiciónMin:");

        jLabel30.setText("Cambios Hechos:");

        primerTiempoR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5" }));

        segundoTiempoR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5" }));

        jugaronTiemposExtras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));

        jLabel31.setText("Jugaron tiempos extras?");

        tiraronPenales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));

        jLabel32.setText("Tiraron penales?");

        jLabel24.setText("Árbitro asistente 2:");

        grupo_clasificatoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H" }));

        jLabel25.setText("Grupo:");

        jScrollPane3.setViewportView(tabla_Jugadores1);

        jLabel33.setText("Codigo equipo:");

        jLabel35.setText("Escoja el equipo 2:");

        equipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USA", "MEX", "HON", "CRC", "COL", "ECU", "BRA", "CHI", "URU", "ARG", "ENG", "BEL", "FRA", "ESP", "POR", "NED", "GER", "SUI", "CRO", "BIH", "ITA", "GRE", "ALG", "GHA", "CIV", "NGA", "CMR", "RUS", "IRN", "JPN", "KOR", "AUS" }));

        cargarEq2.setText("Cargar");
        cargarEq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarEq2ActionPerformed(evt);
            }
        });

        InsertarSuplentesEq1.setText("Insertar Suplentes Equipo1");
        InsertarSuplentesEq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarSuplentesEq1ActionPerformed(evt);
            }
        });

        jLabel36.setText("Codigo equipo:");

        jLabel37.setText("Tabla de jugadores Eq2:");

        InsertarTitularesEq1.setText("Insertar Titulares Equipo1");
        InsertarTitularesEq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarTitularesEq1ActionPerformed(evt);
            }
        });

        InsertarTitularesEq2.setText("Insertar Titulares Equipo2");
        InsertarTitularesEq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarTitularesEq2ActionPerformed(evt);
            }
        });

        InsertarSuplentesEq2.setText("Insertar Suplentes Equipo2");
        InsertarSuplentesEq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarSuplentesEq2ActionPerformed(evt);
            }
        });

        año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2012", "2013", "2014", "2015", "2016", "2017", "2018" }));

        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        minutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel8.setText(":");

        jLabel9.setText("-");

        jLabel26.setText("-");

        jLabel27.setText("Numero Partido:");

        numero_partido.setText("0");

        cambiosHechosEq1.setText("0");

        jLabel34.setText("(max 11)");

        jLabel38.setText("(max 12)");

        cargarArbitros.setText("Cargar");
        cargarArbitros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArbitrosActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel39.setText("-");

        cambiosHechosEq2.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8))
                                            .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(grupo_clasificatoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tiraronPenales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jugaronTiemposExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(segundoTiempoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(primerTiempoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cantAficionados, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numero_partido))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ejecutarCrudPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addGap(18, 18, 18)
                                        .addComponent(InsertarTitularesEq2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addGap(18, 18, 18)
                                        .addComponent(InsertarSuplentesEq2))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(InsertarSuplentesEq1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(InsertarTitularesEq1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(269, 269, 269)))
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel37))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargarEq1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addGap(8, 8, 8)
                        .addComponent(equipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargarEq2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(arbitroAsistente1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(arbitroPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(ejecutarAlbitro, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quintoArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cuartoArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(arbitroAsistente2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(49, 49, 49))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel20)
                        .addGap(32, 32, 32)
                        .addComponent(cargarArbitros)
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel21)
                                            .addGap(42, 42, 42)
                                            .addComponent(minGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(11, 11, 11))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel33)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel22))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(segGAR, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                .addComponent(jugadorGAR, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                .addComponent(codGAR))
                                            .addGap(3, 3, 3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel13))
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(codigoEquipoCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jugadorSaleCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jugadorEntraCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(segCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(minCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(ejecutarCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cambiosHechosEq1)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cambiosHechosEq2))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel10)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(golAmarillaRoja, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ejecutarGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(equipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cargarEq2)
                                .addComponent(equipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cargarEq1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InsertarSuplentesEq1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InsertarSuplentesEq2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InsertarTitularesEq1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InsertarTitularesEq2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(golAmarillaRoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(minGAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(segGAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jugadorGAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(codGAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ejecutarGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(minCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(segCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jugadorEntraCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jugadorSaleCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoEquipoCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ejecutarCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cambiosHechosEq1)
                            .addComponent(jLabel39)
                            .addComponent(cambiosHechosEq2))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(cargarArbitros))
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(arbitroPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(arbitroAsistente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(arbitroAsistente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(cuartoArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(quintoArbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ejecutarAlbitro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cantAficionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(primerTiempoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(segundoTiempoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(jugaronTiemposExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(tiraronPenales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(grupo_clasificatoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(numero_partido))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ejecutarCrudPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarEq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarEq1ActionPerformed
        //CARGAR TABLAS.....
        cargarEquipo1(equipo1.getSelectedItem().toString());
    }//GEN-LAST:event_cargarEq1ActionPerformed
    private void ejecutarCrudPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarCrudPartidoActionPerformed
        try {
            control.cargarEquipos(equipo1.getSelectedItem().toString(), equipo2.getSelectedItem().toString(), nombreEstadio.getSelectedItem().toString(), cantAficionados.getText(), jugaronTiemposExtras.getSelectedItem().toString(), tiraronPenales.getSelectedItem().toString(), grupo_clasificatoria.getSelectedItem().toString(), primerTiempoR.getSelectedItem().toString(), segundoTiempoR.getSelectedItem().toString(), hora.getSelectedItem().toString(), minutos.getSelectedItem().toString(), año.getSelectedItem().toString(), mes.getSelectedItem().toString(), dia.getSelectedItem().toString());
        } catch (SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
            if (control.getConnection() != null) {
                System.out.println("Rollback Crear Partido");
                try {
                    //deshace todos los cambios realizados en los datos
                    control.getConnection().rollback();
                } catch (SQLException ex1) {
                    System.err.println("No se pudo deshacer" + ex1.getMessage());
                }
            }
        }
    }//GEN-LAST:event_ejecutarCrudPartidoActionPerformed
    private void ejecutarAlbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarAlbitroActionPerformed
        try {
            control.ejecutarArbitro(arbitroPrincipal.getText(),arbitroAsistente1.getText(),arbitroAsistente2.getText(),cuartoArbitro.getText(),quintoArbitro.getText());
            JOptionPane.showMessageDialog(null, "Cuerpo Arbitral creado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
            if (control.getConnection() != null) {
                System.out.println("Rollback Ejecutar Arbitro");
                try {
                    //deshace todos los cambios realizados en los datos
                    control.getConnection().rollback();
                } catch (SQLException ex1) {
                    System.err.println("No se pudo deshacer" + ex1.getMessage());
                }
            }
        }
    }//GEN-LAST:event_ejecutarAlbitroActionPerformed

    private void cargarEq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarEq2ActionPerformed
        cargarEquipo2(equipo2.getSelectedItem().toString());
    }//GEN-LAST:event_cargarEq2ActionPerformed

    private void ejecutarCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarCambioActionPerformed
        try {
            control.ejecutarCambios(jugadorSaleCambio.getText(), jugadorEntraCambio.getText(), minCambio.getText(), segCambio.getText(), codigoEquipoCambios.getText(), equipo1.getSelectedItem().toString(), equipo2.getSelectedItem().toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el cambio");
        }
    }//GEN-LAST:event_ejecutarCambioActionPerformed

    private void ejecutarGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarGARActionPerformed
        try {
            control.ejecutarGAR(golAmarillaRoja.getSelectedItem().toString(), minGAR.getText(), segGAR.getText(), jugadorGAR.getText(), codGAR.getText());
            JOptionPane.showMessageDialog(null, "Accion insertada correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar la accion");
        }

    }//GEN-LAST:event_ejecutarGARActionPerformed

    private void InsertarSuplentesEq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarSuplentesEq1ActionPerformed
        try {
            control.suplentes1((String) tabla_Jugadores1.getModel().getValueAt(tabla_Jugadores1.getSelectedRow(), 0), this.equipo1.getSelectedItem().toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el jugador");
        }
    }//GEN-LAST:event_InsertarSuplentesEq1ActionPerformed

    private void InsertarTitularesEq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarTitularesEq1ActionPerformed
        try {
            control.titulares1((String) tabla_Jugadores1.getModel().getValueAt(tabla_Jugadores1.getSelectedRow(), 0), this.equipo1.getSelectedItem().toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el jugador");
        }
    }//GEN-LAST:event_InsertarTitularesEq1ActionPerformed

    private void InsertarTitularesEq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarTitularesEq2ActionPerformed
        try {
            control.titulares2((String) tabla_Jugadores_equipo2.getModel().getValueAt(tabla_Jugadores_equipo2.getSelectedRow(), 0), this.equipo2.getSelectedItem().toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el jugador");
        }
    }//GEN-LAST:event_InsertarTitularesEq2ActionPerformed

    private void InsertarSuplentesEq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarSuplentesEq2ActionPerformed
        try {
            control.suplentes2((String) tabla_Jugadores_equipo2.getModel().getValueAt(tabla_Jugadores_equipo2.getSelectedRow(), 0), this.equipo2.getSelectedItem().toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el jugador");
        }
    }//GEN-LAST:event_InsertarSuplentesEq2ActionPerformed

    private void cargarArbitrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArbitrosActionPerformed
        cargarArbitro();
    }//GEN-LAST:event_cargarArbitrosActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InsertarSuplentesEq1;
    private javax.swing.JButton InsertarSuplentesEq2;
    private javax.swing.JButton InsertarTitularesEq1;
    private javax.swing.JButton InsertarTitularesEq2;
    private javax.swing.JTextField arbitroAsistente1;
    private javax.swing.JTextField arbitroAsistente2;
    private javax.swing.JTextField arbitroPrincipal;
    private javax.swing.JComboBox<String> año;
    public static javax.swing.JLabel cambiosHechosEq1;
    public static javax.swing.JLabel cambiosHechosEq2;
    private javax.swing.JTextField cantAficionados;
    private javax.swing.JButton cargarArbitros;
    private javax.swing.JButton cargarEq1;
    private javax.swing.JButton cargarEq2;
    private javax.swing.JTextField codGAR;
    private javax.swing.JTextField codigoEquipoCambios;
    private javax.swing.JTextField cuartoArbitro;
    private javax.swing.JComboBox<String> dia;
    private javax.swing.JButton ejecutarAlbitro;
    private javax.swing.JButton ejecutarCambio;
    private javax.swing.JButton ejecutarCrudPartido;
    private javax.swing.JButton ejecutarGAR;
    private javax.swing.JComboBox<String> equipo1;
    private javax.swing.JComboBox<String> equipo2;
    private javax.swing.JComboBox<String> golAmarillaRoja;
    private javax.swing.JComboBox<String> grupo_clasificatoria;
    private javax.swing.JComboBox<String> hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jugadorEntraCambio;
    private javax.swing.JTextField jugadorGAR;
    private javax.swing.JTextField jugadorSaleCambio;
    private javax.swing.JComboBox<String> jugaronTiemposExtras;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JTextField minCambio;
    private javax.swing.JTextField minGAR;
    private javax.swing.JComboBox<String> minutos;
    private javax.swing.JComboBox<String> nombreEstadio;
    public static javax.swing.JLabel numero_partido;
    private javax.swing.JComboBox<String> primerTiempoR;
    private javax.swing.JTextField quintoArbitro;
    private javax.swing.JButton salir;
    private javax.swing.JTextField segCambio;
    private javax.swing.JTextField segGAR;
    private javax.swing.JComboBox<String> segundoTiempoR;
    private javax.swing.JTable tablaAlbitros;
    private javax.swing.JTable tabla_Jugadores1;
    private javax.swing.JTable tabla_Jugadores_equipo2;
    private javax.swing.JComboBox<String> tiraronPenales;
    // End of variables declaration//GEN-END:variables
}
