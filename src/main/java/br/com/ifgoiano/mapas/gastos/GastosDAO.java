/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.mapas.gastos;

import br.com.ifgoiano.mapas.gastos.Gastos;
import java.util.List;

/**
 *
 * @author 1513 FOX
 */
public interface GastosDAO {
        public void salvar(Gastos gastos);

	public void atualizar(Gastos gastos);

	public void excluir(Gastos gastos);

	public Gastos carregar(Integer codigo);

	public Gastos buscarPorId(Integer id);

	public List<Gastos> listar(); 
        
        public long buscaTotalEstado(String estado);
        
        public long buscaTotalCidade(String cidade);
        
        public List<Gastos> buscaCidadesEstado(String estado);
        
        public List<String> listaEstados();
        
        public List<String> listaCidades();
        
        public List<String> listaEmpresas();
}
