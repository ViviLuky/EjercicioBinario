package ejercicio01binario;

import java.io.*;
import java.text.NumberFormat;

public class Main {
    private static File registros;
    private static int cargos;
    private static int abonos;

    static {
        registros=new File("registro.dat");
        cargos=0;
        abonos=0;
    }
    public static void main(String[] args) {
        crearFicheroContable();
        int saldo=0;
        saldo= leerRegistroContable(saldo);
        NumberFormat numberFormat=NumberFormat.getCurrencyInstance();
        System.out.printf("Tusaldo es de %s%n",numberFormat.format(saldo));

    }

    private static int leerRegistroContable(int saldo) {
        FileInputStream fis=null;
        try{
            fis=new FileInputStream(registros);
            DataInputStream dis =new DataInputStream(fis);
            while (true){
                saldo+= dis.readInt();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void crearFicheroContable() {

        FileOutputStream fos = null;

        try{
            fos=new FileOutputStream(registros,true);
            DataOutputStream dos= new DataOutputStream(fos);

            for (int i = 0; i < 1000; i++) {
                int x = (int)(Math.random()+1500);
                if(i%2==0)
                    x*=-1;
                dos.writeInt(x);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 1000; i++) {
            int x = (int)(Math.random()+1500);
            if(i%2==0)
                x*=-1;

        }
    }
}
