package es.unizar.sisinf.controller;
import es.unizar.sisinf.controller.CorreosGmail;
public class CorreosGmailMain {
	public static void main(String[] args)
	{
		new CorreosGmail().enviarConGMail("jsalamerosanz@gmail.com", "pintielMaricon", "adios");
		System.out.println("yaaaa");
	}
}
