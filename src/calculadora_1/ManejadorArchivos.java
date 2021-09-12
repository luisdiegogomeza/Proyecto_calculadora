package calculadora_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class ManejadorArchivos {
    public void grabar(String nombre_archivo,String info,String signo)
    {
        try
        {
            //especifica el path y el nombre de archivo
            File file=new File(nombre_archivo+".txt");
            /*si el archivo no existe, se crea*/
            if(!file.exists())
            {
                file.createNewFile();
            }
            //en esta linea, le mandamos por parametro si existe el archivo,lo agreaga
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            
            switch(signo.charAt(0)){
                
                case '+':
                    bw.write("Suma: "+info+"\n");
                    break;
                    
                case '-':
                bw.write("Resta: "+info+"\n");
                break;
                
                case '*':
                    bw.write("Multiplicacion: "+info+"\n");
                    break;
                    
                case '/':
                    bw.write("Division: "+info+"\n");
                    break;    
                
                
                default:
                    bw.write("Nuevo: "+info+"\n");
                    break;
            }
            bw.close();
            
        }catch(IOException ioe)
        {
            System.out.println("no se ha opodido escribir en el archivo");
        }
    }
    
   
     
     public  ArrayList<String> lectura(String nombre_archivo)
     {
         ArrayList<String> Retorno=new ArrayList<String>();
         try
         {
             BufferedReader bf=new BufferedReader(new FileReader(nombre_archivo+".txt"));
             String linea="";
             while(linea!=null)
             {
                 linea=bf.readLine();
                 
                 if(linea!=null)
                 {
                     Retorno.add(linea);
                 }
                 
             }
             bf.close();
         }catch(FileNotFoundException e){
             System.out.println("No se encuentra el fichero");
         }catch(IOException e){
             return Retorno;
         }
         return Retorno;
     }
     
     
}
