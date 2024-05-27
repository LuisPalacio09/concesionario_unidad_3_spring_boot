/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicartagena.concesionario.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "cliente", catalog = "concesionario")
@Data
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Cliente")
    private String id;
    @NotEmpty
    @Basic(optional = false)
    @NotEmpty
    private String Nombre;
    @Basic(optional = false)
    @NotEmpty
    private String Dni;
    @Basic(optional = false)
    @NotEmpty
    private String Direccion;
    @Basic(optional = false)
    @NotEmpty
    private String Telefono;
}
