/**
 * Created by kprzenio on 2018-03-13.
 */
public class User implements Comparable<User>
{
    long id;
    String name;
    long numberOfStars;
    long numberOfSentMessages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String newName)
    {
        name = newName;
    }

    public long getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(long numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public long getNumberOfSentMessages() {
        return numberOfSentMessages;
    }

    public void setNumberOfSentMessages(long numberOfSentMessages) {
        this.numberOfSentMessages = numberOfSentMessages;
    }

    @Override
    public int compareTo(User o)
    {
        return compareTo(o.id);
    }

    public int compareTo(String name)
    {
        if(this.name == name)
        {
            return 1;
        }
        else
            return 0;
    }
    public int compareTo(long id)
    {
        if(this.id == id)
        {
            return 1;
        }
        else
            return 0;
    }
}
