/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProyectoOctoberEatsApp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileSystem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class Dashboard extends javax.swing.JFrame {

    private Compras comprasInstance;

    private int puerto = 1234; 
    private String host = "localhost";

    /**
     * Creates new form Dashboard
     */
    public Dashboard(Compras compras) {
        initComponents();
        iniciarServidor();
        añadirMenuContextualAJTable();
        añadirMenuContextualAEnProceso();
        this.comprasInstance = compras;
    }

    private void iniciarServidor() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(puerto)) {
                while (true) {
                    try (Socket clientSocket = serverSocket.accept(); BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        String numeroCompra;
                        while ((numeroCompra = in.readLine()) != null) {
                            final String numeroCompraFinal = numeroCompra;
                            SwingUtilities.invokeLater(() -> agregarNumeroCompraATabla(numeroCompraFinal));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void agregarNumeroCompraATabla(String numeroCompra) {
        DefaultTableModel model = (DefaultTableModel) pedidosTable.getModel();
        model.addRow(new Object[]{numeroCompra});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Compras compras = new Compras();
            compras.setVisible(true);
            Dashboard dashboard = new Dashboard(compras); // Pasa la instancia de Compras al constructor
            dashboard.setVisible(true);
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pedidosTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidosTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pedidosTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        pedidosTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Total Pedidos");

        jLabel2.setText("Dashboard");

        pedidosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PedidoNum"
            }
        ));
        jScrollPane1.setViewportView(pedidosTable);

        jLabel3.setText("Pendiente");

        jLabel4.setText("En proceso");

        jLabel5.setText("Enviado");

        pedidosTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PedidoNum"
            }
        ));
        jScrollPane2.setViewportView(pedidosTable1);

        pedidosTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PedidoNum"
            }
        ));
        jScrollPane3.setViewportView(pedidosTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(pedidosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(143, 143, 143)))
                .addComponent(jLabel5)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int pedidosContador = 0; 

    private void actualizarPedidosTable(String numeroCompra) {
        SwingUtilities.invokeLater(() -> {
            DefaultTableModel model = (DefaultTableModel) pedidosTable.getModel();
            model.addRow(new Object[]{numeroCompra}); 
            pedidosContador++; 
            pedidosTotal.setText(Integer.toString(pedidosContador)); 
        });
    }

    private void añadirMenuContextualAJTable() {
        JPopupMenu menuContextual = new JPopupMenu();
        JMenuItem itemPendiente = new JMenuItem("En proceso");
        itemPendiente.addActionListener(e -> moverAEnProceso());
        menuContextual.add(itemPendiente);

        pedidosTable.setComponentPopupMenu(menuContextual);
        pedidosTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int fila = pedidosTable.rowAtPoint(e.getPoint());
                    pedidosTable.setRowSelectionInterval(fila, fila);
                }
            }
        });
    }

    private void añadirMenuContextualAEnProceso() {
        JPopupMenu menuContextual = new JPopupMenu();
        JMenuItem itemEnProceso = new JMenuItem("Enviado");
        itemEnProceso.addActionListener(e -> moverAEnviado());
        menuContextual.add(itemEnProceso);

        pedidosTable2.setComponentPopupMenu(menuContextual);
        pedidosTable2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int fila = pedidosTable2.rowAtPoint(e.getPoint());
                    pedidosTable2.setRowSelectionInterval(fila, fila);
                }
            }
        });
    }


    private void moverAEnProceso() {
        int filaSeleccionada = pedidosTable.getSelectedRow();
        if (filaSeleccionada >= 0) {
            DefaultTableModel modelPedidos = (DefaultTableModel) pedidosTable.getModel();
            DefaultTableModel modelEnProceso = (DefaultTableModel) pedidosTable2.getModel();

            
            Object pedido = modelPedidos.getValueAt(filaSeleccionada, 0);

           
            modelEnProceso.addRow(new Object[]{pedido});

           
            modelPedidos.removeRow(filaSeleccionada);
        }
        if (comprasInstance != null) {
            comprasInstance.setStatusLabelText("En proceso");
        }
    }

    private void moverAEnviado() {
        int filaSeleccionada = pedidosTable2.getSelectedRow();
        if (filaSeleccionada >= 0) {
            DefaultTableModel modelPedidos = (DefaultTableModel) pedidosTable2.getModel();
            DefaultTableModel modelEnProceso = (DefaultTableModel) pedidosTable1.getModel();

            
            Object pedido = modelPedidos.getValueAt(filaSeleccionada, 0);

           
            modelEnProceso.addRow(new Object[]{pedido});

            
            modelPedidos.removeRow(filaSeleccionada);
        }
        if (comprasInstance != null) {
            comprasInstance.setStatusLabelText("Enviado");
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable pedidosTable;
    private javax.swing.JTable pedidosTable1;
    private javax.swing.JTable pedidosTable2;
    private javax.swing.JLabel pedidosTotal;
    // End of variables declaration//GEN-END:variables
}
