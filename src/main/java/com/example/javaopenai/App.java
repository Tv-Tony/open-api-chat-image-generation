package com.example.javaopenai;

import java.util.LinkedList;
import java.util.List;

import com.example.javaopenai.request.ImageRequest;
import com.example.javaopenai.utils.AppConstants;
import com.example.javaopenai.controller.ApiController;
import com.example.javaopenai.request.ChatRequest;
import com.example.javaopenai.request.Message;

public class App 
{
    public static void main( String[] args )
    {

        Message systemMessage = new Message("system", "you are a helpfull assistant");

        Message userMessage = new Message("user", "who is president of usa?");

        List<Message> messageList = new LinkedList<>();
        messageList.add(systemMessage);
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setModel("dall-e-3");
        imageRequest.setPrompt("A person");
        imageRequest.setN(1);
        imageRequest.setSize("1024x1024");
        messageList.add(userMessage);

         ChatRequest chatRequest = new ChatRequest(messageList, AppConstants.CHAT_GPT_MODEL);

        ApiController controller = new ApiController();
         //controller.chat(chatRequest);
        controller.image(imageRequest);

        
    }
}
