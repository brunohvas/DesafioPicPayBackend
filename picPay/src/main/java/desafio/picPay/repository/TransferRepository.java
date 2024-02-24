package desafio.picPay.repository;

import desafio.picPay.domain.trasnfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
