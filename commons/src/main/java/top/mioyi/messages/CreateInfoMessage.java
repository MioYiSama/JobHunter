package top.mioyi.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.mioyi.types.Role;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CreateInfoMessage implements Serializable {
    private Role role;

    private Long userId;
}
