package com.handier.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.send.IdMessageRecipient;
import com.restfb.types.send.Message;
import com.restfb.types.send.SendResponse;
import com.restfb.types.webhook.WebhookEntry;
import com.restfb.types.webhook.WebhookObject;
import com.restfb.types.webhook.messaging.MessagingItem;

@Controller
@RequestMapping("/webhook")
public class FBchatControler extends HttpServlet {
	private String accessToken = "EAAGccKRuWbMBAHZB4v8ER7OWj2a6fzPWzZC8xoZBKObjckXqZCn8M7A26n3PtdHJ7pEOVdagxfybfQmzb2tYHdOZBHkZAauqlcZA9qTWjsENBUJyHOBt6AE8ZCdJxqQt6HnaZAKMPxJOCl9UwsiZCXct5gvEzm5JUYun8ZBM6mMlWU3ZAVoKPZC3eWCRC";
	private String verifyToken ="handier123";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hubToken = req.getParameter("hub.verify_token");
		String hubChallenge = req.getParameter("hub.changllenge");
		if(verifyToken.equals(hubToken)) {
			resp.getWriter().write(hubChallenge);
			resp.getWriter().flush();
			resp.getWriter().close();
		}
		else {
			resp.getWriter().write("incorrect token");
		}
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = req.getReader();
		String line = "";
		while ( (line = br.readLine()) != null ) {
			sb.append(line);
		}
		JsonMapper mapper = new DefaultJsonMapper();
		WebhookObject webhookObject = mapper.toJavaObject(sb.toString(), WebhookObject.class);
		for (WebhookEntry entry : webhookObject.getEntryList()) {
			if(entry.getMessaging()!= null) {
				for(MessagingItem mItem : entry.getMessaging()) {
					String senderId = mItem.getSender().getId();
					IdMessageRecipient recipient = new IdMessageRecipient(senderId);
					
					// nhan tin nhan
					if(mItem.getMessage() != null && mItem.getMessage().getText() != null)
					{
						SendMessage(recipient, new Message("Hi"));
					}
				}
			}
		}
	}
	
	void SendMessage(IdMessageRecipient recipient, Message message) {
		FacebookClient pageClient = new DefaultFacebookClient(accessToken, Version.VERSION_3_1);

		SendResponse resp = pageClient.publish("me/messages", SendResponse.class,
		     Parameter.with("recipient", recipient), // the id or phone recipient
			 Parameter.with("message", message));
			
	}
	
}
