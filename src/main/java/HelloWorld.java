import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("**************GET");
        resp.setContentType("text/html");

        int[]result = new int [2];
        PrintWriter pw = resp.getWriter();
        pw.append("<!DOCTYPE html><head><script src=\"https://cdn.jsdelivr.net/npm/vue/dist/vue.js\"></script>" +
               "</head>" +
                "<div id=\"app\">\n" +
                "  {{ message }}\n" +
                "</div>" +
                        "<script>" +
                        "var app = new Vue({\n" +
                        "  el: '#app',\n" +
                        "  data: {\n" +
                        "    message: 'Hello Vue!'\n" +
                        "  }})" +
                        "</script>"+
                "</html>");

    }

        @Override
        public void init() throws ServletException {
            super.init();
        }

    @Override
    public void destroy() {
        super.destroy();
    }
}
