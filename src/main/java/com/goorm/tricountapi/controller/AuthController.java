package com.goorm.tricountapi.controller;

import com.goorm.tricountapi.dto.LoginRequest;
import com.goorm.tricountapi.dto.SignupRequest;
import com.goorm.tricountapi.model.ApiResponse;
import com.goorm.tricountapi.model.Member;
import com.goorm.tricountapi.service.MemberService;
import com.goorm.tricountapi.util.TricountApiConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<Member> signup(@Valid @RequestBody SignupRequest request) {
        Member member = Member.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .name(request.getName())
                .build();
        return new ApiResponse<Member>().ok(memberService.signup(member));
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse login(
            @Valid @RequestBody LoginRequest loginRequest,
            HttpServletRequest request, HttpServletResponse response
    ) {
        Member loginMember = memberService.login(loginRequest.getLoginId(), loginRequest.getPassword());

        // 로그인 성공 처리 - 쿠키 생성
        Cookie idCookie = new Cookie(TricountApiConst.LOGIN_MEMBER_COOKIE, String.valueOf(loginMember.getId()));
        response.addCookie(idCookie);

        return new ApiResponse().ok();
    }

    // 로그아웃
    @PostMapping("/logout")
    public ApiResponse logout(HttpServletResponse response) {
        memberService.logout(response);
        return new ApiResponse().ok();
    }
}
