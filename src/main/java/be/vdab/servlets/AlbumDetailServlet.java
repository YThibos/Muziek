package be.vdab.servlets;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.AlbumService;

/**
 * Servlet implementation class AlbumDetailServlet
 */
@WebServlet("/albumDetail.htm")
public class AlbumDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/albumdetail.jsp";
	
	private final transient AlbumService albumService = new AlbumService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			
			try {
			request.setAttribute("album", albumService.read(Long.parseLong(request.getParameter("id"))));
			}
			catch (NumberFormatException ex) {
				request.setAttribute("fouten", Collections.singletonMap("album", "Geen geldig album id opgegeven"));
			}
			
		}

		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
