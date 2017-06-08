/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class Pedido {

    private int numero;
    private String[] detalle;
    private int detalleNum;
    private String[] estados;
    private String[] encabezado;

    public Pedido(){
        this.numero     = 0;
        this.detalle    = new String[10];
        this.estados    = new String[3];
        this.encabezado = new String[4];
    }

    public int nuevoNumero(){
        BufferedReader pedidoArchR;
        BufferedWriter pedidoArch;
        try{
            pedidoArchR = new BufferedReader(new FileReader("pedidoNumero.txt")); // Lee el archivo
            this.numero = (Integer.parseInt(pedidoArchR.readLine()))+1;
            pedidoArchR.close();
            pedidoArch = new BufferedWriter(new FileWriter("pedidoNumero.txt")); // Guarda el nuevo registro
            pedidoArch.write(Integer.toString(this.numero));
            pedidoArch.flush();
            pedidoArch.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }
        return this.numero;
    }

    public int siguienteNumero(){
        BufferedReader pedidoArchR;
        try{
            pedidoArchR = new BufferedReader(new FileReader("pedidoNumero.txt")); // Lee el archivo
            this.numero = (Integer.parseInt(pedidoArchR.readLine()))+1;
            pedidoArchR.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }
        return this.numero;
    }


    public void guardarEncabezado(String nombre,String direccion,String telefono,String nit){
        BufferedWriter pedidoArch;
        String registro;
        try {
            pedidoArch  = new BufferedWriter(new FileWriter("pedidoEncabezado.txt",true));
            //Timestamp ts = new Timestamp((long) Spinnerfecha.getValue());
            registro = this.numero+"|"+nombre+"|"+direccion+"|"+telefono+"|"+nit;
            pedidoArch.write(registro);
            pedidoArch.newLine();
            pedidoArch.flush();
            pedidoArch.close();
        } catch (IOException ex) {
            // Nop
        }
    }

    public int agregarDetalle(String cant,String codigo,String producto,String preciou,String total){
        this.detalle[this.detalleNum] = "|"+cant+"|"+codigo+"|"+producto+"|"+preciou+"|"+total;
        this.detalleNum++;
        return this.detalleNum;
    }

    public void guardarDetalle(){
        BufferedWriter pedidoArch;
        try {
            pedidoArch  = new BufferedWriter(new FileWriter("pedidoDetalle.txt",true));
            for(int i = 0; i < this.detalleNum; i++){
                pedidoArch.write(this.numero+this.detalle[i]);
                pedidoArch.newLine();
            }
            pedidoArch.flush();
            pedidoArch.close();
        } catch (IOException ex) {
            // Nop
        }
    }

    public void crearEnvio(){
        BufferedWriter pedidoArch;
        try {
            pedidoArch = new BufferedWriter(new FileWriter("envioDetalle.txt",true));
            pedidoArch.write(this.numero+"|"+(new Date()).getTime() +"|iniciado");
            pedidoArch.newLine();
            pedidoArch.flush();
            pedidoArch.close();
        } catch (IOException ex) {
            // Nop
        }
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getEstadoEnvios(){
        String linea;
        String[] registro = new String[3];
        String numero     = String.valueOf(this.numero);
        int posicion      = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader("envioDetalle.txt"));
            while ( (linea = br.readLine() ) != null) {
                registro = linea.split("\\|");
                if( numero.compareTo(registro[0]) == 0 ){
                    SimpleDateFormat sdfecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    this.estados[posicion]   = sdfecha.format(new Date( Long.parseLong(registro[1]) ));
                    posicion++;
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }
        return posicion;
    }

    public String getEstado(int estado){
        return this.estados[estado];
    }

    public void modificarEnvio(int estado){
        String registro = "";
        try {
            BufferedWriter pedidoArch = new BufferedWriter(new FileWriter("envioDetalle.txt",true));
            if(estado == 2){
                registro   = this.numero+"|"+(new Date()).getTime() +"|enviado";
            }else if(estado == 3){
                registro   = this.numero+"|"+(new Date()).getTime() +"|entregado";
            }
            pedidoArch.write(registro);
            pedidoArch.newLine();
            pedidoArch.flush();
            pedidoArch.close();
        } catch (IOException ex) {
            // Nop
        }

    }

    public int getDetalle(){
        String linea;
        String[] registro = new String[6];
        String numero     = String.valueOf(this.numero);
        int numLinea = 1;

        try{
            BufferedReader pedidoArchR = new BufferedReader(new FileReader("pedidoDetalle.txt")); // Lee el archivo
            while((linea = pedidoArchR.readLine())!=null){
                registro = linea.split("\\|");
                if( numero.compareTo(registro[0]) == 0 ){
                    this.detalle[this.detalleNum] = "|"+registro[1]+"|"+registro[2]+"|"+registro[3]+"|"+registro[4]+"|"+registro[5];
                    this.detalleNum++;
                }
            }
            pedidoArchR.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }
        return this.detalleNum;
    }

    public String getDetalleParte(int linea,int campo){
        String[] registro = new String[6];
        registro = this.detalle[linea].split("\\|");
        return registro[campo];
    }

    public void nuevoDetalleDevolucion(int[] registros){
        String[] nuevo = new String[10];
        int nuevoNum   = 0;
        for(int i = 0;i < this.detalleNum;i++){
            if(registros[i] == 1){
                nuevo[nuevoNum] = this.detalle[i];
                nuevoNum++;
            }
        }
        this.detalle    = nuevo;
        this.detalleNum = nuevoNum;
    }

    public void getEncabezado(){
        String linea;
        String[] registro = new String[5];
        String numero     = String.valueOf(this.numero);
        try{
            BufferedReader br = new BufferedReader(new FileReader("pedidoEncabezado.txt"));
            while ( (linea = br.readLine() ) != null) {
                registro = linea.split("\\|");
                if( numero.compareTo(registro[0]) == 0 ){
                    this.encabezado[0] = registro[1];
                    this.encabezado[1] = registro[2];
                    this.encabezado[2] = registro[3];
                    this.encabezado[3] = registro[4];
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }
    }

    public String getEncabezadoPart(int i){
        return this.encabezado[i];
    }

}
