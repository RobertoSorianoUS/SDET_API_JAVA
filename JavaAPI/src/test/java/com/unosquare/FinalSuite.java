package com.unosquare;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import files.ReUsableMethods;

public class FinalSuite {
	
	ReUsableMethods apiCore;

	@Test
	public void getListUsers() {
		ReUsableMethods.GetMethod("api/users?page=2", 200);
	}
	
	@Test
	public void getSingletUser() {
		ReUsableMethods.GetMethod("/api/users/2", 200);
	}
	
	@Test
	public void getSingletUserNotFound() {
		ReUsableMethods.GetMethod("/api/users/23", 404);
	}
	
	@Test
	public void getListResource() {
		ReUsableMethods.GetMethod("/api/unknown", 200);
	}
	
	@Test
	public void getSingleResource() {
		ReUsableMethods.GetMethod("/api/unknown/2", 200);
	}
	
	@Test
	public void getSingleResourceNotFound() {
		ReUsableMethods.GetMethod("/api/unknown/23", 404);
	}
	
	@Test
	public void putUpdate() throws IOException, ParseException {
		ReUsableMethods.PutMethod("..\\JavaAPI\\src\\test\\java\\json\\Update.json", "/api/users/2", 200);
	}
	
	@Test
	public void postCreate() throws IOException, ParseException {
		ReUsableMethods.Api("..\\JavaAPI\\src\\test\\java\\json\\Create.json", "/api/users", 201);	
	}
	
	@Test
	public void postRegisterSuccesful() throws IOException, ParseException {
		ReUsableMethods.Api("..\\JavaAPI\\src\\test\\java\\json\\Register.json", "/api/register", 200);	
	}
	
	@Test
	public void postRegisterUnsuccesful() throws IOException, ParseException {
		ReUsableMethods.Api("..\\JavaAPI\\src\\test\\java\\json\\UnsucessfulRegister.json", "/api/register", 400);	
	}
	
	@Test
	public void postLoginSuccesful() throws IOException, ParseException {
		ReUsableMethods.Api("..\\JavaAPI\\src\\test\\java\\json\\Login.json", "/api/login", 200);	
	}
	
	@Test
	public void postLoginUnsuccesful() throws IOException, ParseException {
		ReUsableMethods.Api("..\\JavaAPI\\src\\test\\java\\json\\UnsucessfulLogin.json", "/api/login", 400);	
	}
	@BeforeSuite
	public void beforeSuite() {
		
		apiCore = new ReUsableMethods();
	}
}
