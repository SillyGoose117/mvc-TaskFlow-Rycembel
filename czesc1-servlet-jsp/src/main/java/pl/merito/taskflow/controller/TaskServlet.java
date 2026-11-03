package pl.merito.taskflow.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task") // Adres pod którym tomacgt będzie szukać servo-something (adres w pasku przeglądarki)
public class TaskServlet extends HttpServlet {

    // GET – np. wejście z paska adresu lub kliknięcie linku
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8"); // Typ kodowania znaków na stronie
        PrintWriter out  = resp.getWriter(); // Obiekt "writer" o nazwie "out" do wypisywania odpowiedzi na stronie
        out.println("<!DOCTYPE html><html><body>"); // Struktura strony html
        out.println("<h1>Witaj w planerze TaskFlow!</h1>");
        //out.println("<p></p>");
        out.println("<a href='index.html'>Powrót</a>"); //Prowadzi do statycznego pliku html
        out.println("</body></html>");
    }

    // POST – wysłanie formularza
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        req.setCharacterEncoding("UTF-8");   // polskie znaki z formularza
        String taskName = req.getParameter("taskName");     // wartość pola name="name"

        resp.setContentType("text/html;charset=UTF-8"); // Uniwersalny encoder znaków
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html><body>");
        out.println("<h1>Cześć, " + taskName + "!</h1>");
        out.println("<p>To jest odpowiedź na żądanie POST.</p>");
        out.println("<a href='index.html'>Powrót</a>");
        out.println("</body></html>");
    }
}
