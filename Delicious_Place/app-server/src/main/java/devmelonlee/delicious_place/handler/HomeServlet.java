package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  final String clientId = InitServlet.naverMapsConfig.getClientId();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
    out.println(
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no\">");
    out.printf(
        "<script type=\"text/javascript\" src=\"https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=%s\"></script>",
        clientId);
    out.println("<title> 🍔 딜리셔스 플레이스 - 메인 🍣 ️</title>");
    out.println("</head>");

    out.println("<style>");
    out.println("h1 {");
    out.println("  text-align: center;");
    out.println("  padding: 50px;");
    out.println("}");
    out.println("div {");
    out.println("  text-align: center;");
    out.println("  padding: 30px;");
    out.println("}");
    out.println(".button {");
    out.println("  background-color: #DDD;");
    out.println("  border: none;");
    out.println("  color: black;");
    out.println("  padding: 10px 20px;");
    out.println("  text-align: center;");
    out.println("  text-decoration: none;");
    out.println("  display: inline-block;");
    out.println("  margin: 4px 2px;");
    out.println("  cursor: pointer;");
    out.println("  border-radius: 16px;");
    out.println("}");
    out.println(".center {");
    out.println("  margin-left: auto;");
    out.println("  margin-right: auto;");
    out.println("}");
    out.println("</style>");

    out.println("<body>");
    out.println("<h1>딜리셔스 플레이스</h1>");
    out.println("<div>");
    out.println(
        "  <button class=\"button\" type=\"button\" onclick=\"location.href='/content/list'\">맛집리뷰</button>");
    out.println(
        "  <button class=\"button\" type=\"button\" onclick=\"location.href='/gather/list'\">같이 먹으러가요 - 게더</button>");
    out.println(
        "  <button class=\"button\" type=\"button\" onclick=\"location.href='/auth/form.html'\">로그인</button>");
    out.println(
        "  <button class=\"button\" type=\"button\" onclick=\"location.href='/auth/logout.html'\">로그아웃</button>");
    out.println(
        "  <button class=\"button\" type=\"button\" onclick=\"location.href='/auth/form.html'\">회원 가입하러가기</button>");
    out.println("</div>");
    out.println("<div id=\"map\" style=\"width:100%;height:400px;\"></div>");
    out.println("<script>");
    out.println("function init() {");
    out.println("    window.navigator.geolocation.getCurrentPosition(current_position);");
    out.println("}");
    out.println("");
    out.println("function current_position(position) {");
    out.println("    var msg;");
    out.println(
        "    msg = \"Latitude: \" + position.coords.latitude + \", \" + \"Longitude: \" + position.coords.longitude;");
    out.println("    var latitude = position.coords.latitude;");
    out.println("    var longitude = position.coords.longitude;");
    out.println("    var mapOptions = {");
    out.println("        center: new naver.maps.LatLng(latitude, longitude),");
    out.println("        zoom: 16,");
    out.println("        zoomControl: true");
    out.println("    };");
    out.println("    var map = new naver.maps.Map('map', {");
    out.println("        center: new naver.maps.LatLng(latitude, longitude),");
    out.println("        zoom: 16");
    out.println("    });");
    out.println("}");
    out.println("window.addEventListener(\"load\", init);");
    out.println("</script>");
    out.println("<script>");
    out.println("window.navermap_authFailure = function () {");
    out.println("    // 인증 실패 시 처리 코드 작성");
    out.println("    // ...");
    out.println("}");
    out.println("</script>");
    out.println("</body>");
    out.println("</html>");

  }

}
