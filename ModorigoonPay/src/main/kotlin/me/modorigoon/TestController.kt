package me.modorigoon

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController {

    @GetMapping("/hi")
    fun hi(): ResponseEntity<String> {
        return ResponseEntity.ok("hi!")
    }
}
