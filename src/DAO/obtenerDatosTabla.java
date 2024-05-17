/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidades.Categoria;
import java.sql.Statement;
import Entidades.Conectar;
import Entidades.Pago;
import Entidades.Solicitud;
import VO.vo_tabla_1;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
/**
 *
 * @author Erick
 */
public class obtenerDatosTabla {
    public ArrayList<vo_tabla_1> ListarSolicitudes(int idPersona) {
    ArrayList<vo_tabla_1> list = new ArrayList<>();
    Conectar conec = new Conectar();
    String sql = "SELECT s.idSolicitud, p.NombrePersona, s.ConceptoSolicitud, s.fechaSolicitud, s.MontoEntregado, s.EstadoSolicitud " +
                 "FROM Solicitud s " +
                 "INNER JOIN Persona p ON s.idPersona = p.idPersona ORDER BY s.EstadoSolicitud";
    ResultSet rs = null;
    PreparedStatement ps = null;
    try {
        ps = conec.getConnection().prepareStatement(sql);
        //ps.setInt(1, idPersona);
        rs = ps.executeQuery();
        while (rs.next()) {
            vo_tabla_1 vo = new vo_tabla_1();
            vo.setId(rs.getInt(1));
            vo.setNombrePersona(rs.getString(2));
            vo.setDescripcionSolicitud(rs.getString(3));
            vo.setFechaSolicitud(rs.getDate(4));
            vo.setMontoSolicitado(rs.getFloat(5));
            vo.setEstadoSolicitud(rs.getInt(6));
            list.add(vo);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return list;
}

    //PRUEBA 1----------------------
    
    
    public String obtenerNombreCategoriaPorId(int idCategoria) {
    String nombreCategoria = null;
    Conectar conec = new Conectar();
    String sql = "SELECT nombreCategoria FROM Categoria WHERE idCategoria = ?";
    
    try (PreparedStatement ps = conec.getConnection().prepareStatement(sql)) {
        ps.setInt(1, idCategoria);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                nombreCategoria = rs.getString("nombreCategoria");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conec.desconectar();
    }
    
    return nombreCategoria;
}

public Pago obtenerDatosPagoPorIdSolicitud(int idSolicitud) {
    Pago pago = null;
    Conectar conec = new Conectar();
    String sql = "SELECT * FROM Pago WHERE idPago = (SELECT idPago FROM Solicitud WHERE idSolicitud = ?)";
    
    try (PreparedStatement ps = conec.getConnection().prepareStatement(sql)) {
        ps.setInt(1, idSolicitud);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                pago = new Pago();
                pago.setIdPago(rs.getInt("idPago"));
                pago.setFechaMontoGastado(rs.getDate("FechaMontoGastado"));
                pago.setMontoGastado(rs.getFloat("MontoGastado"));
                pago.setVoucher(rs.getBytes("Voucher"));
                pago.setComentario(rs.getString("Comentario"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conec.desconectar();
    }
    
    return pago;
}

public Solicitud obtenerDatosSolicitud(int idSolicitud) {
    Solicitud solicitud = null;
    Conectar conec = new Conectar();
    String sql = "SELECT * FROM Solicitud WHERE idSolicitud = ?";
    
    try (PreparedStatement ps = conec.getConnection().prepareStatement(sql)) {
        ps.setInt(1, idSolicitud);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                solicitud = new Solicitud();
                solicitud.setIdSolicitud(rs.getInt("idSolicitud"));
                solicitud.setFechaSolicitud(rs.getDate("fechaSolicitud"));
                solicitud.setConceptoSolicitud(rs.getString("ConceptoSolicitud"));
                solicitud.setEstadoSolicitud(rs.getInt("EstadoSolicitud"));
                System.out.println(rs.getString("Obra"));
                solicitud.setObra(rs.getString("Obra"));
                solicitud.setSustento(rs.getString("Sustento"));
                solicitud.setMontoEntregado(rs.getFloat("MontoEntregado"));
                solicitud.setIdPago(rs.getInt("idPago"));
                solicitud.setIdPersona(rs.getInt("idPersona"));
                solicitud.setIdCategoria(rs.getInt("idCategoria"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conec.desconectar();
    }
    
    return solicitud;
}

public Categoria obtenerDatosCategoria(int idCategoria) {
    Categoria categoria = null;
    Conectar conec = new Conectar();
    String sql = "SELECT * FROM Categoria WHERE idCategoria = ?";
    
    try (PreparedStatement ps = conec.getConnection().prepareStatement(sql)) {
        ps.setInt(1, idCategoria);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombreProducto(rs.getString("nombreProducto"));
                categoria.setDescripción(rs.getString("Descripción"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conec.desconectar();
    }
    
    return categoria;
}

    
    //PRUEBA--------------------------
    public Solicitud obtenerDatosSolicitud2(int id) {
    Solicitud solicitud = new Solicitud();
    Conectar conec = new Conectar();
    
    String sql = "SELECT s.idSolicitud, s.fechaSolicitud, s.ConceptoSolicitud, s.EstadoSolicitud, s.Obra, s.Sustento, s.MontoEntregado, s.idPago, p.NombrePersona, c.NombreCategoria " +
                 "FROM Solicitud s " +
                 "INNER JOIN Persona p ON s.idPersona = p.idPersona " +
                 "INNER JOIN Categoria c ON s.idCategoria = c.idCategoria " +
                 "WHERE s.idSolicitud = ?";
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        ps = conec.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            solicitud.setIdSolicitud(rs.getInt("idSolicitud"));
            solicitud.setFechaSolicitud(rs.getDate("fechaSolicitud"));
            solicitud.setConceptoSolicitud(rs.getString("ConceptoSolicitud"));
            solicitud.setEstadoSolicitud(rs.getInt("EstadoSolicitud"));
            solicitud.setObra(rs.getString("Obra"));
            solicitud.setSustento(rs.getString("Sustento"));
            solicitud.setMontoEntregado(rs.getFloat("MontoEntregado"));
            solicitud.setIdPago(rs.getInt("idPago"));
            solicitud.setIdPersona(rs.getInt("NombrePersona"));
            solicitud.setIdCategoria(rs.getInt("NombreCategoria"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    return solicitud;
}
public Pago obtenerDatosPago(int idSolicitud) {
    Pago pago = new Pago();
    Conectar conec = new Conectar();
    String sql = "SELECT idPago, FechaMontoGastado, MontoGastado, Voucher, Comentario "
            + "FROM Pago "
            + "WHERE idPago = (SELECT idPago FROM Solicitud WHERE idSolicitud = ?)";
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = conec.getConnection().prepareStatement(sql);
        ps.setInt(1, idSolicitud);
        rs = ps.executeQuery();

        if (rs.next()) {
            pago.setIdPago(rs.getInt("idPago"));
            pago.setFechaMontoGastado(rs.getDate("FechaMontoGastado"));
            pago.setMontoGastado(rs.getFloat("MontoGastado"));
            pago.setVoucher(rs.getBytes("Voucher"));
            pago.setComentario(rs.getString("Comentario"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    return pago;
}

public void insertarNuevoPago(int idSolicitud, Pago pago) {
    Conectar conec = new Conectar();
    String sql = "INSERT INTO Pago (MontoGastado, Voucher, Comentario) VALUES (?, ?, ?)";
    PreparedStatement ps = null;

    try {
        ps = conec.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setFloat(1, pago.getMontoGastado());
        ps.setBytes(2, pago.getVoucher());
        ps.setString(3, pago.getComentario());

        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idPago = generatedKeys.getInt(1);
                // Asociar el nuevo idPago a la solicitud
                asociarPagoASolicitud(idSolicitud, idPago);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

private void asociarPagoASolicitud(int idSolicitud, int idPago) {
    Conectar conec = new Conectar();
    String sql = "UPDATE Solicitud SET idPago = ? WHERE idSolicitud = ?";
    PreparedStatement ps = null;

    try {
        ps = conec.getConnection().prepareStatement(sql);
        ps.setInt(1, idPago);
        ps.setInt(2, idSolicitud);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

public void agregarMontoYComentarioAPago(int idSolicitud, float montoGastado, String comentario) {
    Conectar conec = new Conectar();
    String sql = "UPDATE Pago SET MontoGastado = ?, Comentario = ? WHERE idPago = (SELECT idPago FROM Solicitud WHERE idSolicitud = ?)";
    PreparedStatement ps = null;

    try {
        ps = conec.getConnection().prepareStatement(sql);
        ps.setFloat(1, montoGastado);
        ps.setString(2, comentario);
        ps.setInt(3, idSolicitud);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

public int obtenerIdPagoPorSolicitud(int idSolicitud) {
    int idPago = -1;
    Conectar conec = new Conectar();
    String sql = "SELECT idPago FROM Solicitud WHERE idSolicitud = ?";
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = conec.getConnection().prepareStatement(sql);
        ps.setInt(1, idSolicitud);
        rs = ps.executeQuery();

        if (rs.next()) {
            idPago = rs.getInt("idPago");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    return idPago;
}

public void modificarEstadoSolicitud(int idSolicitud, int nuevoEstado) {
    Conectar conec = new Conectar();
    String sql = "UPDATE Solicitud SET EstadoSolicitud = ? WHERE idSolicitud = ?";
    PreparedStatement ps = null;

    try {
        ps = conec.getConnection().prepareStatement(sql);
        ps.setInt(1, nuevoEstado);
        ps.setInt(2, idSolicitud);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            conec.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

public double[] obtenerMontosGastadosPorMes() {
    double[] montosPorMes = new double[12]; // 12 meses
    Conectar conec = new Conectar();
    int añoActual = LocalDate.now().getYear();

    // Query para obtener los montos gastados por mes del año actual
    String sql = "SELECT MONTH(FechaMontoGastado) AS Mes, SUM(MontoGastado) AS Total " +
                 "FROM Pago " +
                 "WHERE YEAR(FechaMontoGastado) = ? " +
                 "GROUP BY MONTH(FechaMontoGastado)";

    try {
        // Preparar la consulta SQL
        PreparedStatement stmt = conec.getConnection().prepareStatement(sql);
        stmt.setInt(1, añoActual);
        ResultSet rs = stmt.executeQuery();

        // Inicializar todos los montos a cero
        for (int i = 0; i < montosPorMes.length; i++) {
            montosPorMes[i] = 0.0;
        }

        // Llenar los montos por mes con los datos obtenidos de la base de datos
        while (rs.next()) {
            int mes = rs.getInt("Mes");
            double total = rs.getDouble("Total");
            montosPorMes[mes - 1] = total; // El mes comienza en 1, pero los índices del array en 0
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conec.desconectar();
    }

    // Crear un nuevo array que contenga los montos por mes con los nombres de los meses en español
    double[] montosPorMesEspañol = new double[12];
    for (int i = 0; i < montosPorMes.length; i++) {
        montosPorMesEspañol[i] = montosPorMes[i];
    }

    return montosPorMesEspañol;
}


public Map<String, Integer> obtenerNumeroSolicitudesPorMes() {
    Map<String, Integer> solicitudesPorMes = new HashMap<>();
    Conectar conec = new Conectar();

    String sql = "SELECT MONTH(fechaSolicitud) AS Mes, COUNT(*) AS NumSolicitudes " +
                 "FROM Solicitud " +
                 "WHERE YEAR(fechaSolicitud) = ? " +
                 "GROUP BY MONTH(fechaSolicitud)";

    try {
        PreparedStatement ps = conec.getConnection().prepareStatement(sql);
        ps.setInt(1, LocalDate.now().getYear());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int mes = rs.getInt("Mes");
            int numSolicitudes = rs.getInt("NumSolicitudes");
            solicitudesPorMes.put(obtenerNombreMes(mes), numSolicitudes);
        }

        rs.close();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conec.desconectar();
    }

    return solicitudesPorMes;
}

private String obtenerNombreMes(int numeroMes) {
    switch (numeroMes) {
        case 1: return "Enero";
        case 2: return "Febrero";
        case 3: return "Marzo";
        case 4: return "Abril";
        case 5: return "Mayo";
        case 6: return "Junio";
        case 7: return "Julio";
        case 8: return "Agosto";
        case 9: return "Septiembre";
        case 10: return "Octubre";
        case 11: return "Noviembre";
        case 12: return "Diciembre";
        default: return "Mes no válido";
    }
}
public Object[] obtenerDatosCard() {
    // Inicializar el array para almacenar los resultados
    Object[] resultados = new Object[3];
    Conectar conec = new Conectar();
    Connection con = null;
    PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;

    try {
        con = conec.getConnection();

        // Consulta 1: Suma de montos gastados en el último mes
        String consulta1SQL = "SELECT SUM(MontoGastado) AS MontoTotalMes " +
                              "FROM Pago " +
                              "WHERE YEAR(FechaMontoGastado) = YEAR(CURDATE()) AND MONTH(FechaMontoGastado) = MONTH(CURDATE()) " +
                              "GROUP BY YEAR(FechaMontoGastado), MONTH(FechaMontoGastado) " +
                              "ORDER BY YEAR(FechaMontoGastado) DESC, MONTH(FechaMontoGastado) DESC " +
                              "LIMIT 1";
        ps1 = con.prepareStatement(consulta1SQL);
        rs1 = ps1.executeQuery();
        if (rs1.next()) {
            resultados[0] = rs1.getString("MontoTotalMes");
        }

        // Consulta 2: Gastos totales en el último año
        String consulta2SQL = "SELECT SUM(MontoGastado) AS MontoTotalUltimoAnio " +
                              "FROM Pago " +
                              "WHERE FechaMontoGastado >= ?";
        ps2 = con.prepareStatement(consulta2SQL);
        ps2.setDate(1, Date.valueOf(LocalDate.now().minusYears(1)));
        rs2 = ps2.executeQuery();
        if (rs2.next()) {
            resultados[1] = rs2.getString("MontoTotalUltimoAnio");
        }

        // Consulta 3: Cantidad de solicitudes con estado 0
        String consulta3SQL = "SELECT COUNT(*) AS CantidadSolicitudesEstado0 " +
                              "FROM Solicitud " +
                              "WHERE EstadoSolicitud = 0";
        ps3 = con.prepareStatement(consulta3SQL);
        rs3 = ps3.executeQuery();
        if (rs3.next()) {
            resultados[2] = rs3.getString("CantidadSolicitudesEstado0");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar los recursos
        try {
            if (rs1 != null) rs1.close();
            if (ps1 != null) ps1.close();
            if (rs2 != null) rs2.close();
            if (ps2 != null) ps2.close();
            if (rs3 != null) rs3.close();
            if (ps3 != null) ps3.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Devolver el array con los resultados
    return resultados;
}
}

