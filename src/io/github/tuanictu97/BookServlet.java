package io.github.tuanictu97;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet(urlPatterns = "/books")
public class BookServlet extends HttpServlet {
	private DAO dao;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookServlet() {
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	dao = new DAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("action") != null) {
			String action = request.getParameter("action");
			switch (action) {
			case "add":
				System.out.println("show add");
				showAdd(request, response);
				break;
			case "doAdd":
				System.out.println("do add");
				dao.addBook(new Book(request.getParameter("name"), request.getParameter("desc")));
				response.sendRedirect(request.getContextPath()+"/books");
				break;
			case "edit":
				System.out.println("show edit");
				Book book = dao.getBookById(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("book", book);
				showEdit(request, response);
				break;
			case "doEdit":
				System.out.println("do edit");
				System.out.println("desc: "+request.getParameter("desc"));
				dao.updateBook(new Book(Integer.parseInt(request.getParameter("idst")), request.getParameter("name"), request.getParameter("desc")));
				response.sendRedirect(request.getContextPath()+"/books");
				break;
			case "doDelete":
				System.out.println("do delete");
				try {
					dao.deleteBook(Integer.parseInt(request.getParameter("id")));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect(request.getContextPath()+"/books");
				break;
			default:
				showList(request, response);
				break;
			}
			
		}else {
			showList(request, response);
		}
	}
	private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		dispatcher.forward(request, response);
	}
	private void showAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
	}
	private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("books", dao.getListBook());
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
