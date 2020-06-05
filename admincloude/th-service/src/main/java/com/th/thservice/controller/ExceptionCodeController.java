package com.th.thservice.controller;

import com.th.thservice.entity.ExceptionCode;
import com.th.thservice.http.HttpResult;
import com.th.thservice.page.PageRequest;
import com.th.thservice.page.PageResult;
import com.th.thservice.service.ExceptionCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exCode")
public class ExceptionCodeController {
    @Autowired
    ExceptionCodeService codeService;
    @PreAuthorize("hasAuthority('ex:code:view')")
    @PostMapping(value="/view")
    public HttpResult view(@RequestBody PageRequest pageRequest) {
        PageResult page = codeService.findPage(pageRequest);
        return HttpResult.ok(page);
    }
    @PreAuthorize("hasAuthority('ex:code:delete')")
    @PostMapping(value="/del")
    public HttpResult del(@RequestBody List<ExceptionCode> exceptionCodes) {

        return HttpResult.ok(codeService.delete(exceptionCodes));
    }
    @PreAuthorize("hasAuthority('ex:code:add') and hasAuthority('ex:code:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody ExceptionCode exceptionCode) {

        return HttpResult.ok(codeService.save(exceptionCode));
    }
}
