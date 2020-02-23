package app.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "result_prediction")
public class ResultPrediction extends BaseEntity implements Serializable {
    private PredictionEnum prediction;

    public ResultPrediction() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "prediction")
    public PredictionEnum getPrediction() {
        return prediction;
    }

    public void setPrediction(PredictionEnum prediction) {
        this.prediction = prediction;
    }
}
