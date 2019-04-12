package com.codeoftheweb.salvo;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;
    private String userName;

    public Player() {

    }

    public Player(String user) {

        this.userName = user;
    }


    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName)
    {

        this.userName = userName;
    }

    public long getId() {


        return id;
    }

    public void setId(long id) {

        this.id = id;
    }
}




