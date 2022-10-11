package IES.lab21;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/WelcomeServlet"})

public class MyServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -1915463532411657451L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        if (username == null) {
            throw new NullPointerException("Please enter a username!");
        }
        else {
            try {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>WelcomeServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Hello " + username + "! Welcome to my app.</h2>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }
    }
}
