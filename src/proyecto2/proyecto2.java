/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import sun.net.www.content.text.plain;

public class proyecto2 extends javax.swing.JFrame {

    /**
     * Creates new form proyecto2
     */
    public proyecto2() {

        Action action;
        action = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){

                TableCellListener tcl = (TableCellListener)e.getSource();
                int cantidad;
                int fila = tcl.getRow();
                String[] registro = new String[6];
                String linea;
                String cantidadS;
                String valorS;

                if( tcl.getOldValue() != tcl.getNewValue() ) { // Si hay cambio
                    if ( tcl.getColumn() == 0 ) { // Cantidad

                        valorS = (String) jTable1.getValueAt(fila, 3);
                        if (valorS!=null ) {
                            cantidadS = (String) jTable1.getValueAt(fila,0);
                            cantidad  = Integer.parseInt(cantidadS);
                            jTable1.setValueAt(Double.parseDouble(valorS) * cantidad,fila,4); // Total
                        }

                    } else if ( tcl.getColumn() == 1 ) { // Codigo de producto

                        Producto producto = new Producto();
                        cantidadS = (String) jTable1.getValueAt(fila,0);
                        linea     = producto.buscarProducto((String) tcl.getNewValue());
                        registro  = linea.split("\\|");
                        jTable1.setValueAt(registro[1],fila,2); // Producto nombre
                        jTable1.setValueAt(registro[3],fila,3); // Precio U
                        if ( "".equals(cantidadS) || (cantidadS == null) ) {
                            cantidad = 1;
                            jTable1.setValueAt(String.valueOf(cantidad), fila, 0);
                        } else {
                            cantidad = Integer.parseInt(cantidadS);
                        }
                        jTable1.setValueAt(Double.toString(Double.parseDouble(registro[3]) * cantidad),fila,4); // Total

                    }
                }

            }

        };

        initComponents();
        TableCellListener tcl = new TableCellListener(jTable1, action);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fArticulos = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tACodigoM = new javax.swing.JTextField();
        tADescripcionM = new javax.swing.JTextField();
        tACostoM = new javax.swing.JTextField();
        tAPrecioM = new javax.swing.JTextField();
        tACantidadM = new javax.swing.JTextField();
        tATipoM = new javax.swing.JComboBox<>();
        bGuardarMercaderia = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fPedidos = new javax.swing.JFrame();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tPnombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tPdireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tPtelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tPnit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        generarPedido = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Labelnumpedido = new javax.swing.JLabel();
        bArticulos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        fArticulos.setMaximumSize(new java.awt.Dimension(396, 350));
        fArticulos.setMinimumSize(new java.awt.Dimension(396, 350));
        fArticulos.setPreferredSize(new java.awt.Dimension(396, 350));

        jLabel1.setText("Ingreso de mercaderia");

        jLabel2.setText("Codigo");

        jLabel3.setText("Descripción");

        jLabel4.setText("Costo");

        jLabel5.setText("Precio");

        jLabel6.setText("Tipo");

        jLabel7.setText("Cantidad");

        tATipoM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ropa dama", "Ropa caballero", "Ropa niños", "Accesorio deportivo", "Joyeria" }));
        tATipoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tATipoMActionPerformed(evt);
            }
        });

        bGuardarMercaderia.setText("Guardar");
        bGuardarMercaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarMercaderiaActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fArticulosLayout = new javax.swing.GroupLayout(fArticulos.getContentPane());
        fArticulos.getContentPane().setLayout(fArticulosLayout);
        fArticulosLayout.setHorizontalGroup(
            fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(fArticulosLayout.createSequentialGroup()
                        .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tACodigoM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tADescripcionM, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(fArticulosLayout.createSequentialGroup()
                        .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jButton2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(1, 1, 1)
                        .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tACantidadM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tATipoM, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fArticulosLayout.createSequentialGroup()
                                .addComponent(tACostoM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tAPrecioM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bGuardarMercaderia, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        fArticulosLayout.setVerticalGroup(
            fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tACodigoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tADescripcionM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tACostoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tAPrecioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tATipoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tACantidadM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(bGuardarMercaderia))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        fPedidos.setMaximumSize(new java.awt.Dimension(560, 475));
        fPedidos.setMinimumSize(new java.awt.Dimension(560, 475));
        fPedidos.setPreferredSize(new java.awt.Dimension(560, 475));

        jLabel8.setText("Pedidos");

        jLabel9.setText("Numero");

        jLabel10.setText("Nombre");

        jLabel11.setText("Dirección");

        jLabel12.setText("Teléfono");

        jLabel13.setText("NIT");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Código", "Producto", "Precio U", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        generarPedido.setText("Generar pedido");
        generarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarPedidoActionPerformed(evt);
            }
        });

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Labelnumpedido.setText("num");

        javax.swing.GroupLayout fPedidosLayout = new javax.swing.GroupLayout(fPedidos.getContentPane());
        fPedidos.getContentPane().setLayout(fPedidosLayout);
        fPedidosLayout.setHorizontalGroup(
            fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPedidosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Labelnumpedido)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPedidosLayout.createSequentialGroup()
                        .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tPdireccion)
                            .addComponent(tPnombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPedidosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tPtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tPnit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPedidosLayout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPedidosLayout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(generarPedido)))))
                .addContainerGap())
        );
        fPedidosLayout.setVerticalGroup(
            fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(Labelnumpedido))
                .addGap(18, 18, 18)
                .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tPnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tPdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tPtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tPnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generarPedido)
                    .addComponent(jButton4))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bArticulos.setText("Mercadería");
        bArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bArticulosActionPerformed(evt);
            }
        });

        jButton1.setText("Pedidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(bArticulos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bArticulosActionPerformed
        this.setVisible(false);
        fArticulos.setVisible(true);
    }//GEN-LAST:event_bArticulosActionPerformed


    public int actualizarMercaderiaLista(int fila){
        int cantidad  = (int) jTable1.getValueAt(fila, 0);    // Cantidad);
        String codigo = (String) jTable1.getValueAt(fila, 1); // Codigo
        return 0;
    }

    private void bGuardarMercaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarMercaderiaActionPerformed
        String registro;
        Producto nuevo = new Producto();
        int resultado;

        resultado = nuevo.guardarMercaderia(
            tACodigoM.getText(),
            tADescripcionM.getText(),
            tACostoM.getText(),
            tAPrecioM.getText(),
            Integer.toString(tATipoM.getSelectedIndex()),
            tACantidadM.getText()
        );

        if( resultado == 1 ) {
            JOptionPane.showMessageDialog(rootPane, "El código ya existe");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Registro guardado");
        }

    }//GEN-LAST:event_bGuardarMercaderiaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fArticulos.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fPedidos.setVisible(true);
        BufferedReader pedidoArchR;
        int pedido=0;
        String linea;
        try{
            pedidoArchR = new BufferedReader(new FileReader("pedidoNumero.txt")); // Lee el archivo
            int c=0;
            while((linea = pedidoArchR.readLine())!=null){
                pedido = (Integer.parseInt(linea))+1;
                c=1;
            }
            if(c==0){
                pedido = 1;
            }
            pedidoArchR.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }
        Labelnumpedido.setText(Integer.toString(pedido));
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void generarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarPedidoActionPerformed

        String codigo, producto,preciou,total;
        String cant;
        String registro;
        String linea;
        int pedido = 0;
        BufferedReader pedidoArchR;
        BufferedWriter pedidoArch;

        // Obtener correlativo del pedido
        try{
            pedidoArchR = new BufferedReader(new FileReader("pedidoNumero.txt")); // Lee el archivo
            int c=0;
            while((linea = pedidoArchR.readLine())!=null){
                pedido = (Integer.parseInt(linea))+1;
                c=1;
            }
            if(c==0){
                pedido = 1;
            }
            pedidoArchR.close();
            pedidoArch = new BufferedWriter(new FileWriter("pedidoNumero.txt",true));  // Guarda el nuevo registro
            pedidoArch.write(Integer.toString(pedido));
            pedidoArch.newLine();
            pedidoArch.flush();
            pedidoArch.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }

        // Encabezado del pedido
        try {
            pedidoArch  = new BufferedWriter(new FileWriter("pedidoEncabezado.txt",true));
            registro = pedido+"|"+tPnombre.getText()+"|"+tPdireccion.getText()+"|"+tPtelefono.getText()+"|"+tPnit.getText();
            pedidoArch.write(registro);
            pedidoArch.newLine();
            pedidoArch.flush();
            pedidoArch.close();
        } catch (IOException ex) {
            // Nop
        }

        // Detalle del pedido
        try {
            pedidoArch  = new BufferedWriter(new FileWriter("pedidoDetalle.txt",true));
            for(int i = 0; i < 10; i++){
                cant   = (String) jTable1.getValueAt(i,0);
                codigo = (String) jTable1.getValueAt(i,1);
                producto = (String) jTable1.getValueAt(i,2);
                preciou = (String) jTable1.getValueAt(i,3);
                total = (String) jTable1.getValueAt(i,4);
                if ( ! "".equals(codigo) && (codigo != null) ) {
                    registro = pedido+"|"+cant+"|"+codigo+"|"+producto+"|"+preciou+"|"+total;
                    pedidoArch.write(registro);
                    pedidoArch.newLine();
                }
            }
            pedidoArch.flush();
            pedidoArch.close();
        } catch (IOException ex) {
            // Nop
        }

    }//GEN-LAST:event_generarPedidoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        fPedidos.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tATipoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tATipoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tATipoMActionPerformed



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(proyecto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proyecto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proyecto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proyecto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proyecto2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Labelnumpedido;
    private javax.swing.JButton bArticulos;
    private javax.swing.JButton bGuardarMercaderia;
    private javax.swing.JFrame fArticulos;
    private javax.swing.JFrame fPedidos;
    private javax.swing.JButton generarPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tACantidadM;
    private javax.swing.JTextField tACodigoM;
    private javax.swing.JTextField tACostoM;
    private javax.swing.JTextField tADescripcionM;
    private javax.swing.JTextField tAPrecioM;
    private javax.swing.JComboBox<String> tATipoM;
    private javax.swing.JTextField tPdireccion;
    private javax.swing.JTextField tPnit;
    private javax.swing.JTextField tPnombre;
    private javax.swing.JTextField tPtelefono;
    // End of variables declaration//GEN-END:variables
}


