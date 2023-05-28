package org.example.SILab2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class SILab2Test {

	@Test
	void everyBranchTest() {
		assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
		
		User u = new User("darijansekerov", "darijansekerov!", "darijansekerov.com");
		assertFalse(SILab2.function(u, Arrays.asList(u)));

		User u2 = new User("darijan", "sekerov@", "darijan@sekerov.com");
		assertTrue(SILab2.function(u2, Arrays.asList()));
		
		User u3 = new User(null, "sekerov asd", "darijan@sekerov.com");
		assertFalse(SILab2.function(u3, Arrays.asList(new User("darijan@sekerov.com", "sekerov asd", "darijan@sekerov.com"))));

		User u4 = new User(null, "sekerov asd", "darijan@sekerov.com");
		assertFalse(SILab2.function(u4, Arrays.asList(new User("darijan456@sekerov.com", "sekerov asd", "darijan123@sekerov.com"))));
	
	}
	
	@Test
	void multipleConditionStatement() {
		final List<User> emptyList = new ArrayList<>();		
		assertThrows(RuntimeException.class, () -> SILab2.function(null, emptyList));
		
		final User userWithNullPassword = new User("user", null, null);
		assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullPassword, emptyList));
		
		final User userWithNullEmail = new User("user", "pass", null);
		assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullEmail, emptyList));
		
		final User validUser = new User("user", "pass", "email@email.com");
		assertDoesNotThrow(() -> SILab2.function(validUser, emptyList));
	
	}

}
