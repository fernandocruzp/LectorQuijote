package mx.ciencias.lectorQuijote;
import java.util.HashMap;
import mx.ciencias.ArbolRojinegro;
import mx.ciencias.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LectorQuijote{

    public static void main(String args[]){
	if(args.length == 0){
	    System.out.println("Introduzca un archivo a leer");
	    System.exit(0);
	}

	ArbolRojinegro arbol= new ArbolRojinegro();
	HashMap <String, Integer> diccionario= new HashMap<String,Integer>();
	try{
	BufferedReader lectura = new BufferedReader(new FileReader(args[0]));
	String linea="";
	while((linea=lectura.readLine()) != null){
	    analizaLinea(linea,arbol,diccionario);
	}
	lectura.close();
	}
	catch(IOException e){
	    e.printStackTrace(); 
            System.exit(1);
	}
	try{
	    FileWriter writer = new FileWriter("Resultado.txt");
	    writer.write("Número de palabtras diferentes: "+ diccionario.size() + "\n");
	    arbol.dfsInOrder(new  AccionVerticeArbolBinario<String>(){
		 @Override
		 public void actua(VerticeArbolBinario<String> vertice){
		     try{
			 writer.write(vertice.get() + ": " + diccionario.get(vertice.get()) + "\n");
			 
		     } catch(IOException e){
			 e.printStackTrace();
			 System.exit(1);
		     }
		 }
	    });
	    writer.close();
	    System.out.println("Lista escrita en Resultado.txt");
	} catch(IOException e){
	    e.printStackTrace();
            System.exit(1);
	}
    }

    private static void analizaLinea(String linea, ArbolRojinegro arbol, HashMap<String,Integer> dicc){
	String[] lista = linea.split("\\W+");
	for (String s: lista){
	    if(s.equals("") ||s.equals("\n") || s.equals(" ") || isNumeric(s)){
		//System.out.println(s);
		continue;
	    }
	    Integer num= dicc.get(s.toLowerCase());
	    if(num==null){
		arbol.agrega(s.toLowerCase());
		dicc.put(s.toLowerCase(),1);
	    }
	    else
		dicc.replace(s.toLowerCase(),num+1);
	}
    }
    public static boolean isNumeric(String str) { 
	try {  
	    Double.parseDouble(str);  
	    return true;
	} catch(NumberFormatException e){  
	    return false;  
	}  
    }

}
