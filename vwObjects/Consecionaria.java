package vwObjects;

import com.google.gson.annotations.SerializedName;

public class Consecionaria {

	 	@SerializedName("address")
		public String address;
	 	
	 	@SerializedName("autobody_and_paint_active")
		public boolean autobody_and_paint_active;
	 	
	 	@SerializedName("car_wash_active")
		public String car_wash_active;
	 	 
	 	@SerializedName("commercial_vehicles_active")
		public boolean commercial_vehicles_active;
	 	
	 	@SerializedName("contact_info")
		public String contact_info;
	 	
	 	@SerializedName("das_auto_active")
		public boolean das_auto_active;
	 	
	 	@SerializedName("direct_express_active")
		public boolean direct_express_active;
	 	
	 	@SerializedName("edo")
		public String edo;
	 	
	 	@SerializedName("id")
		public String id;
	 	
	 	@SerializedName("latitude")
		public double latitude;
	 	
	 	@SerializedName("longitude")
		public double longitude;
	 	
	 	@SerializedName("name")
		public String name;
	 	
	 	@SerializedName("num_dealer")
		public Integer num_dealer;
	 	
	 	@SerializedName("schedule")
		public String schedule;
	 	
	 	@SerializedName("touareg_hybrid_active")
		public boolean touareg_hybrid_active;
	 	
	 	@SerializedName("uri")
		public String uri;
	 	
	 	@SerializedName("url_citaServ")
		public String url_citaServ;
	 	
	 	@SerializedName("url_contacto")
		public String url_contacto;
	 	
	 	@SerializedName("url_facebook")
		public String url_facebook;
	 	
	 	@SerializedName("url_maps")
		public String url_maps;
	 	
	 	@SerializedName("x24hrs_active")
		public boolean x24hrs_active;
	 	
	 	@SerializedName("zip_code")
		public String zip_code;
		
		/*uri tiene la direccion de la pagina*/
		
		public Consecionaria(){
			
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public boolean isAutobody_and_paint_active() {
			return autobody_and_paint_active;
		}

		public void setAutobody_and_paint_active(boolean autobody_and_paint_active) {
			this.autobody_and_paint_active = autobody_and_paint_active;
		}

		public String getCar_wash_active() {
			return car_wash_active;
		}

		public void setCar_wash_active(String car_wash_active) {
			this.car_wash_active = car_wash_active;
		}

		public boolean isCommercial_vehicles_active() {
			return commercial_vehicles_active;
		}

		public void setCommercial_vehicles_active(boolean commercial_vehicles_active) {
			this.commercial_vehicles_active = commercial_vehicles_active;
		}

		public String getContact_info() {
			return contact_info;
		}

		public void setContact_info(String contact_info) {
			this.contact_info = contact_info;
		}

		public boolean isDas_auto_active() {
			return das_auto_active;
		}

		public void setDas_auto_active(boolean das_auto_active) {
			this.das_auto_active = das_auto_active;
		}

		public boolean isDirect_express_active() {
			return direct_express_active;
		}

		public void setDirect_express_active(boolean direct_express_active) {
			this.direct_express_active = direct_express_active;
		}

		public String getEdo() {
			return edo;
		}

		public void setEdo(String edo) {
			this.edo = edo;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getNum_dealer() {
			return num_dealer;
		}

		public void setNum_dealer(Integer num_dealer) {
			this.num_dealer = num_dealer;
		}

		public String getSchedule() {
			return schedule;
		}

		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}

		public boolean isTouareg_hybrid_active() {
			return touareg_hybrid_active;
		}

		public void setTouareg_hybrid_active(boolean touareg_hybrid_active) {
			this.touareg_hybrid_active = touareg_hybrid_active;
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getUrl_citaServ() {
			return url_citaServ;
		}

		public void setUrl_citaServ(String url_citaServ) {
			this.url_citaServ = url_citaServ;
		}

		public String getUrl_contacto() {
			return url_contacto;
		}

		public void setUrl_contacto(String url_contacto) {
			this.url_contacto = url_contacto;
		}

		public String getUrl_facebook() {
			return url_facebook;
		}

		public void setUrl_facebook(String url_facebook) {
			this.url_facebook = url_facebook;
		}

		public String getUrl_maps() {
			return url_maps;
		}

		public void setUrl_maps(String url_maps) {
			this.url_maps = url_maps;
		}

		public boolean isX24hrs_active() {
			return x24hrs_active;
		}

		public void setX24hrs_active(boolean x24hrs_active) {
			this.x24hrs_active = x24hrs_active;
		}

		public String getZip_code() {
			return zip_code;
		}

		public void setZip_code(String zip_code) {
			this.zip_code = zip_code;
		}
		
		
	
}
