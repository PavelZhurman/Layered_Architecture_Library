package by.company.library.main;

import by.company.library.bean.User;
import by.company.library.controller.Controller;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.exception.DAOException;
import by.company.library.dao.impl.UserDaoImpl;

public class Main {

	public static void main(String[] args) {
		
		
		Controller controller = new Controller();
		String response = controller.doAction("LOGINATION User1 Password1");
		
		System.out.println(response);
		
		
//		System.out.println(response = controller.doAction("REGISTRATION  cat  123"));
//		System.out.println(response = controller.doAction("REGISTRATION  cat1  123"));
//		System.out.println(response = controller.doAction("REGISTRATION  cat2  123"));
//		System.out.println(response = controller.doAction("REGISTRATION  cat3 123"));
		

//			UserDaoImpl udi = new UserDaoImpl();
//			try {
//				udi.registerUser("make", "sound");
//			} catch (DAOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			

	}

}
