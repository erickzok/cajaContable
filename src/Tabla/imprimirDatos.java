/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabla;

import DAO.obtenerDatosTabla;
import VO.vo_tabla_1;
import com.raven.model.StatusType;
import com.raven.swing.Table;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick
 */
public class imprimirDatos {
    public ArrayList<Integer> visualizar_tabla_gastos(Table tabla) {
    ArrayList<Integer> idSolicitudes = new ArrayList<>();
    obtenerDatosTabla listaVO = new obtenerDatosTabla();
    ArrayList<vo_tabla_1> list = listaVO.ListarSolicitudes(2);

    if (list.size() > 0) {
        for (vo_tabla_1 vo : list) {
            Object fila[] = new Object[] {
                vo.getNombrePersona(),
                vo.getDescripcionSolicitud(),
                "S/ " + vo.getMontoSolicitado(),
                vo.getFechaSolicitud(),
                getStatusType(vo.getEstadoSolicitud())
            };

            tabla.addRow(fila);
            idSolicitudes.add(vo.getId()); // Añadir el ID de la solicitud al ArrayList
        }
    } else {
        JOptionPane.showMessageDialog(null, "¡Aviso: no hay gastos registrados!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    return idSolicitudes; // Devolver el ArrayList de IDs de las solicitudes
}


private StatusType getStatusType(int estado) {
    switch (estado) {
        
        case 0:
            return StatusType.ACEPTADO;
        case 1:
            return StatusType.FINALIZADO;
        default:
            return StatusType.ERROR; // Default to PENDIENTE if estado is not recognized
    }
}

}
