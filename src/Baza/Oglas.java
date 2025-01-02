package Baza;

public class Oglas {
	int id;
	String naslov;
	User autor;
	String path_slike;
	public Oglas(int id, String naslov, User autor, String path_slike) {
		this.id = id;
		this.naslov = naslov;
		this.autor = autor;
		this.path_slike = path_slike;
	}
	
	@Override
	public String toString() {
		return id + " : " + naslov + " " + autor + " " + path_slike;
	}

	public int getId() {
		return id;
	}

	public String getNaslov() {
		return naslov;
	}

	public User getAutor() {
		return autor;
	}

	public String getPath_slike() {
		return path_slike;
	}
}
