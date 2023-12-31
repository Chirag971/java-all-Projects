/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;

import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebFilter(filterName = "AuthernticationFilter", urlPatterns = {"/*"})
public class AuthernticationFilter implements Filter {

    @Inject
    SecurityContext ctx;

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AuthernticationFilter() {
    }

    private void doBeforeProcessing(ServletRequest hrequest, ServletResponse hresponse)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) hrequest;
        HttpServletResponse response = (HttpServletResponse) hresponse;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null) {
            Credential credential = new UsernamePasswordCredential(username, new Password(password));

//            AuthenticationStatus status = ctx.authenticate(request, response, AuthenticationParameters.withParams());
            AuthenticationStatus status = ctx.authenticate(request, response, withParams().credential(credential));

            // ... (your existing code)
            if (status == AuthenticationStatus.SUCCESS) {
                if (request.getRequestURI().contains("index")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("password", username);

                    if (ctx.isCallerInRole("Admin")) {
                        System.out.println("User is in Admin role"); // Debug statement
                        request.setAttribute("user", ctx.getCallerPrincipal().getName());
                        request.getRequestDispatcher("/admin.jsp").forward(request, response);
                    } else if (ctx.isCallerInRole("User")) {
                        System.out.println("User is in User role"); // Debug statement
                        request.setAttribute("user", ctx.getCallerPrincipal().getName());
                        request.getRequestDispatcher("/user.jsp").forward(request, response);
                    } else {
                        System.out.println("User is not in Admin or User role"); // Debug statement
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("error", "Either Username or password is wrong");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

// ... (your existing code)
        }
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("AuthernticationFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {

            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AuthernticationFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthernticationFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthernticationFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
