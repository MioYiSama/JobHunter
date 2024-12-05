package top.mioyi.entities;

import lombok.*;


@Data
@Builder
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