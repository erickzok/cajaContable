/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Erick
 */
public class Solicitud {
    int idSolicitud;
    Date fechaSolicitud;
    String ConceptoSolicitud;
    int EstadoSolicitud;
    String Obra;
    String Sustento;
    float MontoEntregado;
    int idPago;
    int idPersona;
    int idCategoria;

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getConceptoSolicitud() {
        return ConceptoSolicitud;
    }

    public void setConceptoSolicitud(String ConceptoSolicitud) {
        this.ConceptoSolicitud = ConceptoSolicitud;
    }

    public int getEstadoSolicitud() {
        return EstadoSolicitud;
    }

    public void setEstadoSolicitud(int EstadoSolicitud) {
        this.EstadoSolicitud = EstadoSolicitud;
    }

    public String getObra() {
        return Obra;
    }

    public void setObra(String Obra) {
        this.Obra = Obra;
    }

    public String getSustento() {
        return Sustento;
    }

    public void setSustento(String Sustento) {
        this.Sustento = Sustento;
    }

    public float getMontoEntregado() {
        return MontoEntregado;
    }

    public void setMontoEntregado(float MontoEntregado) {
        this.MontoEntregado = MontoEntregado;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int Persona) {
        this.idPersona = Persona;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int Categoria) {
        this.idCategoria = Categoria;
    }

  
    
}
