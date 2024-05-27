
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.concesionario.controller;

import co.edu.unicartagena.concesionario.dao.IClienteCrud;
import co.edu.unicartagena.concesionario.modelo.Cliente;
import co.edu.unicartagena.concesionario.servicio.IClienteServicio;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class controllerInicio {

    @Autowired
    IClienteServicio clienteServicio;

    @GetMapping("/")
    public String inicio(Model modelo) {

        //List<Cliente> listaClientes = (List<Cliente>) crudCliente.findAll();
        List<Cliente> listaClientes = (List<Cliente>) clienteServicio.listarClientes();
        modelo.addAttribute("clientes", listaClientes);
        log.info("Ejecutando el controlador Inicio MVC");
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Cliente cliente) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Cliente cliente, Errors errores) {
        if(errores.hasErrors()){
            return "modificar";
        }
        clienteServicio.guardar(cliente);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Cliente cliente, Model modelo) {
        log.info("Invocando el metodo EDITAR");
        cliente = clienteServicio.buscar(cliente);
        modelo.addAttribute("cliente", cliente);
        return "modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Cliente cliente) {
        clienteServicio.eliminar(cliente);
        return "redirect:/";
    }
}
