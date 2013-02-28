package org.example.kickoff.view.general;

import static org.omnifaces.util.Messages.addGlobalError;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

import org.omnifaces.security.jaspic.Jaspic;

@Named
@RequestScoped
public class LoginBean {

	private String loginUserName;
	private String loginPassword;
	private boolean rememberMe;

	public void login() throws IOException, ServletException {

		boolean authenticated = Jaspic.authenticate(loginUserName, loginPassword, rememberMe);

		if (!authenticated) {
			addGlobalError("Login failed");
		}
	}

	public void logout() throws ServletException {
		Jaspic.logout();
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

}