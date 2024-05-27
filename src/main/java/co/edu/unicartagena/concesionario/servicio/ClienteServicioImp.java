/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.concesionario.servicio;

import co.edu.unicartagena.concesionario.dao.IClienteCrud;
import co.edu.unicartagena.concesionario.modelo.Cliente;
import java.util.List;
import static org.hibernate.query.results.Builders.entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USUARIO
 */
@Service
public class ClienteServicioImp implements IClienteServicio {
    
    @Autowired
    private IClienteCrud crudCliente;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) crudCliente.findAll();
    }

    @Transactional
    @Override
    public void guardar(Cliente cliente) {
        crudCliente.save(cliente);
    }

    @Transactional
    @Override
    public void eliminar(Cliente cliente) {
        crudCliente.delete(cliente);
    }

    @Override
    public Cliente buscar(Cliente cliente) {
        return crudCliente.findById(cliente.getId()).orElse(null);
    }
    }