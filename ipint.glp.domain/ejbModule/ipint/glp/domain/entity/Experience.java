package ipint.glp.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Experience
 *
 */
@Entity
public class Experience implements Serializable {
	private static final long serialVersionUID = -8663409807833629744L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idExperience;
	@javax.validation.constraints.NotNull(message = "Veuillez remplir l'année de début")
	@javax.validation.constraints.DecimalMin(value = "1900", message = "Année impossible")
	@javax.validation.constraints.DecimalMax(value = "2100", message = "Année impossible")
	private Integer anneeDebut;
	@javax.validation.constraints.DecimalMin(value = "1900", message = "Année impossible")
	@javax.validation.constraints.DecimalMax(value = "2100", message = "Année impossible")
	private Integer anneFin;
	@javax.validation.constraints.NotNull(message = "Veuillez remplir le nom de l'entreprise")
	private String entreprise;
	@javax.validation.constraints.NotNull(message = "Veuillez remplir le poste")
	private String poste;
	@javax.validation.constraints.NotNull(message = "Veuillez remplir le lieu")
	private String lieu;
	private String description;

	public Experience() {
		super();
	}

	public Integer getIdExperience() {
		return idExperience;
	}

	public void setIdExperience(Integer idExperience) {
		this.idExperience = idExperience;
	}

	public Integer getAnneeDebut() {
		return anneeDebut;
	}

	public void setAnneeDebut(Integer anneeDebut) {
		this.anneeDebut = anneeDebut;
	}

	public Integer getAnneFin() {
		return anneFin;
	}

	public void setAnneFin(Integer anneFin) {
		this.anneFin = anneFin;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idExperience == null) ? 0 : idExperience.hashCode());
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
		Experience other = (Experience) obj;
		if (idExperience == null) {
			if (other.idExperience != null)
				return false;
		} else if (!idExperience.equals(other.idExperience))
			return false;
		return true;
	}

}