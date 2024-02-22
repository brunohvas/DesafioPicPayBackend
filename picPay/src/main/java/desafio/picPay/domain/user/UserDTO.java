package desafio.picPay.domain.user;

import desafio.picPay.domain.enums.Type;

public record UserDTO(Long id, Long document, String name, String email, Float balance, Type type ) {
}
