/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.web;

import br.com.ifgoiano.mapas.comentarios.Comentarios;
import br.com.ifgoiano.mapas.comentarios.ComentariosRN;
import br.com.ifgoiano.mapas.gastos.Gastos;
import br.com.ifgoiano.mapas.gastos.GastosRN;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author crisf
 */

@ManagedBean(name = "comentariosBean")
//@SessionScoped
//@NoneScoped 
//@RequestScoped //(padrão), 
//@ViewScoped 
@SessionScoped
public class ComentariosBean {
    List<Comentarios> comentarios = new ArrayList<>();

    private int gasto;

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }
    
    
    
    public List<Comentarios> getComentarios() {
        this.comentarios = this.listarComentariosGasto();
        return comentarios;
    }

    /**
     * Creates a new instance of ComentariosBean
     */
    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public ComentariosBean() {
    }
   
    public void adicionar(){
         ComentariosRN comentariosrn = new ComentariosRN();
         Comentarios comentario = new Comentarios();
         comentariosrn.salvar(comentario);
    }
    
    public List<Comentarios> listarComentariosGasto()
        {
            ComentariosRN comentariosrn = new ComentariosRN();
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            this.gasto = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("gasto"));
            this.comentarios = comentariosrn.listarPorGasto(this.gasto);
            return this.comentarios;
         }
    public List<Comentarios> listarComentariosGasto(int gasto)
        {
            ComentariosRN comentariosrn = new ComentariosRN();
            
            this.comentarios = comentariosrn.listarPorGasto(gasto);
            return this.comentarios;
         }
    public List<Comentarios> listarComentarios()
        {
            ComentariosRN comentariosrn = new ComentariosRN();            
            this.comentarios = comentariosrn.listar();
            return comentarios;
         }
}
