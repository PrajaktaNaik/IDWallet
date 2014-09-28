package model

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import scala.collection.JavaConversions._
import scala.beans.BeanProperty
import com.fasterxml.jackson.annotation.JsonProperty

class WebLogin( @JsonProperty("url")@BeanProperty var url : String,
  @JsonProperty("login")@BeanProperty var login : String,
  @JsonProperty("password")@BeanProperty var password : String){
  @BeanProperty var login_id : Int = this.hashCode()
  
}

