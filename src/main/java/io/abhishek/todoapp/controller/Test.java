package io.abhishek.todoapp.controller;

import io.abhishek.todoapp.dtos.TestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author abhishek-m-gowda12
 */

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Test {
    @PostMapping("/test")
    @PreAuthorize("hasRole('ADMIN')")
    public TestDto refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        return new TestDto(1L,"a1");
    }
}
