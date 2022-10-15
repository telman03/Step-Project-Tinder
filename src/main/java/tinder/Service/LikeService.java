package tinder.Service;


import tinder.DAO.LikeDaoDB;
import tinder.DAO.UserDaoDB;
import tinder.DAO.MessageDaoDB;

import tinder.Entity.User;
import tinder.Entity.Message;
import tinder.Entity.Like;

import java.util.ArrayList;
import java.util.List;

public class LikeService {
    private final LikeDaoDB likeDaoDB = new LikeDaoDB();
    private final UserDaoDB userDaoDB = new UserDaoDB();

    public List<User> getAllLikedUsers(int id){
        List<Like> likes = likeDaoDB.getAll();
        List<User> users = new ArrayList<>();
        for(Like like : likes){
            if(like.getFrom() == id) users.add(userDaoDB.get(like.getTo()));
        }
        return users;
    }

    public List<Like> getAllLikes(){
        return likeDaoDB.getAll();
    }

    public void removeLike(Like like){
        likeDaoDB.remove(like);
    }

    public void insertLike(Like like){
        likeDaoDB.insert(like);
    }
}
