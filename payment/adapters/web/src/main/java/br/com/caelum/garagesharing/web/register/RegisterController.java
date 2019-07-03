package br.com.caelum.garagesharing.web.register;

import static org.springframework.http.ResponseEntity.created;

import br.com.caelum.garagesharing.payment.domain.Payment;
import br.com.caelum.garagesharing.payment.register.in.PaymentCommand;
import br.com.caelum.garagesharing.payment.register.in.PaymentId;
import br.com.caelum.garagesharing.payment.register.in.RegisterUseCase;
import java.math.BigDecimal;
import java.net.URI;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
class RegisterController {
    private final RegisterUseCase registerUseCase;

    RegisterController(RegisterUseCase registerUseCase) {
        this.registerUseCase = registerUseCase;
    }

    @PostMapping("/{buyerId}/payments")
    ResponseEntity<?> create(@PathVariable Long buyerId, @RequestBody @Valid AmountRequest amountRequest, UriComponentsBuilder uriBuilder) {
        PaymentCommand command = new PaymentCommand(buyerId, amountRequest.getAmount());

        PaymentId paymentId = registerUseCase.registerPaymentBy(command);

        URI uri = uriBuilder.path("/{buyerId}/payments/{paymentId}").build(buyerId, paymentId.get());

        return created(uri).build();
    }

    static class AmountRequest {
        @NotNull
        @DecimalMin("1.0")
        private BigDecimal amount;

        /**
         * @deprecated frameworks only
         */
        @Deprecated
        private AmountRequest() {
        }

        public AmountRequest(BigDecimal amount) {
            this.amount = amount;
        }

        BigDecimal getAmount() {
            return amount;
        }
    }
}
