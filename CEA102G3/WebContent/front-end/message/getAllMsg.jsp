<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.*"%>
<%@ page import="redis.clients.jedis.*"%>
<%@ page import="java.util.Set"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get All Message</title>
</head>
<body>
	<% 
		JedisPool jedisPool = JedisPoolUtil.getJedisPool();
		Jedis jedis = null;
		jedis = jedisPool.getResource();
		jedis.auth("123456");
		
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		String memberName = memberVO.getName();
		Set<String> keys = jedis.keys(memberName+"*");
		
	%>
	<table>
		<tr>
            <th>訊息列表</th>
        </tr>
        
        <% 
        for (String key : keys) {
			System.out.println("key=>"+key);
			System.out.println("value:"+jedis.lrange(key, 0, -1));
		}
        %>
        
        <tr>
            <td></td>
        </tr>
	</table>
</body>
</html>