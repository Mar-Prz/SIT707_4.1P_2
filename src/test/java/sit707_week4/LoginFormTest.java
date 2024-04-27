package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Mark Przybylkiewicz
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "216293263";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mark Przybylkiewicz";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	
	@Test
    public void testFailEmptyUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login(null, "wrongpassword");
        Assert.assertTrue("Login should fail with empty username and wrong password", status.isLoginSuccess()== false);
    }

    @Test
    public void testFailEmptyUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "Mark216293263"); 
        Assert.assertTrue("Login should fail with empty username and correct password", status.isLoginSuccess()== false);
    }

    @Test
    public void testFailWrongUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("wrongusername", null);
        Assert.assertTrue("Login should fail with wrong username and empty password", status.isLoginSuccess() == false);
    }

    @Test
    public void testFailWrongUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login("wrongusername", "wrongpassword");
        Assert.assertTrue("Login should fail with wrong username and wrong password", status.isLoginSuccess()== false);
    }

    // ... Continue to add test cases for each condition in your decision table ...

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("Mark", "Mark216293263"); // Replace with correct values
        Assert.assertTrue("Login should succeed with correct username and password", status.isLoginSuccess());
    }
    
    @Test
    public void testFailWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("wrongusername", "Mark216293263");
        Assert.assertTrue("Login should fail with wrong username and correct password", status.isLoginSuccess()== false);
    }
    
    @Test
    public void testFailCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("Mark", "");
        Assert.assertTrue("Login should fail with correct username and empty password", status.isLoginSuccess()== false);
    }

    @Test
    public void testCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("Mark", "wrongpassword");
        Assert.assertTrue("Login should fail with correct username and wrong password", status.isLoginSuccess()== false);
    }

	@Test
    public void testCorrectUsernamePasswordAndWrongValidationCode() {
        LoginStatus status = LoginForm.login("Mark", "Mark216293263");
        Assert.assertTrue("Login should succeed with correct username and password", status.isLoginSuccess());
        boolean validation = LoginForm.validateCode("wrongcode");
        Assert.assertFalse("Validation should fail with wrong code", validation);
    }

    @Test
    public void testCorrectUsernamePasswordAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("Mark", "Mark216293263");
        Assert.assertTrue("Login should succeed with correct username and password", status.isLoginSuccess());
        boolean validation = LoginForm.validateCode("123456");
        Assert.assertTrue("Validation should succeed with correct code", validation);
    }


}

