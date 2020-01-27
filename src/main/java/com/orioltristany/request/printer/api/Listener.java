package com.orioltristany.request.printer.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

@RestController
public class Listener {

    @PostMapping
    public ResponseEntity<String> manageRequest(HttpServletRequest httpServletRequest) throws IOException {
        System.out.println("----------------");
        System.out.println("HTTP Method: " + httpServletRequest.getMethod());
        Collections.list(httpServletRequest.getHeaderNames())
                .forEach(h -> System.out.println("Header " + h + ": " + httpServletRequest.getHeader(h)));
        if (httpServletRequest.getInputStream() != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
            String readLine;
            while (((readLine = br.readLine()) != null)) {
                System.out.println(readLine);
            }
        }
        System.out.println("----------------");
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}
