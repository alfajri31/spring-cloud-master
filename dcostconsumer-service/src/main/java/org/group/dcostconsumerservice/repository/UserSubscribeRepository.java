package org.group.dcostconsumerservice.repository;

import org.group.dcostconsumerservice.entity.UserSubscribe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSubscribeRepository extends MongoRepository<UserSubscribe, String> {
    Optional<UserSubscribe> findByDigitalPaymentId(
            String digitalPaymentId);
    Optional<UserSubscribe> findByUserIdAndDigitalPaymentIdAndCurrentDate(
            String userId,String paymentId,String currentDate);
    Optional<UserSubscribe> findByCurrentDateAndDigitalPaymentId(
            String currentDate,String
            digitalPaymentId);
}

