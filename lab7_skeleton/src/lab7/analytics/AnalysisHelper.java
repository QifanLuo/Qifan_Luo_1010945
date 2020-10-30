/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

/**
 *
 * @author harshalneelkamal
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    
    
    public int getLikesComments(User u){
        List<Comment> comments = u.getComments();
        int likeNumber = 0;       
        for (Comment c : comments) {
            likeNumber += c.getLikes();
        }
        
        return likeNumber;
    }
    public void getAverageLikesPerCommets() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
       
        System.out.println("average of likes per comments: " + likeNumber / commentNumber);
            
    }
    
    
    public void mostLikedCommentsPost(){
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        
        //int likeNumber = 0;
        List<Post> mostlikedPost = new ArrayList<>();
        Map<Post,Integer> postwithCommentliked = new HashMap<>();
        
        for(Post p : posts.values()){
            int likeNum = 0;
            for(Comment c:p.getComments()){
                likeNum = likeNum+c.getLikes();
            }
            postwithCommentliked.put(p, likeNum);
            //System.out.println(p.getPostId()+ "'likeNum : "+likeNum);
        }
        
        
        
        
        List<Map.Entry<Post, Integer>> list = new ArrayList<Map.Entry<Post, Integer>>(postwithCommentliked.entrySet());
        
        list.sort(new Comparator<Map.Entry<Post, Integer>>() {
          @Override
          public int compare(Map.Entry<Post, Integer> o1, Map.Entry<Post, Integer> o2) {
              return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        int commentlikeNum = list.get(0).getValue();
        
        for(Map.Entry<Post,Integer> e:list){
            if(e.getValue() == commentlikeNum)
                mostlikedPost.add(e.getKey());
                      
        }

                
        System.out.println("The post with most liked comments is :");
        
        for(Post p:mostlikedPost){
            System.out.println(p.getPostId()+", ");
        }
        
    }
    
    public void mostCommetsPost(){
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        
        //int likeNumber = 0;
        List<Post> mostPost = new ArrayList<>();
        Map<Post,Integer> postwithComment = new HashMap<>();
        
        for(Post p : posts.values()){
            int postNumber = p.getComments().size();            
            postwithComment.put(p, postNumber);
            //System.out.println(p.getPostId()+ "postNUm : "+postNumber);
        }
        
        
        List<Map.Entry<Post, Integer>> list = new ArrayList<Map.Entry<Post, Integer>>(postwithComment.entrySet());
        
        list.sort(new Comparator<Map.Entry<Post, Integer>>() {
          @Override
          public int compare(Map.Entry<Post, Integer> o1, Map.Entry<Post, Integer> o2) {
              return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        int commentNum = list.get(0).getValue();
        
        for(Map.Entry<Post,Integer> e:list){
            if(e.getValue() == commentNum)
                mostPost.add(e.getKey());
                      
        }

       
        System.out.println("The post with most comments is :");
        
        for(Post p:mostPost){
            System.out.println(p.getPostId()+", ");
        }
        

              
    }
    
    
    public void usersOnPostNum(){
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        
        Map<Integer,Integer> user   = new HashMap<>();//userID, postNum
        
        
        for(Post p:posts.values()){
            
            if(user.containsKey(p.getUserId())){
                int temp = user.get(p.getUserId());
                user.put(p.getUserId(), temp+1);
            }else{
                user.put(p.getUserId(), 1);
            }
        }
        
        
        List<Integer> userID = new ArrayList<>();
        
        
        
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(user.entrySet());
        
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
              return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        //int commentNum = list.get(0).getValue();
        
        for(int i = list.size()-1;i>=list.size()-5;i--){
            userID.add(list.get(i).getKey());
                                 
        }

       
        System.out.println("Top 5 inactive users on posts number are :");
        
        for(int i:userID){
            System.out.println("User ID "+i+", ");
        }
       
    }
    
    
    public void usersOnCommentsNum(){
        
        
        
        Map<Integer,User> users = DataStore.getInstance().getUsers();
        
        Map<Integer,Integer> user   = new HashMap<>();//userID, postNum
        
        
        for(User u :users.values()){
            
            user.put(u.getId(), u.getComments().size());
        }
        
        
        List<Integer> userID = new ArrayList<>();
        
        
        
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(user.entrySet());
        
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
              return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for(int i = list.size()-1;i>=list.size()-5;i--){
            userID.add(list.get(i).getKey());
                                 
        }

       
        System.out.println("Top 5 inactive users on comments number are :");
        
        for(int i:userID){
            System.out.println("User ID "+i+", ");
        }
        
        
        
    }
    
    
    public void usersOnall(){
        
        
        Map<Integer,User> users = DataStore.getInstance().getUsers();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        
        
        Map<Integer,Integer> user   = new HashMap<>();//userID, postNum
        
        
        for(User u :users.values()){
            int commentNum = u.getComments().size();
            int liked = getLikesComments(u);
            
            user.put(u.getId(), commentNum+liked);
        }
        
        for(Post p:posts.values()){            
            if(user.containsKey(p.getUserId())){
                int temp = user.get(p.getUserId());
                user.put(p.getUserId(), temp+1);
            }
        }
        
        
        List<Integer> userID = new ArrayList<>();
        
        
        
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(user.entrySet());
        
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
              return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for(int i = list.size()-1;i>=list.size()-5;i--){
            userID.add(list.get(i).getKey());
                                 
        }

       
        System.out.println("Top 5 inactive users on all :");
        
        for(int i:userID){
            System.out.println("User ID "+i+", ");
        }
        
    }
    
    
    
        public void activeUsersOnall(){
        
        
        Map<Integer,User> users = DataStore.getInstance().getUsers();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        
        
        Map<Integer,Integer> user   = new HashMap<>();//userID, postNum
        
        
        for(User u :users.values()){
            int commentNum = u.getComments().size();
            int liked = getLikesComments(u);
            
            user.put(u.getId(), commentNum+liked);
        }
        
        for(Post p:posts.values()){            
            if(user.containsKey(p.getUserId())){
                int temp = user.get(p.getUserId());
                user.put(p.getUserId(), temp+1);
            }
        }
        
        
        List<Integer> userID = new ArrayList<>();
        
        
        
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(user.entrySet());
        
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
          @Override
          public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
              return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for(int i = 0;i<5;i++){
            userID.add(list.get(i).getKey());
                                 
        }

       
        System.out.println("Top 5 active users on all :");
        
        for(int i:userID){
            System.out.println("User ID "+i+", ");
        }
        
    }
    
    
  
    
    
    
    
    
    
    
    
    
}
