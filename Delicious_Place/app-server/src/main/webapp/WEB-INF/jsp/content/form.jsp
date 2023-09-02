<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>딜리셔스 플레이스</title>
</head>

<style>
h1 {text-align: center;}
div {text-align: center;}
.button {
  background-color: #090;
  border: none;
  color: black;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 16px;
}
.center{
  margin-left: auto;
  margin-right: auto;
}
</style>
<body>
<div>
<h1>리뷰 추가하기</h1>
<form action='/content/add.jsp' method="post">
<table border="1" class="center">
<tr>
  <th>가게 이름</th> <td style="width:200px;"><input type='text' name='storeName'></td>
</tr>
<tr>
  <th>내용</th> <td><textarea name="contents" rows='5' cols='30'></textarea></td>
</tr>
<tr>
  <th>먹은 메뉴</th> <td><input type='text' name='eatMenu'></td>
</tr>
<tr>
  <th>별점</th> <td>
   <select name="starRating">
      <option value=5>⭐⭐⭐⭐⭐</option>
      <option value=4>⭐⭐⭐⭐</option>
      <option value=3>⭐⭐⭐</option>
      <option value=2>⭐⭐</option>
      <option value=1>⭐️</option>
    </select>
  </td>
</tr>

<tr>
  <th>영수증 여부</th> <td>
   <select name="hasReceipt">
      <option value=1>있음</option>
      <option value=0>없음</option>
    </select>
  </td>
</tr>

</table>
<button class="button">등록</button>
</form>
</div>
</body>
</html>






