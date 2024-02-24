package desafio.picPay.domain.user;

import desafio.picPay.domain.enums.Type;
import desafio.picPay.domain.trasnfer.Transfer;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private Long document;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private Float balance;
    @Column(nullable = false)
    private Type type;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Transfer> transfers = new HashSet<>();

    public User(UserDTO userDTO) {
        this.document = userDTO.document();
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.balance = userDTO.balance();
        this.type = userDTO.type();
    }
}
