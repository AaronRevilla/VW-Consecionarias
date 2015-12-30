package logic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import vwObjects.Coche;
import vwObjects.Consecionaria;
import vwObjects.WebPageConsecionaria;
import web.WebRequest;

public class main {

	public static void main(String[] args){
		String targetURL = new String("http://www.concesionariosvw.mx/dealerLocator/jsonConces.aspx");
		String urlParameters = new String("");
		String peticion = WebRequest.excutePost(targetURL, urlParameters);
		//System.out.println(peticion);


		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		
		//OBTENER LAS CONSECIONARIAS A PARTIR DEL OBJETO JSON
		Consecionaria[] consecinoarias =  gson.fromJson(peticion, Consecionaria[].class);
		List<String> paginasConsecionarias = new ArrayList<String>();
		
		//AGREGAR LAS URL DE LAS CONSECIONARIAS Y METERLAS EN UNA LISTA
		for(Consecionaria consecinoaria: consecinoarias){
			//System.out.println(consecinoaria.getEdo() + " ---- " + consecinoaria.getUri());
			if(!consecinoaria.getUri().isEmpty()){
				if(!paginasConsecionarias.contains(consecinoaria.getUri())){
					paginasConsecionarias.add(consecinoaria.getUri());
				}
			}
		}
		
		List<WebPageConsecionaria> htmlConsecionarias = new ArrayList<WebPageConsecionaria>();
		Integer numMax = paginasConsecionarias.size();
		Integer idx = 0;
		//HACER PETICION DE LOS COCHES EN CADA PAGINA DE LAS CONCESIONARIAS
		for(String urlConsecionaria: paginasConsecionarias){
			++idx;
			System.out.println((idx) + " de " + numMax);
			//if(idx == 4){
				urlParameters = "/Seminuevos/Virtual/seminuevoslista.aspx?marcaID=&modeloID=&versionID=&anioI=&anioF=&pMinimo=&pMaximo=&m=&Certif=&b=&pageIndex=0";
				targetURL = urlConsecionaria + urlParameters;
				//System.out.println(targetURL);
				try{
					String paginaWebCoches = WebRequest.excutePost(targetURL, "");
					WebPageConsecionaria htmlCons = new WebPageConsecionaria(paginaWebCoches, urlConsecionaria, targetURL);
					htmlConsecionarias.add(htmlCons);
				}
				catch(Exception e){
					System.out.println(urlConsecionaria + "-----> no se pudo ingresar");				
				}
			//}
		}

		List<Coche> listaCoches = new ArrayList<Coche>();
		idx = 0;
		numMax = htmlConsecionarias.size();
		for(WebPageConsecionaria webConsecionaria: htmlConsecionarias){
			++idx;
			System.out.println("Procesando Consecionaria: " + webConsecionaria.getUrlConsecionaria() + " " + idx + " de " + numMax);
			//System.out.println(webConsecionaria.getHtmlPagina());
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Document doc;
			try {
				if(!webConsecionaria.getHtmlPagina().isEmpty()){
					doc = Jsoup.parse(webConsecionaria.getHtmlPagina());
					//System.out.println(doc.text());
					//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					Elements divIconos = doc.select(".tab.I_L");
					Elements tablaCoches = divIconos.select("table.item");
					//Si existen coches
					//System.out.println(tablaCoches.size());
					if(tablaCoches.size() > 0){
						for(Element tablaCoche: tablaCoches){
							Elements cocheHTML = tablaCoche.select("td>a");
							/*
							System.out.println("tam " + cocheHTML.size());
							System.out.println(cocheHTML.text());
							System.out.println(cocheHTML.get(1).text());
							System.out.println(cocheHTML.get(2).text());
							System.out.println(cocheHTML.get(3).text());
							System.out.println(cocheHTML.get(4).text());
							String precio = cocheHTML.get(5).text().replace("$", "");
							System.out.println(Double.parseDouble(precio.replace(",", "")));
							*/
							String kilometraje = cocheHTML.get(4).text().replace(",", "");
							String precio = cocheHTML.get(5).text().replace("$", "");
							Coche coche = new Coche();
							coche.setMarca(cocheHTML.get(1).text());
							coche.setModelo(cocheHTML.get(2).text());
							coche.setAnio(Integer.parseInt(cocheHTML.get(3).text()));
							coche.setKilometraje(Double.parseDouble(kilometraje));
							coche.setPrecio(Double.parseDouble(precio.replace(",", "")));
							coche.setUrlDetalles(webConsecionaria.getUrlConsecionaria() + cocheHTML.get(1).attr("href"));
							System.out.println(coche.toString());					
							listaCoches.add(coche);
						}
					}	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		System.out.println(listaCoches.size() + " numero total de coches");
		try {
			crearArchivoCoches(listaCoches);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public static void crearArchivoCoches(List<Coche> coches) throws IOException{
		PrintWriter writer = new PrintWriter("C:\\Users\\AlonsoINE\\Desktop\\coches.txt", "UTF-8");
		for(Coche coche: coches){
			writer.println(coche.toFile());
		}
		writer.close();
	}
	
}
