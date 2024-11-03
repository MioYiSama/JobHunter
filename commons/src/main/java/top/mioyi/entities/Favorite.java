package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    @NonNull
    private Long id;

    @NonNull
    private Long userId;

    @NonNull
    private Long positionId;
}