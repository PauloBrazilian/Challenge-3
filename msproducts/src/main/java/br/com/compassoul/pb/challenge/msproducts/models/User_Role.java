package br.com.compassoul.pb.challenge.msproducts.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_roleId;

    @Column(name = "roleId")
    private Role roleId;

    @Column(name = "userId")
    private User userId;

    @Override
    public String toString() {
        return "User_Role{" +
                "user_roleId=" + user_roleId +
                ", roleId=" + roleId +
                ", userId=" + userId +
                '}';
    }
}