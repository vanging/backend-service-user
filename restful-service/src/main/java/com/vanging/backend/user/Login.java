package com.vanging.backend.user;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String finalResponse;

        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if(account == null || password == null)
        {
            ErrorResponse res = new ErrorResponse();
            res.setStatus("param_check_failed");

            finalResponse = JSON.toJSONString(res);
        }
        else
        {
            OKResponse res = new OKResponse();
            res.setStatus("ok");
            res.getMessage().setSession(account + password);

            finalResponse = JSON.toJSONString(res);
        }

        response.setHeader("Content-Type", "application/json");
        PrintWriter out = response.getWriter();
        out.print(finalResponse);
    }

}

class OKResponse
{
    private String status;
    private LoginMessage message;

    OKResponse()
    {
        this.status = "";
        this.message = new LoginMessage();
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public LoginMessage getMessage()
    {
        return this.message;
    }

    public void setMessage(LoginMessage message)
    {
        this.message = message;
    }
}

class ErrorResponse
{
    private String status;
    private String message;

    ErrorResponse()
    {
        this.status = "";
        this.message = "";
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}

class LoginMessage
{
    private String session;

    LoginMessage()
    {
        this.session = "";
    }

    public String getSession()
    {
        return this.session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }
}

