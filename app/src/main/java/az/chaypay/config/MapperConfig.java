package az.chaypay.config;

import az.chaypay.profile.mapper.ProfileMapper;
import az.chaypay.review.mapper.ReviewMapper;
import az.chaypay.transaction.mapper.TransactionMapper;
import az.chaypay.user.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return UserMapper.INSTANCE;
    }

    @Bean
    public ReviewMapper reviewMapper() {
        return ReviewMapper.INSTANCE;
    }

    @Bean
    public TransactionMapper transactionMapper() {
        return TransactionMapper.INSTANCE;
    }

    @Bean
    ProfileMapper profileMapper() {
        return ProfileMapper.INSTANCE;
    }
}
