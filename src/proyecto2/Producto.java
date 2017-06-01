package proyecto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Producto {

    private String nombreArchivo;

    public Producto(){
        this.nombreArchivo = "mercaderia.txt";
    }

    public String buscarProducto(String codigo){

        String[] registro = new String[6];
        String linea;

        try{
            BufferedReader br = new BufferedReader(new FileReader(this.nombreArchivo));
            while ( (linea = br.readLine() ) != null) {
                registro = linea.split("\\|");
                if(codigo.compareTo(registro[0]) == 0){
                    return linea;
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            // Nop
        } catch (IOException ex) {
            // Nop
        }
        return "";
    }

    public int guardarMercaderia(String codigo, String descripcion, String costo, String precio, String tipo, String cantidad){
        String registro;
        int resultado = 0; // Se pudo guardar

        if( this.buscarProducto(codigo).compareTo("") == 0 ) {
            registro = codigo + '|';
            registro+= descripcion + '|';
            registro+= costo + '|';
            registro+= precio + '|';
            registro+= tipo + '|';
            registro+= cantidad;

            try {
                BufferedWriter mercaderia  = new BufferedWriter(new FileWriter(this.nombreArchivo,true));
                mercaderia.write(registro);
                mercaderia.flush();
                mercaderia.close();
            } catch (IOException ex) {
                // Nop
            }
        } else {
            resultado = 1;
        }
        return resultado;
    }

}
