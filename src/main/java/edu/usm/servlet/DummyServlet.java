package edu.usm.servlet;

import edu.usm.service.AwesomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DummyServlet", urlPatterns = {"/"})
public class DummyServlet extends HttpServlet {

    @Autowired
    private AwesomeService myserviceOrDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        this.myserviceOrDao = (AwesomeService) ac.getBean("notBadService");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append(myserviceOrDao.pleaseReturnSomething());
    }
}
