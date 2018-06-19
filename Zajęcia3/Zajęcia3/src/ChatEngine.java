import java.util.HashMap;
import java.util.Map;

/**
 * Created by kprzenio on 2018-03-13.
 */
public class ChatEngine
{

    Map<Integer, User> users = new HashMap<>();
    int number = 0;
    void loginUser(User user) throws UserLoginException
    {
        if(hasUser(user.name))
            throw new UserLoginException();
        number++;
        users.put(number ,user);
    }
    void logoutUser(User user) throws UserRemoveException
    {
        if(!hasUser(user.name))
            throw new UserRemoveException();
        users.remove(user);
    }
    int getNumberOfUsers()
    {
        return users.size();
    }
    void addUserStar(String userName)
    {
        for(Map.Entry<Integer,User> set : users.entrySet())
        {
            if(set.getValue().compareTo(userName) == 1)
                set.getValue().setNumberOfStars(set.getValue().getNumberOfStars()+1);
        }
    }
    void removeUserStar(String userName)
    {
        for(Map.Entry<Integer,User> set : users.entrySet())
        {
            if(set.getValue().compareTo(userName) == 1)
                set.getValue().setNumberOfStars(set.getValue().getNumberOfStars()-1);
        }
    }
    boolean hasUser(long userId)
    {
        for( Map.Entry<Integer,User> set : users.entrySet() )
        {
            if(set.getValue().compareTo(userId) == 1)
                return true;
        }
    }
    boolean hasUser(String userName)
    {

        for(Map.Entry<Integer,User> set : users.entrySet())
        {
            if(set.getValue().compareTo(userName) == 1)
                return true;
        }
    }
}
