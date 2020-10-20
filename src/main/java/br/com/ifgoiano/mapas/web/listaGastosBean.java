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

    
@ManagedBean(name = "listaGastosBean")
//@NoneScoped 
//@RequestScoped //(padrão), 
//@ViewScoped 
@SessionScoped 
//@ApplicationScoped
public class listaGastosBean {
    
   	private Gastos gastos = new Gastos();
        private List<Gastos> listaResultadoBusca;
        private List<Gastos> gastosCidade  = null;
        private List<Gastos> listacidades;
        private String estado;
        private String cidade;
        private String empresa;
        private List<String> estados;
        private List<String> cidades;
        private List<String> empresas;
        private boolean excluirmenores;

   public List<String> getEstados() {
        GastosRN g= new GastosRN();
        return g.listaEstados();
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public List<String> getCidades() {
        GastosRN g= new GastosRN();
        return g.listaCidades();
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

    public List<String> getEmpresas() {
        GastosRN g= new GastosRN();
        return g.listaEmpresas();
    }

    public void setEmpresas(List<String> empresas) {
        this.empresas = empresas;
    }

    public List<Gastos> getListacidades() {
        GastosRN g = new GastosRN();
        listacidades = g.buscaCidadesEstado(estado);
        return listacidades;
    }

    public void setListacidades(List<Gastos> listacidades) {
        this.listacidades = listacidades;
    }

    public List<Gastos> getListaResultadoBusca() {
        return listaResultadoBusca;
    }

    public void setListaResultadoBusca(List<Gastos> listaResultadoBusca) {
        this.listaResultadoBusca = listaResultadoBusca;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
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
        this.listaResultadoBusca = lista;
    }
    
    public List<String> atualizaCidades(String estado){
        GastosRN g= new GastosRN();
        List<Gastos> lista = new ArrayList<>();
        cidades = new ArrayList<>();
      
        for(Gastos e: g.buscaCidadesEstado(estado)){
         cidades.add(e.getCidade());
        }
        return cidades;
    }
    
    public List<Gastos> busca(){       
        gastosCidade = new ArrayList<>();
        //listaResultadoBusca = buscarEstado(estado);
        //if(estado.isEmpty() && cidade.isEmpty() && empresa.isEmpty())
        listaResultadoBusca = this.listar();
        List<Gastos> aux = new ArrayList<>();
        if(!estado.isEmpty() && !cidade.isEmpty() && !empresa.isEmpty()){
            for(Gastos g:listaResultadoBusca)
                if(g.getEstado().equals(estado)&& g.getCidade().equals(cidade) && g.getEmpresa().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(!estado.isEmpty() && !cidade.isEmpty() && empresa.isEmpty()){
            for(Gastos g:listaResultadoBusca)
                if(g.getEstado().equals(estado)&& g.getCidade().equals(cidade) )
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(!estado.isEmpty() && cidade.isEmpty() && !empresa.isEmpty()){
             for(Gastos g:listaResultadoBusca)
                if(g.getEstado().equals(estado)&& g.getEmpresa().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(estado.isEmpty() && !cidade.isEmpty() && !empresa.isEmpty()){
            for(Gastos g:listaResultadoBusca)
                if(g.getCidade().equals(cidade) && g.getEmpresa().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        } 
        if(!estado.isEmpty() && cidade.isEmpty() && empresa.isEmpty()){
            for(Gastos g:listaResultadoBusca)
                if(g.getEstado().equals(estado))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
            
        if(estado.isEmpty() && !cidade.isEmpty() && empresa.isEmpty()){
             for(Gastos g:listaResultadoBusca)
                if( g.getCidade().equals(cidade) )
                    aux.add(g);
            listaResultadoBusca = aux;
        }
        if(estado.isEmpty() && cidade.isEmpty() && !empresa.isEmpty()){
            for(Gastos g:listaResultadoBusca)
                if(g.getEmpresa().equals(empresa))
                    aux.add(g);
            listaResultadoBusca = aux;
        }
            
            
        
        return listaResultadoBusca;
    }
    
    public List<Gastos> buscarEstado(String est){
            List<Gastos> e = new GastosRN().listar();
            List<Gastos> listaestado;
               listaestado = new ArrayList<Gastos>();
            for(Gastos g:e)
            {
                if(est.equals(g.getEstado()))
                    listaestado.add(g);
            }
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(e.toString());
            context.addMessage(null, facesMessage);
            return listaestado;
	}
    
    public List<Gastos> listar()
    {
        GastosRN gastosrn = new GastosRN();
        this.listaResultadoBusca = gastosrn.listar();
        return gastosrn.listar();
    }

    
}
