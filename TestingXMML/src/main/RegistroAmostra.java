package main;

import java.util.ArrayList;
import java.util.HashMap;

import nu.xom.Element;

public class RegistroAmostra {

	private String id_da_amostra_dado_pelo_coletor;

	private String expedicao;

	private String projeto;

	private String protocolo;

	private String atrativo;

	private String data_da_coleta;

	private String hora_da_coleta;

	private Metodo metodo;
	
	public String toXML(){
		
		Element root = new Element("registro_amostra_sinbio_mobile");
		
		/* ----------------------------------------- */
		
		Element id_amostra = new Element("id_amostra");
		
		id_amostra.appendChild(this.id_da_amostra_dado_pelo_coletor);
		
		/* ----------------------------------------- */
		
		Element expedicao = new Element("expedicao");
		
		expedicao.appendChild(this.expedicao);
		
		/* ----------------------------------------- */
		
		Element projeto = new Element("projeto");
		
		projeto.appendChild(this.projeto);
		
		return "";
		
	}
	
	public String getId_da_amostra_dado_pelo_coletor() {
		return id_da_amostra_dado_pelo_coletor;
	}



	public void setId_da_amostra_dado_pelo_coletor(
			String id_da_amostra_dado_pelo_coletor) {
		this.id_da_amostra_dado_pelo_coletor = id_da_amostra_dado_pelo_coletor;
	}



	public String getExpedicao() {
		return expedicao;
	}



	public void setExpedicao(String expedcao) {
		this.expedicao = expedcao;
	}



	public String getProjeto() {
		return projeto;
	}



	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}



	public String getProtocolo() {
		return protocolo;
	}



	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}



	public String getAtrativo() {
		return atrativo;
	}



	public void setAtrativo(String atrativo) {
		this.atrativo = atrativo;
	}



	public String getData_da_coleta() {
		return data_da_coleta;
	}



	public void setData_da_coleta(String data_da_coleta) {
		this.data_da_coleta = data_da_coleta;
	}



	public String getHora_da_coleta() {
		return hora_da_coleta;
	}



	public void setHora_da_coleta(String hora_da_coleta) {
		this.hora_da_coleta = hora_da_coleta;
	}



	public Metodo getMetodo() {
		return metodo;
	}



	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}



	private class Metodo {
		
		HashMap<String, String> attributes = new HashMap<String, String>();
		
		public void addAttribute( String identifier , String value )
		{
			this.attributes.put(identifier, value);
		}
		
		public ArrayList<String> pegarTodosIdentificadores()
		{
			return (ArrayList<String>) this.attributes.keySet();
		}
		
		public ArrayList<String> pegarTodosValores()
		{
			return (ArrayList<String>) this.attributes.values();
		}
		
		public String pegarValor(String identificador)
		{
			return this.attributes.get(identificador);
		}
		
	}

}
