package com.vengeang.springsecurity.controller;


import com.vengeang.springsecurity.model.Notice;
import com.vengeang.springsecurity.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class NoticesController {

    private final NoticeRepository noticeRepository;
    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> welcome() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(notices);
    }
}
