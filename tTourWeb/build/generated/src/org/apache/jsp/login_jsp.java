package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>帳號登入-TTOUR</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("            body{\n");
      out.write("\n");
      out.write("                background: url(\"https://static.pexels.com/photos/7045/pexels-photo.jpeg\");\n");
      out.write("                background-size: cover;\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 0px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            div,span,form,button,input{\n");
      out.write("                font-family: 微軟正黑體;\n");
      out.write("                font-size: 1.05em;\n");
      out.write("                border:2px solid white;\n");
      out.write("                margin: 3px;\n");
      out.write("            }\n");
      out.write("            input,button{\n");
      out.write("                width: 96%;\n");
      out.write("                height: 65px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                border: solid 1px #888;\n");
      out.write("\n");
      out.write("                /*                padding: 20px 27px;*/\n");
      out.write("            }\n");
      out.write("            #btn-fb{\n");
      out.write("                color: white;\n");
      out.write("                background-color: #3b5998;\n");
      out.write("            }\n");
      out.write("            input{\n");
      out.write("                display: block;\n");
      out.write("                height: 20px;\n");
      out.write("                padding: 20px 0px;\n");
      out.write("            }            \n");
      out.write("            .level1{\n");
      out.write("                background: white;\n");
      out.write("                margin: 20px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .level2{\n");
      out.write("/*                background: #999;*/\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .container{\n");
      out.write("                padding: 0px 10px ;\n");
      out.write("                background: white;\n");
      out.write("                width: 450px;\n");
      out.write("                height: 538px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                /*                 box-shadow: 0px 30px 60px -5px #555;*/\n");
      out.write("            }\n");
      out.write("            .bot1{\n");
      out.write("                display: inline-block;\n");
      out.write("                width: 28%;\n");
      out.write("\n");
      out.write("                /*                float: left;*/\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*            button{\n");
      out.write("            \n");
      out.write("                            width: 100%;\n");
      out.write("                            height: 45px;\n");
      out.write("                            padding: 12px;\n");
      out.write("                            margin: 12px 0px 12px 0px;\n");
      out.write("                            border-radius: 4px;\n");
      out.write("                            letter-spacing: normal;\n");
      out.write("                            word-spacing: normal;\n");
      out.write("                            text-align: center;\n");
      out.write("                            background-color: #3498DB;\n");
      out.write("                            border-bottom: 5px solid #2980B9;\n");
      out.write("                            text-shadow: 0px -2px #2980B9;\n");
      out.write("                            cursor: pointer;\n");
      out.write("                        }*/\n");
      out.write("            /*            .form-field{\n");
      out.write("                            height: 60px\n");
      out.write("                        }*/\n");
      out.write("            /*            span{\n");
      out.write("                            \n");
      out.write("                            display: inline-block;\n");
      out.write("                            padding: 8px;\n");
      out.write("                            background-color: white;\n");
      out.write("                        }\n");
      out.write("                        .text{\n");
      out.write("                            border-radius: 4px;\n");
      out.write("                            letter-spacing: normal;\n");
      out.write("                            word-spacing: normal;\n");
      out.write("                            width: 90%;\n");
      out.write("                            padding: 12px;\n");
      out.write("            \n");
      out.write("                        }*/\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\" src=\"jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(init);\n");
      out.write("            function init() {\n");
      out.write("                $(window).resize(resizeHandler);\n");
      out.write("                resizeHandler();\n");
      out.write("            }\n");
      out.write("            function resizeHandler() {\n");
      out.write("                var winWidth = $(window).width();\n");
      out.write("                var winHeight = $(window).height();\n");
      out.write("                $(\".container\").offset({left: (winWidth - 450) / 2, top: (winHeight - 538) / 2});\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"login-box level1\">\n");
      out.write("                <div class=\"social-btn level2\">\n");
      out.write("                    <form action=\"login.fb\" method=\"POST\">\n");
      out.write("                        <button id=\"btn-fb\">使用Facebook帳號登錄</button>\n");
      out.write("                    </form>\n");
      out.write("                    <form action=\"login.goo\" method=\"POST\">\n");
      out.write("                        <button id=\"btn-goog\">使用Google帳號登錄</button>\n");
      out.write("                    </form>\n");
      out.write("<!--                    <div class=\"separator level2\">\n");
      out.write("                                                <span>或</span>\n");
      out.write("                        <hr></div>-->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <form class=\"form-field level2\" action=\"login.do\" method=\"POST\">\n");
      out.write("                    <div class=\"form-field \">\n");
      out.write("                        <input type=\"text\" name=\"account\" class=\"text\"  placeholder=\"請輸入帳號\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-field \">\n");
      out.write("                        <input type=\"text\" name=\"password\" class=\"text\" placeholder=\"請輸入密碼\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"separator \">\n");
      out.write("                        <label>記住我</label>\n");
      out.write("                        <a href=\"\">忘了密碼?</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"login-btn \">\n");
      out.write("                        <button>登錄</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"bottom \">\n");
      out.write("\n");
      out.write("                        <div class=\"bot1 a\">還沒有帳號麼?</div>\n");
      out.write("                        <a class=\"bot1 b\" href=\"\">註冊</a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>                \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
