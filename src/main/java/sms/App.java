package sms;


import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sms.Student;

public class App {
	static Scanner sc = new Scanner(System.in);

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {

			System.out.println("Select Option");
			System.out.println("1) Create Student");
			System.out.println("2) View Student");
			System.out.println("3) Update Student");
			System.out.println("4) Delete Student");
			System.out.println("5) ViewAll Student");
			System.out.println("6) Exit");

			int key = sc.nextInt();

			switch (key) {
			case 1:
				CreateStudent();
				break;
			case 2:
				ViewStudent();
				break;
			case 3:
				UpdateStudent();
				break;
			case 4:
				DeleteStudent();
				break;
			case 5:
				ViewAllStudent();
				break;
			case 6:
				flag = false;
				System.out.println("Thank You");
				break;

			default:
				System.out.println("Invalid selection Please select valid Options");
			}

		}

	}

	private static void CreateStudent() {
		System.out.println("Enter Id");
		int id = sc.nextInt();

		System.out.println("Enter name");
		String name = sc.next();

		System.out.println("Enter email");
		String email = sc.next();

		System.out.println("Enter age");
		int age = sc.nextInt();

		System.out.println("Enter course");
		String course = sc.next();

		System.out.println("Enter year");
		String year = sc.next();

		Student s = new Student(id, name, email, age, course, year);

		et.begin();
		em.persist(s);
		et.commit();

	}

	private static void ViewStudent() {

		System.out.println("Enter Id");
		int id = sc.nextInt();

		Student s = em.find(Student.class, id);

		System.out.println(s);
	}

	private static void UpdateStudent() {
		System.out.println("Enter Id");
		int id = sc.nextInt();

		Student s = em.find(Student.class, id);

		if (s != null) {
			System.out.println("Enter new  course  to Update");
			String course = sc.next();

			s.setCourse(course);

			et.begin();
			em.merge(s);
			et.commit();

			System.out.println(" Course updated sucessfully");

		} else {
			System.out.println("Invalid user id Unable to Updated Course");

		}

	}

	private static void DeleteStudent() {

		System.out.println("Enter Id");
		int id = sc.nextInt();

		Student s = em.find(Student.class, id);

		if (s != null) {

			et.begin();
			em.remove(s);
			et.commit();

		} else {
			System.out.println("invalid user Id");
		}

		System.out.println("Done");
	}

	private static void ViewAllStudent() {

		Query q = em.createQuery("select s from Student s");

		List<Student> ul = q.getResultList();

		ListIterator<Student> litr = ul.listIterator();

		while (litr.hasNext()) {
			System.out.println(litr.next());
		}
	}
}