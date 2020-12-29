package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.MainPage;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserAccessTests extends CommonConditions {
	@Test
	public void oneCanLoginMaiki() throws InterruptedException {
		User testUser = UserCreator.withCredentialsFromProperty();

		String loggedInUserName = new MainPage(driver)
				.openPage()
				.registration(testUser)
				.getLoggedInUserName();
		assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
	}
}
