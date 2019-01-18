
import javax.persistence.EntityManager;

public class VolDAO {

	public void create(Vol v) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.persist(v);

		DatabaseHelper.commitTxAndClose(em);
	}

	public void update(Vol v) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.merge(v);

		DatabaseHelper.commitTxAndClose(em);

	}

	public void delete(Vol v) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		Vol findVol = em.find(Vol.class, v.getId());

		if (findVol != null) {
			em.remove(findVol);
		}

		DatabaseHelper.commitTxAndClose(em);
	}
}