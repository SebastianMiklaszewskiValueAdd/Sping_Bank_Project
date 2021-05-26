package com.example.spring_bank_project.account.infrastructure.adapter.encoder;

import com.example.spring_bank_project.account.application.useCase.addNewUser.PinEncoder;
import com.example.spring_bank_project.shared.domain.valueObject.EncodedPin;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPinEncoder implements PinEncoder {
    private final BCryptPasswordEncoder encoder;

    public BCryptPinEncoder() {
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public EncodedPin encode(Pin pin) {
        var encodedPin = this.encoder.encode(pin.getPin());

        return new EncodedPin(encodedPin);
    }

    @Override
    public boolean match(Pin pin, EncodedPin encodedPin) {
        return this.encoder.matches(pin.getPin(), encodedPin.getEncodedPin());
    }
}
