/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoOctoberEatsApp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maik
 */
public class MenuItem {
    private List<MenuItem> items;
    
    public MenuItem() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(MenuItem item) {
        items.add(item);
    }

    public void eliminarItem(MenuItem item) {
        items.remove(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }
    
    
    
}
