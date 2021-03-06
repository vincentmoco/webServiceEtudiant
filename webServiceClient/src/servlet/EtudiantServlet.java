package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.EtudiantProxy;

/**
 * Servlet implementation class EtudiantServlet
 */
@WebServlet("/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/Resultat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomEtudiant");
		String prenom = request.getParameter("prenomEtudiant");
		String idEtudiant = request.getParameter("idEtudiant");
		String action = request.getParameter("options-list");
		EtudiantProxy service = new EtudiantProxy();
		String resultat = null;
		
		if (action.equals("ajouter")) {
			resultat = service.ajouterEtudiant(idEtudiant, prenom, nom);
		} else if (action.equals("lister")) {
			resultat = service.lister();
		}else if (action.equals("supprimer")) {
			resultat = service.supprimerEtudiant(idEtudiant);
		}
		
		request.setAttribute("resultat", resultat);
		doGet(request, response);
	}

}
