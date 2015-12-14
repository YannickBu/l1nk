package ipint.glp.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ipint.glp.domain.entity.Profil;

/**
 *
 *
 */
public class ProfilDAO extends DAO<Profil> {

	private static final String PERSISTENCE_UNIT_NAME = "PU";
	private EntityManagerFactory emf;
	public EntityManager em;

	public ProfilDAO() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

	@Override
	public Profil find(Profil profilATrouver) {
		em.getTransaction().begin();

		Query q = null;

		if (profilATrouver.getIdProfil() != null) {
			q = em.createQuery("select e from Profil e where e.idProfil = '" + profilATrouver.getIdProfil() + "'");
		}
		Profil profil = (Profil) q.getSingleResult();

		em.getTransaction().commit();

		return profil;
	}

	@Override
	public Profil create(Profil profil) {
		em.getTransaction().begin();

		em.persist(profil);

		em.getTransaction().commit();

		return profil;
	}

	@Override
	public void update(Profil ancienProfil, Profil nouvelProfil) {

		Profil profilMAJ = find(ancienProfil);

		if (nouvelProfil.getCentreInteret() != null) {

			profilMAJ.setCentreInteret(nouvelProfil.getCentreInteret());
		}
		if (nouvelProfil.getCompetence() != null) {

			profilMAJ.setCompetence(nouvelProfil.getCompetence());
		}
		if (nouvelProfil.getCursus() != null) {

			profilMAJ.setCursus(nouvelProfil.getCursus());
		}
		if (nouvelProfil.getExperiences() != null) {

			profilMAJ.setExperiences(nouvelProfil.getExperiences());
		}
		if (nouvelProfil.getTelephone() != null) {

			profilMAJ.setTelephone(nouvelProfil.getTelephone());
		}

		em.getTransaction().begin();

		em.persist(profilMAJ);

		em.getTransaction().commit();

	}

	@Override
	public void delete(Profil ProfilASupprimer) {
		em.getTransaction().begin();
		if (ProfilASupprimer.getIdProfil() != null) {
			em.remove(ProfilASupprimer);
		}
		// TODO gérer les exceptions pour le cas où le nom et l'id sont tous les
		// deux à null

		em.getTransaction().commit();

	}

	@Override
	public List<Profil> lister() {
		em.getTransaction().begin();

		Query q = em.createQuery("select e from Profil e");
		List<Profil> lesProfils = q.getResultList();

		em.getTransaction().commit();

		return lesProfils;

	}

}
