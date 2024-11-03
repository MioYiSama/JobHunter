package top.mioyi.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mioyi.dto.UserDTO;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse implements Serializable {
    private UserDTO user;

    private String message;
}
