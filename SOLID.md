GestionClientesSolid/
└── src/
    └── com/juanfedevmaster/clientes/
        ├── model/
        │   └── Cliente.java
        ├── repository/
        │   ├── ClienteRepository.java
        │   └── ClienteRepositoryMemoria.java
        ├── service/
        │   └── ClienteService.java
        ├── ui/
        │   └── ClienteForm.java
        └── Main.java

package com.juanfedevmaster.clientes.model;

public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + correo + " - " + telefono;
    }
}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package com.juanfedevmaster.clientes.repository;

import com.juanfedevmaster.clientes.model.Cliente;
import java.util.List;

public interface ClienteRepository {
    void guardar(Cliente cliente);
    List<Cliente> listar();
}
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package com.juanfedevmaster.clientes.repository;

import com.juanfedevmaster.clientes.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryMemoria implements ClienteRepository {

    private final List<Cliente> clientes;

    public ClienteRepositoryMemoria() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void guardar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }
}
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package com.juanfedevmaster.clientes.service;

import com.juanfedevmaster.clientes.model.Cliente;
import com.juanfedevmaster.clientes.repository.ClienteRepository;
import java.util.List;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void registrarCliente(int id, String nombre, String correo, String telefono) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }

        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo es obligatorio.");
        }

        Cliente cliente = new Cliente(id, nombre, correo, telefono);
        clienteRepository.guardar(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.listar();
    }
}