<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<c:choose>
	<c:when test = "${ pro.getProductId() == pic.getProduct_id() }">
		<img alt="${ pic.getAlt() }" src="${ pic.getPicture_src() }" width="${ pic.getWidth() }" height="${ pic.getHeight() }">
	</c:when>
	<c:otherwise>
		<!-- 画像差し込み忘れなどの際に表示する -->
		<img alt="謝罪の写真" src="pic/pic_other/none_pic.jpg" width="300" height="300">
	</c:otherwise>
</c:choose>

	