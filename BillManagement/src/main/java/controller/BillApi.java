package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserApi
 */
@WebServlet("/BillApi")
public class BillApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BillDao BillDao = new BillDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String output = BillDao.addBillDetails(
				request.getParameter("bill_userId"),
				request.getParameter("bill_billId"),
				request.getParameter("bill_date"),
				request.getParameter("bill_arrears"),
		 		request.getParameter("bill_amount"),
		 		request.getParameter("bill_totalPayble"),
		 		request.getParameter("bill_EmpID"));
		
		response.getWriter().write(output);

	}


	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Map paras = getParasMap(request);
		boolean output = BillDao.updateBillDetails(
				paras.get("Newdate").toString(),
				paras.get("Newarrears").toString(),
				paras.get("Newamount").toString(),
				paras.get("NewtotalPayble").toString(),
				paras.get("BillId").toString());
		
		response.getWriter().println(output);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map paras = getParasMap(request);
		boolean output = BillDao.deleteBillDetails(
				paras.get("BillId").toString());
		response.getWriter().println(output);

	}

	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}


}
