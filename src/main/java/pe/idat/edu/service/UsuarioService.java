package pe.idat.edu.service;

import java.util.List;

import pe.idat.edu.dto.UsuarioDTORequest;
import pe.idat.edu.dto.UsuarioDTOResponse;

public interface UsuarioService {
	
	void guardarUsuario(UsuarioDTORequest usuarios);
	void actualizarUsuario(UsuarioDTORequest usuarios);
	void eliminarUsuario(Integer id);
	List<UsuarioDTOResponse> listarUsuario();
	UsuarioDTOResponse obtenerUsuarioId(Integer id);

}
