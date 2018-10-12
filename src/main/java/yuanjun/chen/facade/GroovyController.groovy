package yuanjun.chen.facade

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class GroovyController {
    @RequestMapping(value = "/gg", method = RequestMethod.GET)
    def helloGroovy() {
        return ResponseEntity.ok().body("haha I am from groovy again!");
    }
}
