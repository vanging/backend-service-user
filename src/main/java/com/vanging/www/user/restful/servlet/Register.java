package com.vanging.www.user.restful.servlet;

import com.alibaba.fastjson.JSON;
import com.vanging.www.user.persistence.Action;
import com.vanging.www.user.restful.response.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Response finalResponse = new Response();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email == null || password == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            if(Action.registerByEmail(email, password))
            {
                finalResponse.setStatus("ok");
            }
            else
            {
                finalResponse.setStatus("fail");
            }
        }
        JSON.writeJSONString(response.getWriter(), finalResponse);
    }
}