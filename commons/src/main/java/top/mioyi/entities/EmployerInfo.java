package top.mioyi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerInfo {
    @NonNull
    private Long id;

    @NonNull
    private Long employerId;

    /**
     * 公司名称
     */
    private String company;
}