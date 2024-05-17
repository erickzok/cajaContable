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
public class Pago {
    int idPago;
    Date FechaMontoGastado;
    float MontoGastado;
    byte[] Voucher;
    String Comentario;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFechaMontoGastado() {
        return FechaMontoGastado;
    }

    public void setFechaMontoGastado(Date FechaMontoGastado) {
        this.FechaMontoGastado = FechaMontoGastado;
    }

    public float getMontoGastado() {
        return MontoGastado;
    }

    public void setMontoGastado(float MontoGastado) {
        this.MontoGastado = MontoGastado;
    }

    public byte[] getVoucher() {
        return Voucher;
    }

    public void setVoucher(byte[] Voucher) {
        this.Voucher = Voucher;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }
    
    
    
}
