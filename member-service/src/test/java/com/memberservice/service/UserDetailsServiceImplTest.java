package com.memberservice.service;

import com.memberservice.entity.Member;
import com.memberservice.entity.User;
import com.memberservice.repository.MemberRepository;
import com.memberservice.repository.UserRepository;
import com.memberservice.security.services.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

    @InjectMocks
    UserDetailsServiceImpl userDetailsService;

    @Mock
    MemberRepository repository;

    @Test
    public void test(){
        Member member = new Member();
        member.setEmail("abc");
        member.setName("name");
        member.setAddress("bangalore");
        member.setContactNumber(12345);
        member.setDob(new Date());
        member.setMemberId(123);
        member.setPassword("password");
        Mockito.when(repository.findByName("name")).thenReturn(Optional.of(member));
        userDetailsService.loadUserByUsername("name");
        Assert.notNull(member,"");
    }
}
