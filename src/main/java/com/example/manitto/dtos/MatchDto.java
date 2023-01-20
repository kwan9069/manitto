package com.example.manitto.dtos;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
public class MatchDto {
    private Long id;
    private Timestamp matchYmd;
    @NonNull
    private Boolean result;
    @NonNull
    private Boolean archived;
    @NonNull
    private Integer round;
    private MatchDto instance;

    public Update toUpdateDto(Update update) {
        Update target = new Update();
        if (update.getResult()!=null) target.setResult(update.getResult());
        if (update.getArchived()!=null) target.setArchived(update.getArchived());
        return target;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class Update {
        private Boolean result;
        private Boolean archived;

        public Update() {
            this.result = instance.getResult();
            this.archived = instance.getArchived();
        }
    }
}
