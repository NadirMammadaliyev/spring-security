package az.nadir.restapi.model.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendMessage {
    private String name;
    private String surname;
    private String email;
    private String subject;
    private String body;
    private int count;
}
