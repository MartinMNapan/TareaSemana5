package pe.idat.edu.dto;

public class UserDTOResponse {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTOResponse(String token) {
		super();
		this.token = token;
	}

	public UserDTOResponse() {
		super();
	}
}
