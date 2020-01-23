/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-01-16 01:37:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.sjproject.member.model.vo.Member;

public final class changePwd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/views/member/../common/header.jsp", Long.valueOf(1579074557701L));
    _jspx_dependants.put("/WEB-INF/views/member/sideMenu.jsp", Long.valueOf(1578978720704L));
    _jspx_dependants.put("/WEB-INF/views/member/../common/footer.jsp", Long.valueOf(1578635194000L));
    _jspx_dependants.put("/WEB-INF/views/member/../common/nav.jsp", Long.valueOf(1578635194000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.sjproject.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>내정보</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("\t#content-main{\r\n");
      out.write("\theight: 830px;}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\" id=\"content-main\">\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");

	String msg = (String)session.getAttribute("msg");
	Member loginMember = (Member)session.getAttribute("loginMember");
	
	// C6) 쿠키 사용을 위한 변수 생성 
	boolean save = false; // 아이디 저장 체크박스 값을 수정하기 위한변수
	String saveId = ""; // 쿠키게 저장된 saveId라는 키가 가지고 있는 값을 저장할 변수
	Cookie[] cookies = request.getCookies(); // 전달받은 쿠키 저장
	
	// 서버 첫 시작시 request.getCookies()의 값이 null
	// -> if문으로 처리하지 않는경우 페이지 로딩시 NullPointException이 발생됨
	if(cookies != null){
		for(Cookie c : cookies){
			// 쿠키 객체에서 name을 얻어와 그 값이 "saveId"와 같은지 비교
			//		== key, 속성
			if(c.getName().equals("saveId")){
				saveId = c.getValue();
				save = true;
				
				// 클라이언트 : 서버에게 전달받은 쿠키와 안의 sessiondId를 갖고있음.
				// 서버 : 쿠키를 생성해서 안에 sessionId를 저장하여 클라이언트에게 전달
			}
			
		}
	}
	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\"\r\n");
      out.write("\t\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\t<link rel=\"stylesheet\"\r\n");
      out.write("\t\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n");
      out.write("\t\tintegrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t// 로그인 실패 메세지 출력 후 \r\n");
      out.write("\t\t// session에 남아있는 \"msg\" 속성 제거\r\n");
      out.write("\t\t");
 if(msg != null){ 
      out.write(" // 로그인이 실패한 경우\r\n");
      out.write("\t\t\talert(\"");
      out.print( msg );
      out.write("\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t");
  
				session.removeAttribute("msg");
			}
		
      out.write("\r\n");
      out.write("\t</script>\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header class=\"blog-header\">\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tclass=\"row flex-nowrap justify-content-between align-items-center\">\r\n");
      out.write("\t\t\t<div class=\"col-4 pt-1\">\r\n");
      out.write("\t\t\t\t<a class=\"text-muted\" href=\"");
      out.print( request.getContextPath());
      out.write("\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- 서버ip:8080/sjproject -->\r\n");
      out.write("\t\t\t\t<img src=\"https://www.iei.or.kr/resources/images/common/top_logo.jpg\"\r\n");
      out.write("\t\t\t\t\theight=\"60px\">\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t");
 if(loginMember == null){ 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"col-4 d-flex justify-content-end align-items-center\">\r\n");
      out.write("\t\t\t\t<a id=\"modal-120930\" href=\"#modal-container-120930\" role=\"button\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-sm btn-outline-secondary\" data-toggle=\"modal\">로그인</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"modal fade\" id=\"modal-container-120930\" role=\"dialog\"\r\n");
      out.write("\t\t\t\t\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"modal-title\" id=\"myModalLabel\">로그인 모달창</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span aria-hidden=\"true\">×</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<form class=\"form-signin\" method=\"POST\" action=\"");
      out.print( request.getContextPath());
      out.write("/member/login.do\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tonsubmit=\"return loginValidate();\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- 갱신이벤트  -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"memberId\" name=\"memberId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"아이디\" value=\"");
      out.print( saveId);
      out.write("\"> <br> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"memberPwd\" name=\"memberPwd\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"비밀번호\"> <br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"checkbox mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input type=\"checkbox\" id=\"save\" name=\"save\" ");
      out.print( save ? "checked" :"" );
      out.write("> 아이디 저장\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">로그인</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"btn btn-lg btn-secondary btn-block\" href=\"");
      out.print(request.getContextPath() );
      out.write("/member/signUpForm.do\">회원가입</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-dismiss=\"modal\">Close</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"d-flex justify-content-end align-items-center\">\r\n");
      out.write("\t\t\t\t\t");
      out.print( loginMember.getMemberName());
      out.write("님 환영합니다. &nbsp;\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/mypage.do\" role=\"button\" class=\"btn btn-sm btn-outline-secondary\">마이페이지</a>\r\n");
      out.write("\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/logout.do\" role=\"button\" class=\"btn btn-sm btn-outline-secondary\">로그아웃</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t// 로그인 유효성 검사\r\n");
      out.write("\t\tfunction loginValidate(){\r\n");
      out.write("\t\t\t// trim() : 문자열 앞뒤 공백 제거\r\n");
      out.write("\t\t\tif( $(\"#memberId\").val().trim().length == 0){\r\n");
      out.write("\t\t\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t\t\t$(\"#memberId\").focus();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif( $(\"#memberPwd\").val().trim().length == 0){\r\n");
      out.write("\t\t\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t\t\t$(\"#memberPwd\").focus();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <nav class=\"nav-scroller py-1 mb-2\">\r\n");
      out.write("      <ul class=\"nav justify-content-center\">\r\n");
      out.write("        <li class=\"nav-item col-md text-center\">\r\n");
      out.write("          <a class=\"nav-link active\" href=\"#\">공지사항</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item col-md text-center\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"#\">게시판</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item col-md text-center\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"#\">Q & A</a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("<div class=\"col-sm-4 mt-5\">\r\n");
      out.write("\t<h3>사이드 메뉴</h3>\r\n");
      out.write("\t<ul class=\"list-group\">\r\n");
      out.write("\t\t<li class=\"list-group-item list-group-item-action\"><a href=\"mypage.do\">내정보</a></li>\r\n");
      out.write("\t\t<li class=\"list-group-item list-group-item-action\"><a href=\"changePwd.do\">비밀번호 변경</a></li>\r\n");
      out.write("\t\t<li class=\"list-group-item list-group-item-action\"><a href=\"secession.do\">회원 탈퇴</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t<h3>비밀번호 변경</h3>\r\n");
      out.write("\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t<div class=\"bg-white rounded shadow-sm container p-3\">\r\n");
      out.write("\t\t\t\t\t<form class=\"form-horizontal\" role=\"form\" method=\"POST\" action=\"updatePwd.do\" onsubmit=\"return validate();\">\r\n");
      out.write("\t\t\t\t\t\t<!-- 아이디 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row mb-3 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6>아이디</h6>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 id=\"id\">");
      out.print( loginMember.getMemberId() );
      out.write("</h5>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t\t\t<!-- 현재 비밀번호 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row mb-3 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6>현재 비밀번호</h6>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"currentPwd\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"currentPwd\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- 새 비밀번호 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row mb-3 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6>새 비밀번호</h6>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"newPwd1\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"newPwd1\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- 새 비밀번호 확인-->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row mb-3 form-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6>새 비밀번호 확인</h6>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"newPwd2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"newPwd2\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<hr class=\"mb-4\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"btn btn-primary btn-lg btn-block\" type=\"submit\">변경하기</button>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <footer class=\"text-muted\" >\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <p class=\"float-right\">\r\n");
      out.write("          <a href=\"#\">Back to top</a>\r\n");
      out.write("        </p>\r\n");
      out.write("        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>\r\n");
      out.write("        <p>New to Bootstrap? <a href=\"{{ site.url }}/\">Visit the homepage</a> or read our <a href=\"{{ site.baseurl }}/docs/{{ site.docs_version }}/getting-started/introduction/\">getting\r\n");
      out.write("            started guide</a>.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(\".phone\").on(\"input\", function() {\r\n");
      out.write("\t\t\tif ($(this).val().length > $(this).prop(\"maxLength\")) {\r\n");
      out.write("\t\t\t\t$(this).val($(this).val().slice(0, $(this).prop(\"maxLength\")));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t// submit 동작\r\n");
      out.write("\t\tfunction validate() {\r\n");
      out.write("\t\t\t// 비밀번호 유효성 검사\r\n");
      out.write("\t\t\t// 영어 대,소문자 + 숫자, 총 6~12글자\r\n");
      out.write("\t\t\tvar regExp = /^[A-Za-z\\d]{6,12}$/;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(!regExp.test($ (\"#newPwd1\").val() )){\r\n");
      out.write("\t\t\t\talert(\"유효하지 않은 비밀번호 입니다.\");\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#newPwd1\").val(\"\");\r\n");
      out.write("\t\t\t\t$(\"#newPwd1\").focus();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 새 비밀번호 일치여부 확인\r\n");
      out.write("\t\t\tif($(\"#newPwd1\").val() != $(\"#newPwd2\").val()){\r\n");
      out.write("\t\t\t\talert(\"새 비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("\t\t\t\t$(\"#newPwd2\").val(\"\");\r\n");
      out.write("\t\t\t\t$(\"#newPwd2\").focus();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
