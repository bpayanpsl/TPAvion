import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------------MENU-------------------");
		System.out.println("1 - Gestion des vols");
		System.out.println("2 - Gestion des réservations");
		System.out.println("3 - Quitter");
		
		VolDAO vdao = new VolDAO();
		ReservationDAO rdao = new ReservationDAO();
		int nb = Integer.parseInt(sc.nextLine());
		
		switch (nb) {
		case 1:
			System.out.println("-------------------GESTION VOLS-------------------");
			System.out.println("1 - Créer un vol");
			System.out.println("2 - Liste des vols");
			System.out.println("3 - Trouver un vol avec son ID");
			System.out.println("4 - Trouver un vol avec ses villes de depart/arrivée");
			nb = Integer.parseInt(sc.nextLine());

				switch (nb) {
				case 1:
					Vol v = new Vol();
					System.out.println("-------------------AJOUT VOL-------------------");
					System.out.println("Saisir un numéro de vol (4 caractères, de la forme OOO1)");
					String str = sc.nextLine();
					v.setNumVol(str);
					System.out.println("Saisir un type d'avion");
					str = sc.nextLine();
					v.setTypeAvion(str);
					System.out.println("Saisir un nombre de place");
					int nb1 = Integer.parseInt(sc.nextLine());
					v.setNbPlace(nb1);
					System.out.println("Saisir une ville de depart");
					str = sc.nextLine();
					v.setVilleDepart(str);
					System.out.println("Saisir une ville d'arrivée");
					str = sc.nextLine();
					v.setVilleArrivee(str);
					System.out.println("Saisir une date de depart (jj-mm-yyyy)");
					str = sc.nextLine();
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					try {
						date = formatter.parse(str);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					v.setDateDepart(date);
					vdao.create(v);
					break;
					
				case 2:
					System.out.println("-------------------LISTE VOLS-------------------");
					EntityManager em = DatabaseHelper.createEntityManager();				
					TypedQuery<Vol> query = em.createQuery("select v from Vol v", Vol.class);					
					List<Vol> vols = query.getResultList();					
					for (Vol vl : vols) {
						System.out.println(vl.toString());
					}	
					em.close();
					break;
					
				case 3:
					System.out.println("-------------------RECHERCHE VOL PAR ID-------------------");
					System.out.println("Saisir un numéro de vol");
					str = sc.nextLine();
					EntityManager em1 = DatabaseHelper.createEntityManager();	
					query = em1.createQuery("select v from Vol v where v.numVol =:numVol ", Vol.class);
					query.setParameter("numVol", str);
					List<Vol> volsById = query.getResultList();	 					
					for (Vol vl : volsById) {
						System.out.println(vl.toString());
					}	
					em1.close();
					break;
					
				case 4 :
					System.out.println("-------------------RECHERCHE VOL PAR VILLE-------------------");
					System.out.println("Saisir une ville de depart");
					str = sc.nextLine();
					String villeDepart = str;
					System.out.println("Saisir une ville d'arrivée");
					str = sc.nextLine();
					String villeArrivee = str;
					EntityManager em2 = DatabaseHelper.createEntityManager();
					query = em2.createQuery("select v from Vol v where v.villeDepart =:villeDepart and v.villeArrivee = :villeArrivee ", Vol.class);
					query.setParameter("villeDepart", villeDepart)
						.setParameter("villeArrivee", villeArrivee);
					List<Vol> volsByVille = query.getResultList();	 
					for (Vol vl : volsByVille) {
						System.out.println(vl.toString());
					}	
					em2.close();
					break;
					
				default:
					System.exit(1);
					break;
				}

			break;
		case 2:
			System.out.println("-------------------GESTION RESERVATIONS-------------------");
			System.out.println("1 - Créer une réservation");
			System.out.println("2 - Voir les réservations d’un vol");
			System.out.println("3 - Annuler une réservation");
			System.out.println("4 - Voir toutes les réservations d’une personne");
			nb = Integer.parseInt(sc.nextLine());
			switch(nb) {
			case 1:
				System.out.println("-------------------AJOUT RESERVATION-------------------");
				Reservation r = new Reservation();
				System.out.println("Saisir le numéro du vol");
				String str = sc.nextLine();
				String numVol = str;
				EntityManager em = DatabaseHelper.createEntityManager();
				TypedQuery<Vol> query = em.createQuery("select v from Vol v where v.numVol = :numVol ", Vol.class);
				query.setParameter("numVol", numVol);
				Vol vol = query.getSingleResult();
				r.setVol(vol);
				System.out.println("Saisir un nom");
				str = sc.nextLine();
				r.setNom(str);
				System.out.println("Saisir un prénom");
				str = sc.nextLine();
				r.setPrenom(str);
				System.out.println("Saisir un age");
				int nb1 = Integer.parseInt(sc.nextLine());
				r.setAge(nb1);
				System.out.println(r.getAge());
				rdao.create(r);
				TypedQuery<Reservation> queryR = em.createQuery("select r from Reservation r where r.id = :id ", Reservation.class);
				queryR.setParameter("id", r.getId());
				r = queryR.getSingleResult();
				System.out.println(r.getId());
				String numResa = vol.getNumVol() +" - "+r.getId();
				r.setNumResa(numResa);
				rdao.update(r);
				break;
				
			case 2 :
				break;
			case 3 :
				System.out.println("-------------------ANNULATION RESERVATION-------------------");
				System.out.println("Saisir le numéro de la réservation à annuler");
				str = sc.nextLine();
				EntityManager em1 = DatabaseHelper.createEntityManager();
				queryR = em1.createQuery("select r from Reservation r where r.numResa = :numResa ", Reservation.class);
				queryR.setParameter("numResa", str);
				r = queryR.getSingleResult();
				rdao.delete(r);
				break;
			default:
				System.exit(1);
				break;
			}
			break;
				
		case 3:
			System.exit(1);
			break;
		default:
			System.exit(1);
			break;
		}

	}

}
