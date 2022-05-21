
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Adicao;
import negocio.Calculo;
import negocio.Divisao;
import negocio.Multiplicacao;
import negocio.Subtracao;


@WebServlet(name = "ServletCalculo", urlPatterns = {"/ServletCalculo"})
public class ServletCalculo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCalculo</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if (request.getParameter("num1") != null && request.getParameter("num2").length() > 0){
                float v1 = Float.parseFloat(request.getParameter("num1")), 
                      v2 = Float.parseFloat(request.getParameter("num2"));
                Calculo objCalculadora = null;
                // verifica a operação desejada
                switch(request.getParameter("btnCalcular")){
                    // via upcasting, utiliza apenas um único objeto para qualquer das operações
                    case "+": objCalculadora = new Adicao(v1, v2); break;
                    case "-": objCalculadora = new Subtracao(v1, v2); break;
                    case "x": objCalculadora = new Multiplicacao(v1, v2); break;
                    case "/": objCalculadora = new Divisao(v1, v2); break;
                }
                objCalculadora.calcular();
                float resultado = objCalculadora.getResultado();
                RequestDispatcher rd = request.getRequestDispatcher("exibeResultado.jsp");
                // inclui o resultado da média como atributo do "request"
                request.setAttribute("resultado", resultado);
                rd.forward(request, response);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
