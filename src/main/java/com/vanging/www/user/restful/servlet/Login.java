package com.vanging.www.user.restful.servlet;

import com.alibaba.fastjson.JSON;
import com.vanging.www.user.persistence.Action;
import com.vanging.www.user.restful.response.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Response finalResponse = new Response();

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if(account == null || password == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            String result = Action.login(account, password);
            finalResponse.setMessage(result);
            if(result.equals("account_not_exist") || result.equals("password_not_match") || result.equals("null_password"))
            {
                finalResponse.setStatus(result);
            }
            else
            {
                finalResponse.setStatus("ok");
            }
        }
        JSON.writeJSONString(response.getWriter(), finalResponse);
    }
}