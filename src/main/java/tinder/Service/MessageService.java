package tinder.Service;

import tinder.DAO.*;
import tinder.Entity.Message;

import java.util.List;

public class MessageService {
    private final MessageDaoDB messageDaoDatabase = new MessageDaoDB();

    public List<Message> getAllMessages(int sender, int receiver){
        return messageDaoDatabase.getAllMessages(sender, receiver);
    }

    public void insertMessage(Message message){
        messageDaoDatabase.insert(message);
    }
}
