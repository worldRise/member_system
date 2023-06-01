package com.auther.fan.member_system.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "score_id", type = IdType.AUTO)
    private Integer scoreId;

    private String memberId;

    private LocalDateTime updateTime;

    private Integer preScore;

    private Integer score;

    private Integer afterScore;

    private String scoreReason;

    private String scoreNote;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPreScore() {
        return preScore;
    }

    public void setPreScore(Integer preScore) {
        this.preScore = preScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAfterScore() {
        return afterScore;
    }

    public void setAfterScore(Integer afterScore) {
        this.afterScore = afterScore;
    }

    public String getScoreReason() {
        return scoreReason;
    }

    public void setScoreReason(String scoreReason) {
        this.scoreReason = scoreReason;
    }

    public String getScoreNote() {
        return scoreNote;
    }

    public void setScoreNote(String scoreNote) {
        this.scoreNote = scoreNote;
    }

    @Override
    public String toString() {
        return "Score{" +
            "scoreId = " + scoreId +
            ", memberId = " + memberId +
            ", updateTime = " + updateTime +
            ", preScore = " + preScore +
            ", score = " + score +
            ", afterScore = " + afterScore +
            ", scoreReason = " + scoreReason +
            ", scoreNote = " + scoreNote +
        "}";
    }
}
