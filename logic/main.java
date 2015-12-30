package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
			//System.out.println((idx) + " de " + numMax);
			if(idx == 1){
				urlParameters = "/Seminuevos/Virtual/seminuevoslista.aspx?marcaID=&modeloID=&versionID=&anioI=&anioF=&pMinimo=&pMaximo=&m=&Certif=&b=&pageIndex=0";
				targetURL = urlConsecionaria + urlParameters;
				System.out.println(targetURL);
				try{
					String paginaWebCoches = WebRequest.excutePost(targetURL, "");
					WebPageConsecionaria htmlCons = new WebPageConsecionaria(paginaWebCoches);
					htmlConsecionarias.add(htmlCons);
				}
				catch(Exception e){
					System.out.println(urlConsecionaria + "-----> no se pudo ingresar");
					System.out.println(targetURL);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				}
			}
		}


		for(WebPageConsecionaria webConsecionaria: htmlConsecionarias){
			//System.out.println(webConsecionaria.getHtmlPagina());
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Document doc;
			doc = Jsoup.parse(webConsecionaria.getHtmlPagina());
			//System.out.println(doc.text());
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			Elements divIconos = doc.select(".tab.I");
			Elements tablaCoches = divIconos.select("table.item");
			//Si existen coches
			if(tablaCoches.size() > 0){
				
			}
		}
		
	}
	
}
