package ipint.glp.domain.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idArticle;
	@javax.validation.constraints.NotNull(message = "Veuillez remplir le contenu")
	private String contenu;
	@Temporal(TemporalType.TIMESTAMP)
	@javax.validation.constraints.NotNull(message = "Veuillez remplir la date de publication")
	@javax.validation.constraints.Past(message = "Date de publication invalide")
	private Calendar datePublication;

	@ManyToOne
	private Utilisateur utilisateur;
	@ManyToMany(mappedBy = "articles")
	private List<Groupe> groupes;

	public Article() {
	}

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Calendar getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Calendar datePublication) {
		this.datePublication = datePublication;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArticle == null) ? 0 : idArticle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (idArticle == null) {
			if (other.idArticle != null)
				return false;
		} else if (!idArticle.equals(other.idArticle))
			return false;
		return true;
	}

}