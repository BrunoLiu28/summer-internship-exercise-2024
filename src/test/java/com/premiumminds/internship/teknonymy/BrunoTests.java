package com.premiumminds.internship.teknonymy;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/*
 * Este ficheiro contém testes que garantidamente cobrem as linhas todas 
 * e os branches todos presentes na implementacao do método getTeknonymy em TeknonymyService.
 * Os testes também possuem uma diversidade de genrações existentes e quantidade de elementos em cada árvore.
 * As árvores foram criadas de forma a que se consigam entender as gerações existentes.
 * Cada elemento de uma geração apenas terá, ou nao, uma relação direta com a geracao anterior ou posterior.
 * Por exemplo, um elemento da geração 3 será filho de alguem da geração 2 e poderá ou nao ter filhos, que serão da geracao 4.
 * 
 * Bruno Liu
 * */
@RunWith(JUnit4.class)
public class BrunoTests {
	@Test
	public void Test0() {
		// Generation 1
		Person person1 = new Person("Person1", 'F', null, LocalDateTime.of(1980, 6, 28, 0, 0));
		String result = new TeknonymyService().getTeknonymy(person1);
		String expected = "";
		assertEquals(expected, result);
	}

	@Test
	public void Test1() {
		// Generation 2
		Person person2 = new Person("Person2", 'M', null, LocalDateTime.of(1918, 8, 5, 0, 0));

		// Generation 1
		Person person1 = new Person("Person1", 'F', new Person[] { person2 }, LocalDateTime.of(1920, 6, 28, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person1);
		String expected = "mother of Person2";
		assertEquals(expected, result);
	}

	@Test
	public void Test2() {
		// Generation 2
		Person person2 = new Person("Person2", 'M', null, LocalDateTime.of(1918, 8, 5, 0, 0));

		// Generation 1
		Person person1 = new Person("Person1", 'M', new Person[] { person2 }, LocalDateTime.of(1920, 6, 28, 0, 0));
		String result = new TeknonymyService().getTeknonymy(person1);
		String expected = "father of Person2";
		assertEquals(expected, result);
	}

	@Test
	public void Test3() {
		// Generation 3
		Person person4 = new Person("Person4", 'F', null, LocalDateTime.of(1955, 4, 30, 0, 0));
		Person person3 = new Person("Person3", 'M', null, LocalDateTime.of(1952, 10, 15, 0, 0));

		// Generation 2
		Person person2 = new Person("Person2", 'M', new Person[] { person3, person4 },
				LocalDateTime.of(1918, 8, 5, 0, 0));

		// Generation 1
		Person person1 = new Person("Person1", 'M', new Person[] { person2 }, LocalDateTime.of(1920, 6, 28, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person1);
		String expected = "grandfather of Person3";
		assertEquals(expected, result);
	}

	@Test
	public void Test4() {
		// Generation 3
		Person person7 = new Person("Person7", 'F', null, LocalDateTime.of(1955, 4, 30, 0, 0));
		Person person6 = new Person("Person6", 'M', null, LocalDateTime.of(1952, 10, 15, 0, 0));

		// Generation 2
		Person person5 = new Person("Person5", 'M', new Person[] { person7 }, LocalDateTime.of(1918, 8, 5, 0, 0));
		Person person4 = new Person("Person4", 'F', null, LocalDateTime.of(1922, 3, 18, 0, 0));
		Person person3 = new Person("Person3", 'M', null, LocalDateTime.of(1940, 12, 10, 0, 0));
		Person person2 = new Person("Person2", 'M', new Person[] { person6 }, LocalDateTime.of(1938, 4, 15, 0, 0));

		// Generation 1
		Person person1 = new Person("Person1", 'F', new Person[] { person2, person3, person4, person5 },
				LocalDateTime.of(1920, 6, 28, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person1);
		String expected = "grandmother of Person6";
		assertEquals(expected, result);
	}

	@Test
	public void Test5() {
		// Generation 4
		Person person10 = new Person("Person10", 'M', null, LocalDateTime.of(1995, 2, 28, 0, 0));
		Person person9 = new Person("Person9", 'F', null, LocalDateTime.of(1990, 5, 14, 0, 0));
		Person person8 = new Person("Person8", 'F', null, LocalDateTime.of(1998, 7, 20, 0, 0));

		// Generation 3
		Person person7 = new Person("Person7", 'F', new Person[] { person9 }, LocalDateTime.of(1955, 4, 30, 0, 0));
		Person person6 = new Person("Person6", 'M', new Person[] { person8, person10 },
				LocalDateTime.of(1952, 10, 15, 0, 0));

		// Generation 2
		Person person5 = new Person("Person5", 'M', new Person[] { person7 }, LocalDateTime.of(1918, 8, 5, 0, 0));
		Person person4 = new Person("Person4", 'F', null, LocalDateTime.of(1922, 3, 18, 0, 0));
		Person person3 = new Person("Person3", 'M', null, LocalDateTime.of(1940, 12, 10, 0, 0));
		Person person2 = new Person("Person2", 'M', new Person[] { person6 }, LocalDateTime.of(1938, 4, 15, 0, 0));

		// Generation 1
		Person person1 = new Person("Person1", 'F', new Person[] { person2, person3, person4, person5 },
				LocalDateTime.of(1920, 6, 28, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person1);
		String expected = "great-grandmother of Person9";
		assertEquals(expected, result);
	}

	@Test
	public void Test6() {

		// Generation 4
		Person person9 = new Person("Person9", 'M', null, LocalDateTime.of(1978, 6, 18, 0, 0));
		Person person8 = new Person("Person8", 'M', null, LocalDateTime.of(1981, 9, 5, 0, 0));

		// Generation 3
		Person person7 = new Person("Person7", 'F', null, LocalDateTime.of(1955, 4, 30, 0, 0));
		Person person6 = new Person("Person6", 'M', new Person[] { person8, person9 },
				LocalDateTime.of(1952, 10, 15, 0, 0));

		// Generation 2
		Person person5 = new Person("Person5", 'M', new Person[] { person7 }, LocalDateTime.of(1918, 8, 5, 0, 0));
		Person person4 = new Person("Person4", 'F', null, LocalDateTime.of(1922, 3, 18, 0, 0));
		Person person3 = new Person("Person3", 'M', null, LocalDateTime.of(1940, 12, 10, 0, 0));
		Person person2 = new Person("Person2", 'M', new Person[] { person6 }, LocalDateTime.of(1938, 4, 15, 0, 0));

		// Generation 1
		Person person1 = new Person("Person1", 'M', new Person[] { person2, person3, person4, person5 },
				LocalDateTime.of(1920, 6, 28, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person1);
		String expected = "great-grandfather of Person9";
		assertEquals(expected, result);
	}

	@Test
	public void Test7() {
		// Generation 10
		Person person32 = new Person("Person32", 'M', null, LocalDateTime.of(2075, 2, 28, 0, 0));
		Person person31 = new Person("Person31", 'F', null, LocalDateTime.of(2078, 5, 14, 0, 0));
		Person person30 = new Person("Person30", 'F', null, LocalDateTime.of(2083, 7, 20, 0, 0));
		Person person29 = new Person("Person29", 'M', null, LocalDateTime.of(2070, 11, 8, 0, 0));

		// Generation 9
		Person person28 = new Person("Person28", 'M', null, LocalDateTime.of(2040, 4, 25, 0, 0));
		Person person27 = new Person("Person27", 'F', null, LocalDateTime.of(2043, 9, 30, 0, 0));
		Person person26 = new Person("Person26", 'F', null, LocalDateTime.of(2048, 12, 15, 0, 0));
		Person person25 = new Person("Person25", 'M', new Person[] { person29, person30, person31, person32 },
				LocalDateTime.of(2035, 6, 20, 0, 0));

		// Generation 8
		Person person24 = new Person("Person24", 'M', null, LocalDateTime.of(2010, 2, 15, 0, 0));
		Person person23 = new Person("Person23", 'F', new Person[] { person26, person28 },
				LocalDateTime.of(2013, 8, 20, 0, 0));
		Person person22 = new Person("Person22", 'F', null, LocalDateTime.of(2018, 5, 10, 0, 0));
		Person person21 = new Person("Person21", 'M', new Person[] { person25, person27 },
				LocalDateTime.of(2005, 10, 5, 0, 0));

		// Generation 7
		Person person20 = new Person("Person20", 'M', new Person[] { person24 }, LocalDateTime.of(1990, 2, 28, 0, 0));
		Person person19 = new Person("Person19", 'F', null, LocalDateTime.of(1993, 5, 14, 0, 0));
		Person person18 = new Person("Person18", 'F', new Person[] { person21, person22, person23 },
				LocalDateTime.of(1998, 7, 20, 0, 0));

		// Generation 6
		Person person17 = new Person("Person17", 'F', null, LocalDateTime.of(1995, 9, 8, 0, 0));
		Person person16 = new Person("Person16", 'M', new Person[] { person18 }, LocalDateTime.of(1984, 11, 3, 0, 0));
		Person person15 = new Person("Person15", 'F', new Person[] { person19, person20 },
				LocalDateTime.of(1983, 8, 15, 0, 0));

		// Generation 5
		Person person14 = new Person("Person14", 'M', null, LocalDateTime.of(1991, 1, 20, 0, 0));
		Person person13 = new Person("Person13", 'F', null, LocalDateTime.of(2015, 7, 12, 0, 0));
		Person person12 = new Person("Person12", 'M', null, LocalDateTime.of(2018, 10, 30, 0, 0));
		Person person11 = new Person("Person11", 'F', new Person[] { person16, person17 },
				LocalDateTime.of(1994, 3, 8, 0, 0));
		Person person10 = new Person("Person10", 'F', new Person[] { person15 }, LocalDateTime.of(1985, 9, 25, 0, 0));

		// Generation 4
		Person person9 = new Person("Person9", 'M', new Person[] { person11, person13, person14 },
				LocalDateTime.of(1978, 6, 18, 0, 0));
		Person person8 = new Person("Person8", 'M', new Person[] { person10, person12 },
				LocalDateTime.of(1981, 9, 5, 0, 0));

		// Generation 3
		Person person7 = new Person("Person7", 'F', null, LocalDateTime.of(1955, 4, 30, 0, 0));
		Person person6 = new Person("Person6", 'M', new Person[] { person8, person9 },
				LocalDateTime.of(1952, 10, 15, 0, 0));

		// Generation 2
		Person person5 = new Person("Person5", 'M', new Person[] { person7 }, LocalDateTime.of(1918, 8, 5, 0, 0));
		Person person4 = new Person("Person4", 'F', null, LocalDateTime.of(1922, 3, 18, 0, 0));
		Person person3 = new Person("Person3", 'M', null, LocalDateTime.of(1940, 12, 10, 0, 0));
		Person person2 = new Person("Person2", 'M', new Person[] { person6 }, LocalDateTime.of(1938, 4, 15, 0, 0));

		// Generation 1
		Person person1 = new Person("Person1", 'M', new Person[] { person2, person3, person4, person5 },
				LocalDateTime.of(1920, 6, 28, 0, 0));

//		long initialTime = System.nanoTime();
		String result = new TeknonymyService().getTeknonymy(person1);
//		long endTime = System.nanoTime() - initialTime;
//		System.out.println("Total Time: " + endTime);
		String expected = "great-great-great-great-great-great-great-grandfather of Person29";
		assertEquals(expected, result);
	}

	@Test
	public void Test8() {
		// Generation 15
		Person person14 = new Person("Person14", 'M', null, LocalDateTime.of(1991, 1, 20, 0, 0));
		// Generation 14
		Person person13 = new Person("Person13", 'F', new Person[] { person14 }, LocalDateTime.of(2015, 7, 12, 0, 0));
		// Generation 12
		Person person12 = new Person("Person12", 'M', new Person[] { person13 }, LocalDateTime.of(2018, 10, 30, 0, 0));
		// Generation 11
		Person person11 = new Person("Person11", 'F', new Person[] { person12 }, LocalDateTime.of(1994, 3, 8, 0, 0));
		// Generation 10
		Person person10 = new Person("Person10", 'F', new Person[] { person11 }, LocalDateTime.of(1985, 9, 25, 0, 0));
		// Generation 9
		Person person9 = new Person("Person9", 'M', new Person[] { person10 }, LocalDateTime.of(1978, 6, 18, 0, 0));
		// Generation 8
		Person person8 = new Person("Person8", 'M', new Person[] { person9 }, LocalDateTime.of(1981, 9, 5, 0, 0));
		// Generation 7
		Person person7 = new Person("Person7", 'F', new Person[] { person8 }, LocalDateTime.of(1955, 4, 30, 0, 0));
		// Generation 6
		Person person6 = new Person("Person6", 'M', new Person[] { person7 }, LocalDateTime.of(1952, 10, 15, 0, 0));
		// Generation 5
		Person person5 = new Person("Person5", 'M', new Person[] { person6 }, LocalDateTime.of(1918, 8, 5, 0, 0));
		// Generation 4
		Person person4 = new Person("Person4", 'F', new Person[] { person5 }, LocalDateTime.of(1922, 3, 18, 0, 0));
		// Generation 3
		Person person3 = new Person("Person3", 'M', new Person[] { person4 }, LocalDateTime.of(1940, 12, 10, 0, 0));
		// Generation 2
		Person person2 = new Person("Person2", 'M', new Person[] { person3 }, LocalDateTime.of(1938, 4, 15, 0, 0));
		// Generation 1
		Person person1 = new Person("Person1", 'f', new Person[] { person2 }, LocalDateTime.of(1920, 6, 28, 0, 0));

//		long initialTime = System.nanoTime();
		String result = new TeknonymyService().getTeknonymy(person1);
//		long endTime = System.nanoTime() - initialTime;
//		System.out.println("Total Time: " + endTime);
		String expected = "great-great-great-great-great-great-great-great-great-great-great-grandmother of Person14";
		assertEquals(expected, result);
	}

}
