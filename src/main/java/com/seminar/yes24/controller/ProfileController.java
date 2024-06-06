package com.seminar.yes24.controller;

import com.seminar.yes24.aspect.annotation.DoAopError;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final Environment env;
    private static final String NULL = "";

    @GetMapping("/profile")
    @DoAopError
    public String getProfile(
            @RequestBody String name
    ) {
        throw new NullPointerException();

    }
}