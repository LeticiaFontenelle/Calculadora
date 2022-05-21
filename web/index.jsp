
<%@page import="negocio.Divisao"%>
<%@page import="negocio.Multiplicacao"%>
<%@page import="negocio.Subtracao"%>
<%@page import="negocio.Adicao"%>
<%@page import="negocio.Calculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <h3> Turma ADS Manhã - Nome: </h3>
        <br>
        
        <h2>Adicione os valores: </h2>
        <form action="ServletCalculo">
            Valor 1: <input type="text" name="valor1"><br>
            Valor 2: <input type="text" name="valor2"><br>
            <input type='submit' name='btnCalcular' value='+'>
            <input type='submit' name='btnCalcular' value='-'>
            <input type='submit' name='btnCalcular' value='x'>
            <input type='submit' name='btnCalcular' value='/'>
        </form>
        <%
            if(request.getParameter("btnCalcular") != null)
            {
                if(request.getParameter("valor1").length() > 0 && Float.parseFloat(request.getParameter("valor1")) != 0)
                {
                    if(request.getParameter("valor2").length() > 0 && Float.parseFloat(request.getParameter("valor2")) != 0)
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("ServletCalculo");
                        request.setAttribute("valor1", Float.parseFloat(request.getParameter("valor1")));
                        request.setAttribute("valor2", Float.parseFloat(request.getParameter("valor2")));    
                        rd.forward(request, response);
                    }
                    else
                    {
                        out.println("<br><h3>O campo do valor1 não deve ser nulo ou igual a 0 </h3>");
                    }
                }
                else
                {
                    out.println("<br><h3>O campo do valor2 não deve ser nulo ou igual a 0 </h3>");
                }
            }
        %>
    </body>
</html>
