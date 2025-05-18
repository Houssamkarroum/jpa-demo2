package ma.abdellah.jpademo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="USERS")
public class User {
    @Id
    private String userId;
    @Column(name = "USER_NAME", unique=true,length = 20)
    private String username;
    private String password;
    //quand on choisi pour l'attribut fetch EAGER cela nous permet a chaque fois on charge un user on charge ave lui les roles
    //par defaut si on mode lazy
    //si on a choisi EAGER il faut initialiser la variable pour ne pas avoir une exception NULLPOINTEREXCPTION
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();
}
