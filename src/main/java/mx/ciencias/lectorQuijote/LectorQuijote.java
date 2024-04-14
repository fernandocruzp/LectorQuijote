package mx.ciencias.lectorQuijote;
import java.util.HashMap;
import mx.ciencias.ArbolRojinegro;
import mx.ciencias.*;
import java.io.BufferedReader;
import java.io.FileReader;


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
	catch(Exception E){
	    System.out.println(E);
	}
	System.out.println("Número de palabtras diferentes: "+ diccionario.size());
	arbol.dfsInOrder(new  AccionVerticeArbolBinario<String>(){
		 @Override
		 public void actua(VerticeArbolBinario<String> vertice){
		     System.out.println(vertice.get() + ": " + diccionario.get(vertice.get()));
		 }
	    });
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
