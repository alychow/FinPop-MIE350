/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.64
 * Generated at: 2016-10-31 22:36:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/navbar.jsp", Long.valueOf(1477953038000L));
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1477953038000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style/theme.css\">\n");
      out.write("\n");
      out.write("<title>MIE350 Sample Database Web App</title>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      out.write("<nav>\n");
      out.write("\t<center>\n");
      out.write("\t\t<h1>MIE350 Sample Database Web App</h1>\n");
      out.write("\t</center>\n");
      out.write("\t<ul id=\"nav\">\n");
      out.write("\t\t<li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("\t\t<li><a href=\"about.jsp\">About</a></li>\n");
      out.write("\t\t<li><a href=\"/SimpleDBExample/UserController?action=listUser\" />Users\n");
      out.write("\t\t\tin DB</a></li>\n");
      out.write("\t\t<li><a href=\"searchUser.jsp\">Search A User</a></li>\n");
      out.write("\t\t<li><a href=\"helpful_links.jsp\">Other Links</a>\n");
      out.write("\t\t\t<ul id=\"nav\">\n");
      out.write("\t\t\t\t<li><a href=\"sample_html.jsp\">Sample HTML Tags</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"http://www.w3schools.com/html/default.asp\">HTML Tutorial</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"http://www.w3schools.com/bootstrap/\">BootStrap CSS Tutorial</a></li>\n");
      out.write("\t\t\t</ul></li>\n");
      out.write("\t\t\t<li><a href=\"contact.jsp\">Contact</a></li>\n");
      out.write("\t\t\t<li><a href=\"TEST.jsp\">INSERT</a></li>\n");
      out.write("\t</ul>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\n");
      out.write("\t\tWelcome!<br>\n");
      out.write("\t\t<br> In this project, your team will design and build a web\n");
      out.write("\t\tapplication. A web application is a software application that is\n");
      out.write("\t\taccessed over the Internet using standard browsers (e.g. Internet\n");
      out.write("\t\tExplorer, Mozilla Firefox). Examples of web application would be\n");
      out.write("\t\tonline-shopping, web banking, stock exchange and many others. Each\n");
      out.write("\t\tmember of the team is expected to contribute equally to the project\n");
      out.write("\t\tthough there may be a variety of different roles.\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t");
      out.write("<div id=\"footer\">\n");
      out.write("\t<ul class=\"bottom\">\n");
      out.write("\t\tThis sample web app is for demonstration purposes only.\n");
      out.write("\t\t<br> MIE350 Sample Web Application &#169;\n");
      out.write("\t\t");
      out.print(new java.text.SimpleDateFormat("yyyy")
					.format(new java.util.Date()));
      out.write("\n");
      out.write("\t\tUniversity of Toronto<br>\n");
      out.write("\t</ul>\n");
      out.write("</div>");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
