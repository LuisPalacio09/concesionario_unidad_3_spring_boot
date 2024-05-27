/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicartagena.concesionario.servicio;

import co.edu.unicartagena.concesionario.modelo.Cliente;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface IClienteServicio {
    public List<Cliente> listarClientes();
    public void guardar(Cliente cliente);
    public void eliminar(Cliente cliente);
    public Cliente buscar(Cliente cliente);

}
