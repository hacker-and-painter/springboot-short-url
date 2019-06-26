package org.hackerandpainter.web;

import org.hackerandpainter.data.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yongliu on 7/11/18.
 */

@Api(
  value = "Greeting",
  position = 1,
  description = "Greeting Test"
)
@RestController
public class EchoController {


  @ApiOperation(
    value = "Greeting",
    consumes = "application/json, application/xml",
    produces = "application/json, application/xml",
    httpMethod = "GET"
  )

  @ApiResponses({
    @ApiResponse(code = 200, message = "PONE", response = Greeting.class),
    @ApiResponse(code = 400, message = "-1", response = org.hackerandpainter.data.ApiResponse.class)
  })

  @RequestMapping(value = "/ping", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Greeting> ping(){
    return ResponseEntity.ok(new Greeting("PONE"));
  }

}
