package pe.idat.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.edu.dto.UsuarioDTORequest;
import pe.idat.edu.dto.UsuarioDTOResponse;
import pe.idat.edu.model.Usuarios;
import pe.idat.edu.repository.UsuarioRepository;

@Service
public class UsuarioserviceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	 
	 
	@Override
	public void guardarUsuario(UsuarioDTORequest usuarios) {
		// TODO Auto-generated method stub
		Usuarios u = new Usuarios();
		u.setNombre(usuarios.getNombre());
		u.setApellido(u.getApellido());
		u.setDni(usuarios.getDni());
		repository.save(u);
	}

	@Override
	public void actualizarUsuario(UsuarioDTORequest usuarios) {
		// TODO Auto-generated method stub
		Usuarios u = new Usuarios();
		u.setNombre(usuarios.getNombre());
		u.setApellido(u.getApellido());
		u.setDni(usuarios.getDni());
		repository.save(u);
		
		repository.saveAndFlush(u);
	}
	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuario() {
		// TODO Auto-generated method stub
		List<UsuarioDTOResponse> listar = new ArrayList<>();
		UsuarioDTOResponse dto = null;
		List<Usuarios> u = repository.findAll();
		for(Usuarios usuarios : u) {
			dto = new UsuarioDTOResponse();
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {
		// TODO Auto-generated method stub
		
		Usuarios usuarios = repository.findById(id).orElse(null);
		UsuarioDTOResponse dto = new UsuarioDTOResponse();
		
		dto.setNombre(usuarios.getNombre());
		dto.setApellido(usuarios.getApellido());
		dto.setDni(usuarios.getDni());
		dto.setId(usuarios.getIdUsuario());
	
		return dto;
	}
}
