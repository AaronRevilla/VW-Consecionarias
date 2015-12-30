package vwObjects;

public class WebPageConsecionaria {

	
	public String htmlPagina;
	public String urlConsecionaria;
	public String targetUrl;
	
	public WebPageConsecionaria(String html){
		this.htmlPagina = html;
	}
	
	public WebPageConsecionaria(String html, String urlConsecionaria, String targetUrl){
		this.htmlPagina = html;
		this.urlConsecionaria = urlConsecionaria;
		this.targetUrl = targetUrl;
	}
	
	public String getHtmlPagina() {
		return htmlPagina;
	}

	public void setHtmlPagina(String htmlPagina) {
		this.htmlPagina = htmlPagina;
	}

	public String getUrlConsecionaria() {
		return urlConsecionaria;
	}

	public void setUrlConsecionaria(String urlConsecionaria) {
		this.urlConsecionaria = urlConsecionaria;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	
	
}
