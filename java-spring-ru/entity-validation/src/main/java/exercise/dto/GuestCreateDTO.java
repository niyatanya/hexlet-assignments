package exercise.dto;

// BEGIN
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Future;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Size;

@Getter
@Setter
public class GuestCreateDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "\\+[0-9]*")
    @Size(min = 12, max = 14)
    private String phoneNumber;

    @Pattern(regexp = "[0-9]*")
    @Size(min = 4, max = 4)
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;
}
// END
