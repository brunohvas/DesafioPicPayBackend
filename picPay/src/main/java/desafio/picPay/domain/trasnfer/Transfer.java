package desafio.picPay.domain.trasnfer;

import desafio.picPay.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity(name = "transfers")
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Transfer {

    private Long id;
    private Long transferId;
    private Float value;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
