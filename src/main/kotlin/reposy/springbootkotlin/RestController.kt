package reposy.springbootkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {

    @GetMapping("")
    fun index(): String {
        return "Hello World"
    }
}