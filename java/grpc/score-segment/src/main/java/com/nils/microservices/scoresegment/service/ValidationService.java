package com.nils.microservices.scoresegment.service;

import com.nils.gprc.scoresegment.ScoreSegmentErrorCode;
import com.nils.microservices.scoresegment.exception.ScoreSegmentException;
import org.springframework.stereotype.Service;


@Service
public class ValidationService {

    public void validateIdNumber(long idNumber) {
        checkIfNull(idNumber);
        checkIfValid(idNumber);
    }

    private void checkIfNull(long idNumber) {
        if (idNumber == 0) {
            throw new ScoreSegmentException(ScoreSegmentErrorCode.ID_NUMBER_CANNOT_BE_NULL);
        }
    }

    private void checkIfValid(long idNumber) {
        if (idNumber == 0) {
            throw new ScoreSegmentException(ScoreSegmentErrorCode.INVALID_ID_NUMBER_VALUE);
        }
    }
}
