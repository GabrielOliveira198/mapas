/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.gastos.Gastos;
import br.com.ifgoiano.mapas.gastos.GastosRN;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author 1513 FOX
 */

    
@ManagedBean(name = "gastosBean")
//@SessionScoped
//@NoneScoped 
//@RequestScoped //(padrão), 
//@ViewScoped 
@SessionScoped 
//@ApplicationScoped
public class GastosBean {
    
   	private Gastos gastos = new Gastos();
        private List<Gastos> lista;
        private List<Gastos> listaestado;
        private List<Gastos> gastosPorEstado; /*Gastos por estado*/
        private List<String> listacidade;
        private List<SelectItem> estados;
        private List<SelectItem> cidades;
        private ArrayList<String> empresas;
        private String estado;
        private String cidade;
        private String empresa;
        private boolean excluirmenores;

    public boolean isExcluirmenores() {
        return excluirmenores;
    }

    public void setExcluirmenores(boolean excluirmenores) {
        this.excluirmenores = excluirmenores;
    }

      
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public ArrayList<String> getEmpresas() {
        //empresas = new ArrayList<String> String String = String;
        for(Gastos g: listaestado)
            {
                if(g.getEmpresa().equals(empresa))
                    empresas.add(g.getEmpresa());
            }
        
        return empresas;
    }

    public void setEmpresas(ArrayList<String> empresas) {
        this.empresas = empresas;
    }

 

   

    public void setListaestado(List<Gastos> listaestado) {
        this.listaestado = listaestado;
    }

    public void setListacidade(List<String> listacidade) {
        this.listacidade = listacidade;
    }

    public void setEstados(List<SelectItem> estados) {
        this.estados = estados;
    }

    public void setCidades(List<SelectItem> cidades) {
        this.cidades = cidades;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Gastos> getGastosPorEstado() {
        return gastosPorEstado;
    }

    public void setGastosPorEstado(List<Gastos> gastosSelecionados) {
        this.gastosPorEstado = gastosSelecionados;
    }
     
    public void listaGastosEstado()           
    {       listaestado = this.getLista();
            gastosPorEstado=new ArrayList<>();
            for(Gastos g: listaestado)
            {
                if(g.getEstado().equals(estado))
                    gastosPorEstado.add(g);
            }
    }

    /*retorna a lista de cidades para o estado atual*/
    public List<String> getListacidade(){
        listacidade = new ArrayList<String>();
        for(Gastos g:listaestado)
        {
            if (g.getEstado().equals(estado))
                listacidade.add(g.getCidade());
        }
        return listacidade;
    }

   
    public List<Gastos> getListaestado(){
        //Set<Gastos> estados = new HashSet<Gastos>(listaestado);
        //listaestado = new ArrayList<Gastos>(estados);
        return listaestado;
    }
  
     public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
        

        public List<SelectItem> getEstados () {
		SelectItem item = null;
                lista = new GastosRN().listar();
                estados = new ArrayList<>();
                
		if (lista != null) {
			for (Gastos gasto : lista) {
				item = new SelectItem(gasto, gasto.getEstado());
				//item.setEscape(false);
				estados.add(item);                                
			}
		}
                return estados;
	}
        
        public List<SelectItem> getCidades() {
		SelectItem item = null;
                lista = new GastosRN().listar();
                cidades = new ArrayList<SelectItem>();
		if (lista != null) {
			for (Gastos gasto : lista) {
				item = new SelectItem(gasto, gasto.getCidade());
				item.setEscape(false);
				cidades.add(item);				
			}
		}
                    return cidades;
	}
	

	public String novoE() {
		this.gastos = new Gastos();
                this.lista=new GastosRN().listar();
		return "teste.xhtml";
	}

    public Gastos getGastos() {
        return gastos;
    }

    public void setGastos(Gastos gastos) {
        this.gastos = gastos;
    }

    public List<Gastos> getLista() {
        return new GastosRN().listar();
    }

    public void setLista(List<Gastos> lista) {
        this.lista = lista;
    }
                    
        /*public int buscarLocal(){
            GastosRN estado = new GastosRN();
                gastos.setCodigo(codigo);
                Gastos e = estado.buscarPorCodigo(this.gastos.getCodigo());
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(Integer.toString(e.getPopulacao()));
		context.addMessage(null, facesMessage);
                return e.getPopulacao();
	}*/
        
         public List<Gastos> buscarEstado(String est){
                List<Gastos> e = new GastosRN().listar();
                for(Gastos g:e)
                {
                    if(est.equals(g.getEstado()))
                        this.listaestado.add(g);
                }
		FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(e.toString());
		context.addMessage(null, facesMessage);
                return listaestado;
	}
         
            public float buscarGastosEstado(String codigo){
                GastosRN gastorn = new GastosRN();
                gastos = new Gastos();
                float total = gastorn.buscaTotalEstado(codigo);
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(Integer.toString(30));//gastos.getPopulacao()));
		context.addMessage(null, facesMessage);
                return total;
      
	
	}
            public List<Gastos> listar()
            {
                GastosRN gastosrn = new GastosRN();
                this.lista = gastosrn.listar();
                return gastosrn.listar();
            }
}

