package com.sourceit.survey.controller.common;

import com.sourceit.survey.dto.RegistrationDto;
import com.sourceit.survey.utils.MappingUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RegistrationDto dto = MappingUtils.getObjectFromRequest(req, RegistrationDto.class);
        
        
        
        
        req.setAttribute("regDto", dto);
        req.getRequestDispatcher("WEB-INF/jsp/common/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("regDto", new RegistrationDto());
        req.getRequestDispatcher("WEB-INF/jsp/common/registration.jsp").forward(req, resp);
    }
}
