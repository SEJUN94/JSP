package com.jsp.action.pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.AttachVO;
import com.jsp.service.PdsService;

public class PdsGetFileAction implements Action{
   

   private PdsService pdsService;   
   public void setPdsService(PdsService pdsService) {
      this.pdsService = pdsService;
   }
   
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) 
                                       throws IOException, ServletException{
      String url=null;
      
      try {
         int ano = Integer.parseInt(request.getParameter("ano"));
         
         AttachVO attach = pdsService.getAttachByAno(ano);
         
         String fileName = attach.getFileName();
         String savedPath = attach.getUploadPath();
         
         FileDownloadResolver.sendFile(fileName, savedPath, request, response);
      }catch(Exception e) {
         response.sendError(response.SC_INTERNAL_SERVER_ERROR);
         url=null;
         e.printStackTrace();
      }
      
      return url;
   }

}