package webservice.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import webservice.dao.PricebookEntryDAO;
import webservice.database.Database;
import webservice.model.Pricebook;
import webservice.model.PricebookEntry;
import webservice.model.Product;
import webservice.util.Utils;

/**
 * Servlet implementation class PricebookEntryAPI
 */
@WebServlet("/PricebookEntryAPI")
public class PricebookEntryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PricebookEntryAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Utils.setAccessControlHeaders(response);
		
		Type type = new TypeToken<List<PricebookEntry>>(){}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(PricebookEntryDAO.getAll(), type);
		
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("POST => PRICEBOOKENTRY");
		
		Product product = Database.products.stream().
				filter(item -> item.code == Integer.valueOf(request.getParameter("product"))).
				findFirst().
				get();
		Pricebook pricebook = Database.pricebooks.stream().
				filter(item -> item.code == Integer.valueOf(request.getParameter("product"))).
				findFirst().
				get();
		
		PricebookEntry pricebookEntry = new PricebookEntry(
			Database.code_pricebookEntry,
			product,
			pricebook,
			Double.valueOf(request.getParameter("price"))
		);
		PricebookEntryDAO.insert(pricebookEntry);
		
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer code = Integer.valueOf(request.getParameter("code"));
		PricebookEntryDAO.delete(code);
		
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
