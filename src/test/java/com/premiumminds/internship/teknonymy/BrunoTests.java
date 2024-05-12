package com.premiumminds.internship.teknonymy;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BrunoTests {
	@Test
	public void PersonNoChildrenTest() {
		Person person = new Person("John", 'M', null, LocalDateTime.of(1046, 1, 1, 0, 0));
		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "";
		assertEquals(result, expected);
	}

	@Test
	public void PersonOneChildTest() {
		Person person = new Person("John", 'M',
				new Person[] { new Person("Holy", 'F', null, LocalDateTime.of(1046, 1, 1, 0, 0)) },
				LocalDateTime.of(1046, 1, 1, 0, 0));
		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "father of Holy";
		assertEquals(result, expected);
	}

	@Test
	public void Test1() {
		Person person = new Person("Alice", 'F',
				new Person[] { new Person("Bob", 'M', null, LocalDateTime.of(1980, 5, 10, 0, 0)),
						new Person("Charlie", 'M', null, LocalDateTime.of(1982, 8, 15, 0, 0)) },
				LocalDateTime.of(1978, 3, 20, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "mother of Bob";
		assertEquals(result, expected);
	}

	@Test
	public void Test2() {
		Person person = new Person("John", 'M',
				new Person[] { new Person("Holy", 'F', null, LocalDateTime.of(1046, 1, 1, 0, 0)) },
				LocalDateTime.of(1046, 1, 1, 0, 0));
		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "father of Holy";
		assertEquals(result, expected);
	}

	@Test
	public void Test3() {
		Person person = new Person("Grandpa", 'M',
				new Person[] { new Person("Dad", 'M',
						new Person[] { new Person("Son", 'M', null, LocalDateTime.of(2000, 1, 1, 0, 0)),
								new Person("Daughter", 'F', null, LocalDateTime.of(2002, 3, 15, 0, 0)) },
						LocalDateTime.of(1975, 7, 12, 0, 0)) },
				LocalDateTime.of(1950, 12, 25, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "grandfather of Son";
		assertEquals(result, expected);
	}

	@Test
	public void Test4() {
		Person person = new Person("Grandma", 'F', new Person[] { new Person("Mom", 'F',
				new Person[] { new Person("Son", 'M', null, LocalDateTime.of(1995, 4, 20, 0, 0)),
						new Person("Daughter", 'F',
								new Person[] { new Person("Grandchild1", 'M', null, LocalDateTime.of(2020, 6, 1, 0, 0)),
										new Person("Grandchild2", 'F', null, LocalDateTime.of(2022, 9, 10, 0, 0)) },
								LocalDateTime.of(1997, 10, 30, 0, 0)) },
				LocalDateTime.of(1970, 11, 8, 0, 0)) }, LocalDateTime.of(1955, 8, 18, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "great-grandmother of Grandchild1";
		assertEquals(result, expected);
	}

	@Test
	public void Test5() {
		Person person = new Person("Grandma", 'F', new Person[] {
				new Person("Mom", 'F', new Person[] { new Person("Son", 'M', null, LocalDateTime.of(1995, 4, 20, 0, 0)),
						new Person("Daughter", 'F',
								new Person[] { new Person("Grandchild1", 'M', null, LocalDateTime.of(2020, 6, 1, 0, 0)),
										new Person("Grandchild2", 'F', null, LocalDateTime.of(2022, 9, 10, 0, 0)) },
								LocalDateTime.of(1997, 10, 30, 0, 0)),
						new Person("Son2", 'M', null, LocalDateTime.of(2000, 8, 15, 0, 0)),
						new Person("Daughter2", 'F', null, LocalDateTime.of(2003, 3, 5, 0, 0)) },
						LocalDateTime.of(1970, 11, 8, 0, 0)),
				new Person("Aunt", 'F',
						new Person[] { new Person("Cousin1", 'M', null, LocalDateTime.of(1987, 2, 12, 0, 0)),
								new Person("Cousin2", 'F', null, LocalDateTime.of(1990, 7, 25, 0, 0)) },
						LocalDateTime.of(1975, 5, 20, 0, 0)) },
				LocalDateTime.of(1955, 8, 18, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "great-grandmother of Grandchild1";
		assertEquals(result, expected);
	}

	@Test
	public void Test6() {
		Person person = new Person("Grandpa", 'M', new Person[] {
				new Person("Mom", 'F', new Person[] { new Person("Son", 'M', null, LocalDateTime.of(1995, 4, 20, 0, 0)),
						new Person("Daughter", 'F',
								new Person[] { new Person("Grandchild1", 'M', null, LocalDateTime.of(2020, 6, 1, 0, 0)),
										new Person("Grandchild2", 'F', null, LocalDateTime.of(2022, 9, 10, 0, 0)) },
								LocalDateTime.of(1997, 10, 30, 0, 0)),
						new Person("Son2", 'M', null, LocalDateTime.of(2000, 8, 15, 0, 0)),
						new Person("Daughter2", 'F', null, LocalDateTime.of(2003, 3, 5, 0, 0)) },
						LocalDateTime.of(1970, 11, 8, 0, 0)),
				new Person("Aunt", 'F',
						new Person[] { new Person("Cousin1", 'M', null, LocalDateTime.of(1987, 2, 12, 0, 0)),
								new Person("Cousin2", 'F', new Person[] {
										new Person("CousinChild1", 'M', null, LocalDateTime.of(2015, 7, 20, 0, 0)),
										new Person("CousinChild2", 'F', null, LocalDateTime.of(2017, 11, 12, 0, 0)) },
										LocalDateTime.of(1990, 7, 25, 0, 0)) },
						LocalDateTime.of(1975, 5, 20, 0, 0)) },
				LocalDateTime.of(1955, 8, 18, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "great-grandfather of CousinChild1";
		assertEquals(result, expected);
	}

	@Test
	public void Test7() {
		Person person = new Person("Great-Grandma", 'M',
				new Person[] { new Person("Grandpa", 'M',
						new Person[] { new Person("Grandma", 'F', new Person[] {
								new Person("Dad", 'M',
										new Person[] {
												new Person(
														"Uncle1", 'M', new Person[] {
																new Person("Cousin1", 'M',
																		new Person[] {
																				new Person("CousinChild1", 'M', null,
																						LocalDateTime.of(2010, 3, 1, 0,
																								0)),
																				new Person("CousinChild2", 'F', null,
																						LocalDateTime.of(2012, 6, 15, 0,
																								0)) },
																		LocalDateTime.of(1980, 8, 25, 0, 0)),
																new Person("Aunt1", 'F',
																		new Person[] {
																				new Person("Cousin3", 'M', null,
																						LocalDateTime.of(1985, 10, 5, 0,
																								0)),
																				new Person("Cousin4", 'F', null,
																						LocalDateTime.of(1988, 12, 20,
																								0, 0)) },
																		LocalDateTime.of(1982, 4, 10, 0, 0)) },
														LocalDateTime.of(1978, 2, 15, 0, 0)),
												new Person(
														"Aunt2", 'F',
														new Person[] {
																new Person("Cousin5", 'F', null,
																		LocalDateTime.of(1989, 3, 12, 0, 0)),
																new Person("Cousin6", 'M', null,
																		LocalDateTime.of(1992, 7, 8, 0, 0)) },
														LocalDateTime.of(1980, 6, 5, 0, 0)) },
										LocalDateTime.of(1975, 11, 20, 0, 0)),
								new Person("Uncle2", 'M', new Person[] {
										new Person("Cousin7", 'M', null, LocalDateTime.of(1987, 9, 30, 0, 0)),
										new Person("Cousin8", 'F',
												new Person[] {
														new Person("Grandchild1", 'M', null,
																LocalDateTime.of(2010, 1, 10, 0, 0)),
														new Person("Grandchild2", 'F', null,
																LocalDateTime.of(2013, 4, 25, 0, 0)) },
												LocalDateTime.of(1990, 12, 15, 0, 0)) },
										LocalDateTime.of(1978, 7, 15, 0, 0)),
								new Person("Aunt3", 'F',
										new Person[] {
												new Person("Cousin9", 'M', null, LocalDateTime.of(1983, 5, 18, 0, 0)),
												new Person("Cousin10", 'F', null,
														LocalDateTime.of(1986, 8, 22, 0, 0)) },
										LocalDateTime.of(1980, 10, 10, 0, 0)) },
								LocalDateTime.of(1955, 3, 8, 0, 0)) },
						LocalDateTime.of(1950, 8, 12, 0, 0)) },
				LocalDateTime.of(1920, 12, 25, 0, 0));

		String result = new TeknonymyService().getTeknonymy(person);
		String expected = "great-great-great-great-grandfather of Cousin3";
		assertEquals(result, expected);
	}
}
