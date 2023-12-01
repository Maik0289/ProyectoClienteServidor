/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;

import java.util.List;


/**
 *
 * @author Maik
 */
public class Pedido {
    private Usuario usuario;
    private Restaurante restaurante;
    private boolean confirmado;
    private List<MenuItem> items;

    public Pedido(Usuario usuario, Restaurante restaurante, boolean confirmado, List<MenuItem> items) {
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.confirmado = false;
        this.items = items;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
    
}
