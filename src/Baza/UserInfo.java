package Baza;

public class UserInfo{
	int id;
	String ime;
	String prezime;
	String mail;
	String brojTelefona;
	
	public UserInfo(int id, String ime, String prezime, String mail, String brojTelefona) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.mail = mail;
		this.brojTelefona = brojTelefona;
	}
	@Override
	public String toString() {
		return id + " : " + ime + " " + prezime;
	}
	public int getId() {
		return id;
	}
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public String getMail() {
		return mail;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
}
