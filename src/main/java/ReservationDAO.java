import javax.persistence.EntityManager;

public class ReservationDAO {

	public void create(Reservation r) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.persist(r);

		DatabaseHelper.commitTxAndClose(em);
	}

	public void update(Reservation r) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		em.merge(r);
		
		DatabaseHelper.commitTxAndClose(em);

	}

	public void delete(Reservation r) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Reservation findReservation = em.find(Reservation.class, r.getId());
		
		if(findReservation != null) {
			em.remove(findReservation);
		}
		
		DatabaseHelper.commitTxAndClose(em);
	}
}
