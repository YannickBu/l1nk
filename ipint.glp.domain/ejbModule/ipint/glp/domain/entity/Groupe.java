package ipint.glp.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idGroupe;
	@javax.validation.constraints.NotNull(message = "Veuillez remplir la nom du groupe")
	@Column(unique = true)
	private String nomGroupe;
	@javax.validation.constraints.NotNull(message = "Veuillez remplir la description du groupe")
	private String description;

	@ManyToOne
	private Utilisateur utilisateurResponsable;
	@ManyToMany
	private List<Utilisateur> utilisateurs;
	@ManyToMany
	private List<Article> articles;

	public Groupe() {
		this.utilisateurs = new ArrayList<>();
	}

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Utilisateur getUtilisateurResponsable() {
		return utilisateurResponsable;
	}

	public void setUtilisateurResponsable(Utilisateur utilisateurResponsable) {
		this.utilisateurResponsable = utilisateurResponsable;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", nomGroupe=" + nomGroupe + ", description=" + description
				+ ", utilisateurResponsable=" + utilisateurResponsable + ", utilisateurs=" + utilisateurs
				+ ", articles=" + articles + "]";
	}

}