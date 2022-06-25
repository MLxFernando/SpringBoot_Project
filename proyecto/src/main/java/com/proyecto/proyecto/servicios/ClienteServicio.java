package com.proyecto.proyecto.servicios;

import java.util.List;

import com.proyecto.proyecto.dto.ClienteDTO;
import com.proyecto.proyecto.dto.NewClienteDTO;

public interface ClienteServicio {
    
    public ClienteDTO create(NewClienteDTO clienteDTO);
    public ClienteDTO retrieve(Long id);
    public ClienteDTO update(ClienteDTO clienteDTO, Long id);
    public void delete(Long id);

    public List<ClienteDTO> list();
}
